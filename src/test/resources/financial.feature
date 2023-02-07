Feature: Finance Check
  Scenario: Check user
    Given user wants to check user name
    When passed user name to chrome
    Then Chrome should open with uses details
  Scenario: Check user invalid username
    Given user passes false info
    When passed incorrect user name to chrome
    Then Chrome should open with 404 error

  Scenario: Check user details
    Given user wants to check or use user name
    When passed username to chrome
    Then Chrome should open with correct users details
  Scenario: Check user invalid username
    Given user passes wrong info
    When passed incorrect username to chrome
    Then Chrome should open with 404error

  Scenario: Check total income returns correct figure
    Given User wants to check total income
    When Details passed to chrome
    Then chrome should open with correct total income for specified user

  Scenario: Check when happens when wrong user name provided
    Given User inserts incorrect user number
    When Incorrect totalincome username passed to chrome
    Then chrome should response with 404 error

  Scenario: Check total income returns correct figure local help
    Given User wants to check total income local help
    When Details passed to chrome local help
    Then chrome should open with correct total income for specified user local help

  Scenario: Check when happens when wrong user name provided for local help
    Given User inserts incorrect user number for local help
    When Incorrect totalincome username passed to chrome for local help
    Then chrome should response with 404 error for local help
##
#      Scenario: Check total income returns correct figure for dual income
#    Given User wants to check total income for dual income
#    When Details passed to chrome for dual income
#    Then chrome should open with correct total income for specified user for dual income
#
#  Scenario: Check when happens when wrong user name provided for dual income
#    Given User inserts incorrect user number for dual income
#    When Incorrect totalincome username passed to chrome for dual income
#    Then chrome should response with 404 error for dual income
