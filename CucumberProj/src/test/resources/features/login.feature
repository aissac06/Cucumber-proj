Feature: Login validation

  Scenario: Empty username field
    When user enters password
    And user clicks login button
    Then error message "Required" should be displayed

  Scenario: Empty password field
    When user enters username
    And user clicks login button
    Then error message "Required" should be displayed

  Scenario: Invalid credentials
    When user enters invalid username "WrongUser" and password "WrongPass"
    And user clicks login button
    Then error message "Invalid credentials" should be displayed
    When user enters valid username and password
    And user clicks login button again
    Then user should be navigated to dashboard
