Feature: Registration

  @smokeTest
  Scenario: User could sign up with valid credentials
    Given user clicks on register
    When user enters valid mandatory fields
    And clicks on register
    Then user should register successfully