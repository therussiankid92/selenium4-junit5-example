package tests;

import framework.config.PropertiesActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static framework.config.PropertyRetriever.getBaseUrl;
import static framework.auxiliaryMethods.AuxiliaryMethods.*;
import static framework.driver.GlobalDriverManager.resetDriver;

/*
 * Main Test class, from where other tests classes should extend. Should contain hooks, and common elements desired for the classes that extend it.
 */

public class MainTest {

    /*
     * Executed before each of the tests
     */
    @BeforeEach
    public void beforeTest() {
        loadProperties();
        maximizeWindow();
        openUrl(getBaseUrl());
    }

    /*
     * Executed after each of the tests
     */
    @AfterEach
    public void afterTest() {
        resetDriver();
    }

    /*
     * Loading the configuration with different variables from properties.
     * This can be future on extended to read a system parameter (eg: environment), and then load the corresponding
     * properties.
     */
    private void loadProperties() {
        PropertiesActions propertiesActions = new PropertiesActions();
        Properties propertiesFromFile = propertiesActions.retrievePropertiesFromFile("config.properties");
        PropertiesActions.loadProperties(propertiesFromFile);
    }
}