

Feature: Data Driven Testing
  I want to use this template for my data driven testing

@SmokeTest
  Scenario: Enter form on landing apge
    Given User is on the practice page
    When User fills the data on the form
    |Gayatri| #firstname
    |Pappu| #lastname
    |gpappu@gmail.com| #email
    |7573324984| #phone#
    Then User logs in


