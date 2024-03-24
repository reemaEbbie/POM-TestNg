package SDA.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    /*
    The ConfigurationReader class facilitates communication between our test methods and the Configuration.properties file.
    This class contains a static method to easily access it from test classes.
    Since the method is static, the variable we call from within the method should also be static.
    We use a static block to assign the initial value to the static variable (instantiate).

    */
    public static Properties properties;   // Create a Properties instance

    static {
        String filePath = "config.Properties";  // Path of the configuration file
        try {
            FileInputStream fis = new FileInputStream(filePath);
            // fis reads the file path of the configuration.properties file
            properties = new Properties();
            properties.load(fis); // Load the information read by fis into properties
            // Close the file
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
    /*
      Takes the string key value sent from the test method and,
      using the getProperty() method from the Properties class,
      retrieves the String data-type value associated with this key.
      We create this method to read the file.
     */
        return properties.getProperty(key);
    }
}