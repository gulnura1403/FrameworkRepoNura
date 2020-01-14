Feature: User account information

  Scenario Outline: verify account info
    Given the user is on the login page
    And the user logs in using username "<username>" and password "<password>"
    When the user clicks on my personal information button
    Then the system should display the users account information
      | First Name | Last Name | email      | Password   |
      | <firstame> | <lastame> | <username> | <password> |

    Examples: 
      | firstame | lastame | username           | password |
      | john     | smith   | noranora@gmail.com | password |
      | bred     | baker   | baker@att          | password |
      | boby     | buttler | baker@tmobile      | password |
