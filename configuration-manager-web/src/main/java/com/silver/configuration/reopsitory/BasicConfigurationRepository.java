/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.configuration.reopsitory;

import com.silver.configuration.exception.ConfigurationErrorCode;
import com.silver.wheel.common.exception.CodedRuntimeException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.builder.BuilderParameters;

/**
 *
 * @author Liaojian
 */
public abstract class BasicConfigurationRepository {
    /**
     * 内置的CombinedConfiguration，作为所有配置对象的库。
     */
    private CombinedConfiguration container = new CombinedConfiguration();
    
    public  <T extends Configuration> T createConfiguration(String configName, Class<T> clazz, 
            BuilderParameters parameters) {   
        if (containsConfiguration(configName)) {
                throw new CodedRuntimeException(ConfigurationErrorCode.CONFIGURATION_IS_EXISTING,
                        String.format("A configuration with the name %s already exists in this combined configuration!", 
                        configName));
        } else {
            T config = createConfigurationInternal(configName,clazz, parameters);
            container.addConfiguration(config, configName);
            return config;
        }
    }
    
    protected abstract <T extends Configuration> T  createConfigurationInternal(String configName, Class<T> clazz, 
            BuilderParameters parameters);

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public boolean containsKey(String key) {
        return container.containsKey(key);
    }
    
    public boolean containsConfiguration(String configName) {
        return (container.getConfiguration(configName) != null);
    }
    
    public List<String> getConfigurationNameList() {
        return container.getConfigurationNameList();
    }
    
    public CombinedConfiguration getContainer() {
        return container;
    }

    public Object getProperty(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterator<String> getKeys(String prefix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterator<String> getKeys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Properties getProperties(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getBoolean(String key) {
        return container.getBoolean(key);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return container.getBoolean(key, defaultValue);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return container.getBoolean(key, defaultValue);
    }

    public byte getByte(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public byte getByte(String key, byte defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Byte getByte(String key, Byte defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getDouble(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getDouble(String key, double defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Double getDouble(String key, Double defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getFloat(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getFloat(String key, float defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Float getFloat(String key, Float defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInt(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInt(String key, int defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getInteger(String key, Integer defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getLong(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getLong(String key, long defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getLong(String key, Long defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public short getShort(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public short getShort(String key, short defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Short getShort(String key, Short defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigDecimal getBigDecimal(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigInteger getBigInteger(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigInteger getBigInteger(String key, BigInteger defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getString(String key) {
        return container.getString(key);
    }

    public String getString(String key, String defaultValue) {
        return container.getString(key, defaultValue);
    }

    public String[] getStringArray(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> getList(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> getList(String key, List<Object> defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> T get(Class<T> cls, String key) {
        return container.get(cls, key);
    }

    public <T> T get(Class<T> cls, String key, T defaultValue) {
        return container.get(cls, key, defaultValue);
    }

    public Object getArray(Class<?> cls, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getArray(Class<?> cls, String key, Object defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> List<T> getList(Class<T> cls, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> List<T> getList(Class<T> cls, String key, List<T> defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> Collection<T> getCollection(Class<T> cls, String key, Collection<T> target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> Collection<T> getCollection(Class<T> cls, String key, Collection<T> target, Collection<T> defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
