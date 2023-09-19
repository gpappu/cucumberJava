
Feature: Trying out the Cucumber Hooks


  @hooks
  Scenario: UCM Login
    Given User is at the login page
    When User enters credentials and clicks login
    Then UCM dashboard is displayed


  Scenario: URM Login
    Given User is at the login page
    When User enters credentials and clicks login
    Then URM dashboard is displayed
    
    
  Scenario: UPM Login
    Given User is at the login page
    When User enters credentials and clicks login
    Then UPM dashboard is displayed
    
