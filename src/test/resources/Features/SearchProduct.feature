@ui @search
Feature: Search page

Background: Navigation to the Url
Given User navigated to the link of the application

Scenario: User is able to search 
When User type "restaurants" in the search box
And User clicks on search button
Then User shows the result related to the "restaurant"

 Scenario: User is able to see the drop down when he keys in the text in the search box
 When User enters "resta" in search text box
 Then User is able to see the drop down under search text box with all the items with text "resta"
    
    
Scenario: User is able to click on the drop down links
When User enters "restaurant" in the search box
And User clicks links on the drop down
Then User is able to show the appropriate results
    

