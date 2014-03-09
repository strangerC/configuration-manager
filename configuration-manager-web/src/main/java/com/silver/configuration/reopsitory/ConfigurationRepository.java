package com.silver.configuration.reopsitory;

import com.silver.configuration.ConfigurationService;
import com.silver.configuration.builder.PropertiesConfigurationBuilder;
import com.silver.configuration.exception.ConfigurationErrorCode;
import com.silver.wheel.common.exception.CodedRuntimeException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.beanutils.BeanHelper;
import org.apache.commons.configuration.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration.builder.BuilderParameters;
import org.apache.commons.configuration.builder.PropertiesBuilderParametersImpl;
import org.apache.commons.configuration.ex.ConfigurationException;
import org.apache.commons.configuration.io.FileHandler;

/**
 *
 * @author Liaojian
 */
public class ConfigurationRepository extends BasicConfigurationRepository{        

    private Map<Class<? extends Configuration>, BasicConfigurationBuilder> builders =
            new HashMap<Class<? extends Configuration>, BasicConfigurationBuilder>();
    private Map<String, Class<? extends Configuration>> configTypes =
            new HashMap<String, Class<? extends Configuration>>();

    public ConfigurationRepository() {         
        builders.put(PropertiesConfiguration.class, new PropertiesConfigurationBuilder(PropertiesConfiguration.class));
    }
    
    @Override
    protected <T extends Configuration> T  createConfigurationInternal(String configName, Class<T> clazz,
            BuilderParameters parameters) {

        BasicConfigurationBuilder<T> builder = builders.get(clazz);

        if (builder != null) {
            try {
                builder.reset();
                builder.configure(parameters);
                
                T config = builder.getConfiguration();                
                
                configTypes.put(configName, clazz);     
                
                return config;
            } catch (ConfigurationException ex) {
                throw new CodedRuntimeException(ConfigurationErrorCode.APACHE_CONFIGURATION, ex);
            }
        } else {
            throw new CodedRuntimeException(ConfigurationErrorCode.CONFIGURATION_BUILDER_IS_NOT_EXISTING, 
                    String.format("configuration builder for [%s] is not existing!", clazz));            
        }
    }
    
    public Map<String, Class<? extends Configuration>> getConfigurationTypes() {
        return configTypes;
    }
    /*
    public Configuration updateConfiguration(String configName) {
        Configuration configuration = repository.getConfiguration(configName);
        if (configuration != null) {
            return configuration;
        } else {
            return null;
        }
    }
    
    public Map<String, Configuration> getConfigurations() {
        Map<String, Configuration> configMap = new HashMap<String, Configuration>();
        List<String> nameList = repository.getConfigurationNameList();

        for (String name : nameList) {
            configMap.put("name", repository.getConfiguration(name));
        }

        return configMap;
    }
    */

    public static void main(String[] args) throws IOException, ConfigurationException {                 
        PropertiesBuilderParametersImpl params = new PropertiesBuilderParametersImpl();  
        params.setBeanHelper(BeanHelper.INSTANCE);
        
        FileHandler handler = params.getFileHandler();   
        handler.setURL(Thread.currentThread().getContextClassLoader().getResource("config/test/app.properties")); 
        
        ConfigurationRepository repos = ConfigurationService.CR;
        PropertiesConfiguration config = repos.createConfiguration("app", PropertiesConfiguration.class, params);
        System.out.println(config);
        System.out.println(config.getString("app.name"));
        
        params = new PropertiesBuilderParametersImpl();  
        params.setBeanHelper(BeanHelper.INSTANCE);
        
        handler = params.getFileHandler();   
        handler.setURL(Thread.currentThread().getContextClassLoader().getResource("config/test/db.properties")); 
        config = repos.createConfiguration("db", PropertiesConfiguration.class, params);
        System.out.println(config);
        System.out.println(config.getString("db.name"));
        
        System.out.println(repos.getString("db.type"));
    }
}
