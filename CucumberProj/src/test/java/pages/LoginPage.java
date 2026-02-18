package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Invalid credentials']")
    public WebElement errorMessageLoc;

    @FindBy(xpath = "//*[text()='Required']")
    public WebElement requiredFieldMsg;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6") // adjust to something unique on your dashboard page
    public WebElement dashboardHeader;
}
