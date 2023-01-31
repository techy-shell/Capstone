Feature: Finance Check
  Scenario: Check user
    Given user wants to check user name
    When passed user name to chrome
    Then Chrome should open with uses details