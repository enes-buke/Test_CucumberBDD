package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    static {
        String filePath = "config.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        }catch (IOException e){
            System.out.println("Error reading config file");
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);

    }
}
