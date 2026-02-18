package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class Hooks extends CommonMethods {

    public static LoginPage loginPage;

    @Before
    public void setUp() {
        openBrowserAndLaunchApplication();
        loginPage = new LoginPage();
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
