Feature: Product Information

  Background: #Similar to BeforeMethod, but there is no sim to AfterMethod
    Given the user is on the home page

  Scenario: Display the correct product name
    When the user selectes Printed Summer Dress
    Then product information page should be displayed
    And product name should be Printed Summer Dress

  Scenario: Default count and size information
    When the user selectes Printed Summer Dress
    Then correct default count size should be displayed

#when u give a string here, in step defs it ll create a method with str arg 
  Scenario: Display the correct product name by name
    When the user selectes "Printed Summer Dress"
    Then product page title should contain "Printed Summer Dress"
    And product name should be "Printed Summer Dress"
    
  @smoke
    Scenario: Change item count
    When the user selectes "Printed Summer Dress"
    Then correct default count should be 1
    And the user should be able to toggle the count
    

    