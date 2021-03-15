Feature: Log into the site

  Scenario Outline: Login with valid credentials
    Given Navigate to login page
    Then Enter valid <email>
    And Entered valid <password>
    When I press the login button
    Then I am redirected to the home page

    Examples: 
      | email                  | password   |
      | quartblabla1@gmail.com | Zxz123Zxz@ |