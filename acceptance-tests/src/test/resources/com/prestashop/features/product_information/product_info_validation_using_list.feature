Feature: Product details

  Scenario: Verify products on home page
    Given the user is on the home page
    When the user should be able to see "Printed Summer Dress"

  # in cucucmber u can pass list/ verify multiple options
  # spaces on the sides will be trimmed, between the strings considered part of string
  Scenario: Verify products on home page
    Given the user is on the home page
    When the user should be able to see following products
      | Printed Summer Dress        |
      | Printed Chiffon Dress       |
      | Blouse                      |
      | Printed Dress               |
      | Faded Short Sleeve T-shirts |
      | regular t shirt             |

  
  Scenario: Verify all sizes
    Given the user is on the home page
    When the user selectes "Printed Summer Dress"
    Then the product be available in the following sizes
      | S  |
      | M  |
      | L  |
      | XL |
    And correct default count size should be displayed
