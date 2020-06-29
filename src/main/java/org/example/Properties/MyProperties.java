package org.example.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties implements  CustomProperties {

    private MyProperties(){

    }
    public static  MyProperties start(){
        return new MyProperties();
    }

    @Override
    public String getProperties(String key)  {
        InputStream is = MyProperties.class.getClassLoader().getResourceAsStream("paths.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  properties.getProperty(key);
    }
}
