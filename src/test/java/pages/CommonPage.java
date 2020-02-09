package pages;


import static framework.driver.GlobalDriverManager.retrieveDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

/*
 * Using Page Object Model Test Code Architecture Pattern. From this class, other pages are extended.
 * This class should include, though, common elements for all the pages.
 */

class CommonPage {

    CommonPage() {
        initElements(retrieveDriver(), this);
    }
}