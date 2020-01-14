Feature: Users should be able to login

  Scenario: User registration
    Given the user is on the login page
    And the user enters a random email
    And the user enters personal information
      # below table is considered as a Map in java/step def
      | First Name | Kunnka      |
      | Last Name  | Adm         |
      | City       | Boston      |
      | Address    | 123 Main st |
      | Company    | XYZ         |

  
  Scenario: Custom User registration
    Given the user is on the login page
    And the user enters a random email
    And the user enters user information
      # below table is considered as a intances of an Obj in java/step def
      #to be able to use it, we created DataTableConfigurer class under com.prestashops.step_definition
      | First Name | Last Name | Company | Address     | City   |
      | Adm        | Kunnka    | XYZ     | 123 Main st | Boston |

  Scenario: User info
    Then correct user info should be displayed
      | First Name | Last Name | Company | Address     | City   |
      | Adm        | Kunnka    | XYZ     | 123 Main st | Boston |
    And I login as this user
      | First Name | Last Name |
      | Adm        | Kunnka    |
     
