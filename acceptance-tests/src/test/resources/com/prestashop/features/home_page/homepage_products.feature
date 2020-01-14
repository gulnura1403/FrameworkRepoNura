Feature: Verify products on the home page

  
  Scenario: verify information
    Given the user is on the home page
    When the system should display the promoted items
    Then the item details should be correct
