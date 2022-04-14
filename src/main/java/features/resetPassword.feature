Feature: reset password

  Scenario: User could reset his/her password successfully
    Given user clicks on login
    And clicks forgot password
    When user enters his email
    And clicks recover
    Then user should receive recovery email