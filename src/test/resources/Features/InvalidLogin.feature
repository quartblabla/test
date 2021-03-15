Feature: Log into the site

  Scenario Outline: Login with invalid credentials
    Given Navigate to login page
    Then Enter invalid <email> 
    And Entered invalid <password>
    When I press the login button
    Then Error message is shown
    Examples:
      | email                  | password   |
      | quartblabla1@gmail.com | zxz123zxz@ |
