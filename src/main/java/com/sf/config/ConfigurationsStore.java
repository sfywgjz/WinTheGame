package com.sf.config;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class ConfigurationsStore {
	 private static final String PRODUCTS_SETTINGS = "com.expedia.lux.products.featureset/";

     private static final Logger LOGGER = Logger.getLogger(ConfigurationsStore.class);

     private static Map<String, String> m_props = new ConcurrentHashMap<String, String>();
    
     /**
     * Get a configuration value by a key.
     * @param key
     * @return
     */
     public static String getConfigValue(String key){
         
          String configValue = (String)m_props.get(key);
         
          if(null == configValue){
               LOGGER.debug("Configuration missing for config key: " + key);
               return null;
          }
         
          return configValue.trim();
     }
    
     /**
     * Add a configuration key - value pair.
     * NOTE: Don't add a key that already exists in configuration files, the original value will be covered.
     *
     * @param key
     * @param value
     */
     public static void addConfiguration(String key, String value){
         
          m_props.put(key, value);
         
     }
    
     /**
     * Set all the configurations that are loaded on app startup.
     * @param props
     */
     protected static void setProperties(ConcurrentHashMap<String, String> props){
         
          m_props = props;
         
     }
    
     /**
     * Get all the configurations that are loaded on app startup.
     * @param props
     */
     public static Map<String, String> getProperties() {
         
          return m_props;
                   
     }

    
     public static boolean isFeatureOn(String featureName) {
         
          boolean isOn = false;         
          String targetValue = ConfigurationsStore.getConfigValue(PRODUCTS_SETTINGS + featureName);
         
          if("true".equalsIgnoreCase(targetValue)) {
              
               isOn = true;
              
          }
         
          return isOn;
         
     }
    
     /**
     * This method does a lookup and returns the Configuration setting for the supplied 'key' as an integer. If no such key exists or the value cannot be retrieved, the method will return 0 [zero].
     *
     * @param key
     *
     * @return int - The value from Configuration settings as an int  
     *
     */
     public static int getConfigValueAsInteger(String key) {
         
        return NumberUtils.toInt(ConfigurationsStore.getConfigValue(key));

     }
    
     /**
     * This method does a lookup and returns the Configuration setting for the supplied 'key' as an double. If no such key exists or the value cannot be retrieved, the method will return 0 [zero].
     *
     * Convert a String to a double, returning 0.0d if the conversion fails.
     * If the ConfigurationsStore.getConfigValue(key) is null, 0.0d is returned.
     * ConfigurationsStore.getConfigValue(key) =null, return 0.0d
     * ConfigurationsStore.getConfigValue(key) ="", return 0.0d
     * ConfigurationsStore.getConfigValue(key) ="1.5", return 1.5d
     * ConfigurationsStore.getConfigValue(key) ="10", return 10d
     *
     * @param key
     * @return double - The value from Configuration settings as an double  
     *
     */
     public static double getConfigValueAsDouble(String key) {
               return NumberUtils.toDouble(ConfigurationsStore.getConfigValue(key));
     }
    
     /**
     *
     * This method does a lookup and returns the Configuration setting for the supplied 'key' as a boolean. If no such key exists, the value cannot be retrieved, or the value is a string other than 'true', the method will return false.
     *
     * @param key
     *
     * @return bool - The value from Configuration settings as a boolean
     *
     * @see #getConfigValueAsBoolean(String, boolean)
     *
     */
     public static boolean getConfigValueAsBoolean(String key) {
         
          String value = ConfigurationsStore.getConfigValue(key);
          return (value == null) ? false : ("true").equalsIgnoreCase(value);
         
     }

     /**
     * This method does a lookup and returns the Configuration setting for the supplied 'key' as a boolean. If no such key exists, the value cannot be retrieved, or the value is a string other than 'true', the method will return the default value specified by the caller.
     * @param key
     * @param defaults
     * @return
     *
     * @see #getConfigValueAsBoolean(String)
     *
     */
     public static boolean getConfigValueAsBoolean(String key, boolean defaults) {
         
          String value = ConfigurationsStore.getConfigValue(key);
          return (value == null) ? defaults : ("true").equalsIgnoreCase(value);
         
     }
}
