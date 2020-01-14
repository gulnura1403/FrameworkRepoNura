Feature: Error message on the login page

  Scenario: Invalid email
    Given the user is on the login page
    When the user tries to register an invalid email
    Then the system should display error message "Invalid email address."

  Scenario: blank email
    Given the user is on the login page
    When the user tries to register blank email
    Then the system should display error message "Invalid email address."

# special case: u need check existing user against the D/b
# 1 problem: D/B data changes/resets frequently
# 2 probl: u can run tests against diff environments: QA, staging etc and they don't have specif users
# TO SOLVE THIS JUST CREATE YR OWN USER AND TEST WITH THAT USER
  
  Scenario: existing email
  	Given there is an existing user
    And the user is on the login page
    When the user tries to register the same email
    Then the system should display error message "An account using this email address has already been registered. Please enter a valid password or request a new one."
