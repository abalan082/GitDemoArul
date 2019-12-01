Feature: Login into Application

Scenario Outline: positive test validating login
Given Initialize the browser with chrome
And navigate to "http://www.qaclickacademy.com/" 
And Click on login link in home page to land on secure sign on page
When user enters <username> and <password> ans logs in
Then verify that user is successfully logged
And close browsers


Examples: 
|username                         |password    |
|test99@gmail.com                 |123456      |
|test123@gmail.com                |12345       |