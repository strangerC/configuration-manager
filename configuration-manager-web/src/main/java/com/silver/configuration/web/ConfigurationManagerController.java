package com.silver.configuration.web;

import com.silver.configuration.ConfigurationService;
import com.silver.configuration.reopsitory.ConfigurationRepository;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.beanutils.BeanHelper;
import org.apache.commons.configuration.builder.PropertiesBuilderParametersImpl;
import org.apache.commons.configuration.ex.ConfigurationException;
import org.apache.commons.configuration.io.FileHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Liaojian
 */
@Controller
@RequestMapping(value = "/configuration")
public class ConfigurationManagerController {
    
    @RequestMapping(value = "/list")
    public String list(Model model) {
        ConfigurationRepository repos = ConfigurationService.getBean(null);
        List<String> configNames = repos.getConfigurationNameList();
        
        Map<String, Class<? extends Configuration>> configTypes = repos.getConfigurationTypes();
        
        model.addAttribute("nameList", configNames);
        model.addAttribute("configurations", configTypes);
        model.addAttribute("configurationSize", configNames.size());
        
        return "configuration.list";
    }
    
    @RequestMapping(value = "doCreate")
    public String doCreate(String configName, String configPath, Model model) throws ConfigurationException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(configPath);
        
        if(url == null) {
            model.addAttribute("message", "配置对象路径错误！");
            return "configuration.create";
        }
        
        PropertiesBuilderParametersImpl params = new PropertiesBuilderParametersImpl();  
        params.setBeanHelper(BeanHelper.INSTANCE);
        
        FileHandler handler = params.getFileHandler();   
        handler.setURL(url); 
                        
        ConfigurationRepository repos = ConfigurationService.getBean(configName);
        repos.createConfiguration(configName, PropertiesConfiguration.class, params);
        
        return list(model);                
    }
    
    @RequestMapping(value = "create")
    public String create() {
        return "configuration.create";
    }
}
