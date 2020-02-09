package framework.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/*
 * This class contains all the actions in order to work with the configuration properties.
 */
public class PropertiesActions {

    private static Properties properties;

    public PropertiesActions() {
    }

    /*
     * Reads the properties file in the classpath based on the propertiesFileName and returns in the java properties
     * format.
     */
    public Properties retrievePropertiesFromFile(String propertiesFileName) {
        InputStream dataInPropertyFile = null;
        Properties properties = new Properties();
        try {
            dataInPropertyFile = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            if (dataInPropertyFile != null) {
                properties.load(dataInPropertyFile);
            } else {
                throw new FileNotFoundException("Ooops! The desired propertiesFileName was not found!");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Ooops! Couldn't retrieve the desired properties due to an IOException!");
        } finally {
            try {
                assert dataInPropertyFile != null;
                dataInPropertyFile.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return properties;
    }

    /*
     * Loading of Properties in Memory. Needs to have them loaded first.
     */

    public static void loadProperties(Properties properties) {
        PropertiesActions.properties = properties;
    }

    /*
     * Retrieves all the already loaded properties. Needs to have them loaded first.
     */
    static Properties retrieveProperties() {
        if (properties == null) {
            throw new IllegalStateException("Ooops! Looks like you haven't loaded the properties");
        }
        return properties;
    }

}