Feature: User Account Creation and Login

  Scenario: User creates an account successfully
    Given I am on the registration page
    When I create an account with "John", "Doe", "johndoe@example.com", "Password123"
    Then I should see a confirmation message

  Scenario: User logs in successfully
    Given I am on the login page
    When I login with "johndoe@example.com" and "Password123"
    Then I should be logged in successfully
