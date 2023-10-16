Feature:Singing in the system with valid and non valid credentials

  Scenario: User does not login with not valid username
    Given I navigate to login page
    When I set "username" field value "admin1" on login page
    And I set "password" field value "admin" on login page
    And I click "Sign in" button
    Then error message is present on login page
    Then I still on login page

  Scenario: User does not login with not valid password
    Given I navigate to login page
    When I set "username" field value "admin" on login page
    And I set "password" field value "admin1" on login page
    And I click "Sign in" button
    Then error message is present on login page
    Then I still on login page

  Scenario: User does login with valid credentials
    Given I navigate to login page
    When I set "username" field value "admin" on login page
    And I set "password" field value "admin" on login page
    And I click "Sign in" button
    Then error message is not present on login page
    And I click Dashboard button
    Then I'm on the main page

  Scenario: User does login with valid credentials
    Given I navigate to login page
    When I set "username" field value "admin" on login page
    And I set "password" field value "admin" on login page
    And I click "Sign in" button
    Then error message is not present on login page
    And I click Dashboard button
    Then I'm on the main page
    And I click top menu "New personal project" link
    And I set "Name" field "Test Project UI" on the popup
    And I click "Save" button
    And I check a title