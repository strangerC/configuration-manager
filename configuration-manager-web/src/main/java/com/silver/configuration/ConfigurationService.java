/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.silver.configuration;

import com.silver.configuration.reopsitory.ConfigurationRepository;

/**
 *
 * @author Liaojian
 */
public class ConfigurationService {
    public static ConfigurationRepository CR = new ConfigurationRepository();
    private static ConfigurationRepository repos = new ConfigurationRepository();

    public static ConfigurationRepository getBean(String reposName) {
        return repos;
    }
    
    
}
