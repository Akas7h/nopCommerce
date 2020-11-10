Feature: Customer

Background: Below are the common steps for each scenario
 Given User launch Chrome Browser
 When User opens URL "https://admin-demo.nopcommerce.com/login"
 And user enters Email as "admin@yourstore.com" and password "admin"
 And click login
 Then User can view Dashboard page
 When User click on customers Menu
 And click on customers menu item 
 
 
 
@sanity 
Scenario: Add a new customer
   And click on Add new button item
   Then User can view Add a new customer page
   When user enters customer info
   And click on save button
   Then user can view confirm message "The new customer has been added successfully"
   
@regression 
Scenario: Search customer by EmailID
   And click on customers menu item   
   And Enter customer email
   When click on search button
   Then user should found Email in the search table
   
@regression   
Scenario: Search customer by Name
   And Enter customer FirstName
   And Enter customer LastName
   When click on search button
   Then user should found Name in the search table
     
    
   