@login
Feature: login

@smoke
Scenario: login link

Given the user is on the home page
When the user clicks on the Sign in link
Then username and password fields ahould be displayed

Scenario: Verify user name and last name

Given the user is on the login page
When the user logs in using username "graisyn.diezel@thtt.us" and password "azffh9T$"
Then users full name "Bob Bob" should be displayed

@amazon_check 
Scenario: Verify goes to different site

Given the user amazon
When the user gets prices for "Printed Chifon Dress"
When the user is on the home page
Then the price for "Printed Chifon Dress" should be cheaper
