package com.silver.configuration.exception;

import com.silver.wheel.common.exception.ErrorCode;

/**
 *
 * @author Liaojian
 */
public enum ConfigurationErrorCode implements ErrorCode{

    APACHE_CONFIGURATION(20140226001L), CONFIGURATION_IS_EXISTING(20140226002L),
    CONFIGURATION_BUILDER_IS_NOT_EXISTING(20140226003L);

    private long codeNumber;
    
    private ConfigurationErrorCode(long codeNumber) {
        this.codeNumber = codeNumber;
    }    
    
    @Override
    public long getCodeNumber() {
        return codeNumber;
    }
    
}
