@ui @menu
Feature: Menu page

Scenario Outline: User ss able to navigate to the left side menu
Given User navigated to the link of the application
When User clicks on the "<Side_Link_Menu>"
Then User is navigates to the corresponding links

Examples: 
|Side_Link_Menu|
|Baby Care     |
|Medical       |
|Real Estate   |
|Travel        |
|Wedding       |