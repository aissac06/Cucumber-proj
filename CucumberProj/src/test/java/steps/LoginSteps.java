package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

import static utils.CommonMethods.driver;

public class LoginSteps extends CommonMethods {

    LoginPage loginPage = Hooks.loginPage;

    @When("user enters username")
    public void user_enters_username() {
        loginPage.usernameField.sendKeys("admin");
    }

    @When("user enters password")
    public void user_enters_password() {
        loginPage.passwordField.sendKeys("admin123");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.usernameField.sendKeys("WrongUser");
        loginPage.passwordField.sendKeys("WrongPass");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualMessage;

        if (expectedMessage.equals("Invalid credentials")) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessageLoc));
            actualMessage = loginPage.errorMessageLoc.getText();
        } else if (expectedMessage.equals("Required")) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.requiredFieldMsg));
            actualMessage = loginPage.requiredFieldMsg.getText();
        } else {
            throw new RuntimeException("Unexpected error message scenario: " + expectedMessage);
        }

        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.usernameField.clear();
        loginPage.passwordField.clear();

        String username = ConfigReader.getProperty("userName");
        String password = ConfigReader.getProperty("password");

        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
    }
    @And("user clicks login button again")
    public void user_clicks_login_button_again() {
        loginPage.loginButton.click();
    }

    @Then("user should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.dashboardHeader));

        String dashboardText = loginPage.dashboardHeader.getText();
        Assert.assertTrue("Dashboard not displayed", dashboardText.contains("Dashboard"));
    }


    @Given("the admin is logged in and on the Dashboard page")
    public void theAdminIsLoggedInAndOnTheDashboardPage() {
        String username = ConfigReader.getProperty("userName");
        String password = ConfigReader.getProperty("password");

        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();


    }
}
