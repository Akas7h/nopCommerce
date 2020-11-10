Feature: Login 

@sanity
Scenario: Successful Login with Valid Credentials
   Given User launch Chrome Browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And user enters Email as "admin@yourstore.com" and password "admin"
   And click login
   Then page title should be "Dashboard / nopCommerce administration"
   When user clicks on Logout link
   Then page title should be "Your store. Login"
   
@regression
 Scenario Outline: Login Data driven
   Given User launch Chrome Browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And user enters Email as "<email>" and password "<password>"
   And click login
   Then page title should be "Dashboard / nopCommerce administration"
   When user clicks on Logout link
   Then page title should be "Your store. Login"
  
   
   Examples:
      | email | password |
      |admin@yourstore.com | admin |
      |admin1@yourstore.com | admin12|