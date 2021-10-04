@ui @SignUp
Feature: SignUp and LogIn Page

Background: Navigation to the Url
Given User navigated to the link of the application

Scenario: User is able to signUp in the application
When User clicks on the signUp link 
And User enters name as "sujeet" and mobile as "8871304642" and clicks on submit button
Then User is displayed with the message as "OTP is sent on number"

 
 Scenario: User is able to enter only 10 digits in the Mobile Text box
 When User clicks on Login-in link of the application
 Then User is able to enter only "10" digits in the Mobile text field
    

Scenario: User is able to logIn in the application
When User clicks on the logIn link
And User enters name as "sujeet" and mobile as "8871304642" and clicks on submit button
Then User is able to logIn  
 

