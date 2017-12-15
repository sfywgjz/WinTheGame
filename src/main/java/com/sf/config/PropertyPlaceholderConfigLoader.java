package com.sf.config;



import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyPlaceholderConfigLoader extends PropertyPlaceholderConfigurer{
	
	  @Override
      protected void processProperties (
                 ConfigurableListableBeanFactory beanFactoryToProcess,
                 Properties props) throws BeansException{
            if (props != null) {

                  // Put all the entries to configurations store.
                 Set< Object> proKeys = props.keySet();
                 ConcurrentHashMap< String, String > proStore = new ConcurrentHashMap<String , String>();
                  for(Object pkey : proKeys){
                       String settingItem = (String)pkey ;
                       String settingItemValue = props.getProperty(settingItem );
                       proStore.put(settingItem , settingItemValue);
                       logger.debug("启动加载的属性配置文件key和value："+ settingItem+"-"+settingItemValue);
 
                 }
                 ConfigurationsStore.setProperties( proStore);
           }

            // load all config properties defined in applicationContext.xml
            super.processProperties(beanFactoryToProcess , props);
     }

}
