Feature: Finance Check
  Scenario: Check user
    Given user wants to check user name
    When passed user name to chrome
    Then Chrome should open with uses details
  Scenario: Check user invalid username
    Given user passes false info
    When passed incorrect user name to chrome
    Then Chrome should open with 404 error