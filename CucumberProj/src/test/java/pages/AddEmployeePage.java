package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameloc;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameloc;

    @FindBy(xpath = "//*[@name='middleName']")
    public WebElement middleNameloc;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public WebElement employeeIdField;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/span")
    public WebElement firstNameErrorMsg;

    public AddEmployeePage(){

        PageFactory.initElements(driver,this);
    }

}
