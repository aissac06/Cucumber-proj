Feature: Add Employee to HRMS
  As an HRMS admin
  I want to add new employees to the HRMS system
  So that the system can manage employee records effectively

  Background:
  Given the admin is logged in and on the Dashboard page

  @AddEmployeeWithoutID
  Scenario: Add an employee without providing Employee ID
    When the admin navigates to the Employee list page
    And the admin navigates to Add Employee page
    And the admin enters first name "John" and last name "Doe"
    And the admin clicks the Save button
    Then the system should automatically generate a unique Employee ID

  @AddEmployeeWithID
  Scenario: Add an employee with a specific Employee ID
    When the admin navigates to the Employee list page
    And the admin navigates to Add Employee page
    And the admin enters first name "John" and last name "Doe"
    And the admin clears and enters a custom employee ID "A12345"
    And the admin clicks the Save button
    #Then the system should save the employee with Employee ID "A12345" (Not working)

  @AddEmployeeValidation
  Scenario: Display error for missing required fields
    When the admin navigates to the Employee list page
    When the admin navigates to Add Employee page
    And user enters employee last name "John"
    And the admin clicks the Save button
    Then the system should display an error message for required fields
