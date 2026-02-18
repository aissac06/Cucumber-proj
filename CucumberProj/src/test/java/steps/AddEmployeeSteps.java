package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    String generatedEmployeeId;

    @When("the admin navigates to the Employee list page")
    public void admin_navigates_to_employee_list() {
        DashboardPage dashboard = new DashboardPage();
        dashboard.pimOption.click();           // click PIM
        dashboard.empListOption.click();       // click Employee List
    }

    @And("the admin navigates to Add Employee page")
    public void admin_navigates_to_add_employee() {
        DashboardPage dashboard = new DashboardPage();
        dashboard.addEmpOption.click();       // click Add Employee
    }
    @And("the admin enters first name {string} and last name {string}")
    public void admin_enters_first_and_last_name(String firstName, String lastName) {
        AddEmployeePage addEmp = new AddEmployeePage();
        addEmp.firstNameloc.sendKeys("John");
        addEmp.lastNameloc.sendKeys("Doe");
    }
    @When("the admin clicks the Save button")
    public void admin_clicks_save_button() {
        AddEmployeePage addEmployee = new AddEmployeePage();
        addEmployee.saveButton.click();
    }
    @Then("the system should automatically generate a unique Employee ID")
    public void system_should_generate_unique_employee_id() {

        AddEmployeePage addEmp = new AddEmployeePage();

        generatedEmployeeId = addEmp.employeeIdField.getAttribute("value");

        Assert.assertNotNull(generatedEmployeeId);
        Assert.assertFalse(generatedEmployeeId.isEmpty());
    }
@And("the admin clears and enters a custom employee ID {string}")
    public void admin_clears_and_enters_a_custom_employee_id(String empID) {
        AddEmployeePage addEmp = new AddEmployeePage();
        addEmp.employeeIdField.clear();
        addEmp.employeeIdField.sendKeys("A12345");
}





    @When("user enters employee last name {string}")
    public void user_enters_employee_last_name(String lastName) {
        AddEmployeePage addEmp = new AddEmployeePage();
        addEmp.lastNameloc.sendKeys(lastName);
    }

    @Then("the system should display an error message for required fields")
    public void userShouldSeeErrorMessageForEmptyFirstNameField() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        String actualMessage = addEmployeePage.firstNameErrorMsg.getText();
        Assert.assertEquals("Required", actualMessage);}

}
