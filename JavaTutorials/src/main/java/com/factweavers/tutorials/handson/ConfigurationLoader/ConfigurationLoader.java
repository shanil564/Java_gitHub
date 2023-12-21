package com.factweavers.tutorials.handson.ConfigurationLoader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {
        static Properties prop = new Properties();
        static ConfigurationLoader INSTANCE = null;
        static Logger logger = Logger.getLogger(ConfigurationLoader.class);
        private ConfigurationLoader() {
            InputStream input = null;
            try {
                prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            } catch (IOException ex) {
                logger.error(" Error in ConfigurationLoader class -" + ex.getMessage());
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        logger.error(" Error in ConfigurationLoader class -" + e.getMessage());
                    }
                }
            }
        }
        public static ConfigurationLoader getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new ConfigurationLoader();
            }
            return INSTANCE;
        }
        public static Properties getProperties() {
            return prop;
        }
    }

