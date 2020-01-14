Feature: Verify product information
  Agile Story: When  user search for product
  they should see it
  
  Author: Nora
  date of creation: 27/10/2019

  #Background:
  #Given the user is on the home page
  Scenario Outline: Verify item name
    When the user selectes "<product>"
    And product name should be "<product>"
    Then the price should be "<price>"
    And correct default count should be 1

    Examples: 
      | product               | price  |
      | Printed Summer Dress  | $28.98 |
      | Printed Dress         | $26.00 |
      | Printed Chiffon Dress | $16.40 |

  #it works like a map
  
  
  Scenario Outline: Verify usernames
    Given the user is on the login page
    When I login using username "<username>" and password "<password>"
    Then users full name  "<firstname>"  "<lastname>" should be displayed

    Examples: 
      | firstname | lastname | username           | password |
      | john      | smith    | noranora@gmail.com | password |
      | bob       | baker    | baker@att          | pass     |
      | bin       | buttler  | baker@tmobile      | pass     |
      | ann       | tomas    | tomas@att          | passw    |

  Scenario Outline: Product details with map
    Given the user is on the home page
    When the user selectes "<product>"
    Then the system should display the product information:
      | name      | <product> |
      | count     |         1 |
      | condition | New       |
      | size      | S         |
      | price     | <price>   |

    Examples: 
      | price  | product               |
      | $28.98 | Printed Summer Dress  |
      | $26.00 | Printed Dress         |
      | $16.40 | Printed Chiffon Dress |

  
  Scenario Outline: Verify <page> title
    When the user is on the <page>
    Then the title and url should be:
      | Title | <title> |
      | Url   | <url>   |

    Examples: 
      | page        | title            | url                                                                               |
      | home page   | My Store     \|    | http://automationpractice.com/index.php                                           |
      | login page | Login - My Store | http://automationpractice.com/index.php?controller=authentication&back=my-account |
