package com.silver.configuration.builder;

import java.util.Map;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.builder.ReloadingFileBasedConfigurationBuilder;

/**
 *
 * @author Liaojian
 */
public class PropertiesConfigurationBuilder extends ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>{
    
    public PropertiesConfigurationBuilder(Class resCls) {
        super(resCls);
    }
    
    public PropertiesConfigurationBuilder(Class resCls,
            Map<String, Object> params) {
        super(resCls, params);
    }
    
    public PropertiesConfigurationBuilder(Class resCls,
            Map<String, Object> params, boolean allowFailOnInit) {
        super(resCls, params, allowFailOnInit);
    }
}
