package testscripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.WelcomePage;

public class TC_001 extends BaseTest {

    @Test
    public void TC_001(){

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.setPermission();
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLabTest();
        homePage.bookTest("HbA1c");
        homePage.navigateToHomePage();

    }
}
