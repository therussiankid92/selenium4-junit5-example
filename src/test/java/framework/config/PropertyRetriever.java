package framework.config;


import static framework.config.PropertiesActions.retrieveProperties;

/*
 * This class is the interface to access the defined configuration properties.
 * Other classes should read the properties just from here
 */
public class PropertyRetriever {

    /*
     * Method to retrieve specific property from loaded properties
     */
    public static String getDesiredBrowser() {
        return retrieveProperties().getProperty("desired.browser");
    }

    public static String getBaseUrl() {
        return retrieveProperties().getProperty("base.url");
    }

}