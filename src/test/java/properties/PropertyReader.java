package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
     Properties properties=new Properties();

    public PropertyReader() throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("/Users/prajwal/Desktop/testvagrant /assignment projects/Design-Pattern-Practice/src/main/java/properties/tavelInformation.properties");
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public   String getProperty(String key){
        return properties.getProperty(key);
    }
}
