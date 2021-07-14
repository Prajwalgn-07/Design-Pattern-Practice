package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
     Properties properties=new Properties();

    /**
     * This constructor will load the travelInformation property file
     * @throws FileNotFoundException
     */
    public PropertyReader() throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("/Users/prajwal/Desktop/testvagrant /assignment projects/Design-Pattern-Practice/src/test/java/properties/tavelInformation.properties");
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param key
     * @return it will return the key value
     */
    public   String getProperty(String key){
        return properties.getProperty(key);
    }
}
