
Feature: Using the Background Feature

Background:
Given User is active in LDAP
And User is active in CEEP
When User is at the MyMDM page




  Scenario: PM Login
    Given PM enters credentials "Perfuser008" and 123456
    When PM clicks lodin
    Then PM is at masters dashboard
    
    