package org.example.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties  implements  CustomProperties  {
    private static Logger propertiesLogger = LogManager.getLogger(MyProperties.class);
    private  String propertiesName = "paths.properties";
    private MyProperties(){

    }
    public static  MyProperties start( ){
        return new MyProperties();
    }

    private MyProperties(String propertiesName){
       this.propertiesName = propertiesName;
    }
    public static  MyProperties start( String propertiesName ){
        return new MyProperties(propertiesName);
    }

    @Override
    public String getProperties(String key) {
        InputStream is = MyProperties.class.getClassLoader().getResourceAsStream(propertiesName);

        if(is == null){
            propertiesLogger.error(propertiesName + " file do not exist");
            propertiesLogger.debug(propertiesName + " file do not exist");
        }

        Properties properties = new Properties();
        try {
            properties.load(is);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  properties.getProperty(key);
    }
}
