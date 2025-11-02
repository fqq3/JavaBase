package main.fqq.utill;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: fqq
 * @Date: 2025/7/17 - 07 - 17 - 1:55
 * @Description: com.fqq.utill
 * @version: 1.0
 */
public class PropertiesUtill {
    private Properties properties;
    public PropertiesUtill(String path){
        properties =new Properties();
        InputStream inputStream=this.getClass().getResourceAsStream(path);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getProperties(String key){
        return properties.getProperty(key);
    }
}
