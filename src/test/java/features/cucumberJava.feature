
Feature: Application Login
  I want to use this template for my feature file

 
  # Scenario: PM Login
    # Given User is at the MyMDM Login page
    # When User enters credentials "Perfuser008" and Password "abc123" and clicks login
    # Then User is taken to the masters dashboard
  
  # Scenario: ProGo Login
    # Given User is at the MyMDM Login page
    # When User enters credentials "Perfuser002" and Password "abc123" and clicks login
    # Then User is taken to the masters dashboard
  
    
  # Scenario: Tech Admin Login
   # Given User is at the MyMDM Login page
    # When User enters credentials "Perfuser001" and Password "abc123" and clicks login
    # Then User is taken to the masters dashboard
    
   # The above 3 scenarios can be written as a scenario outline with multiple inputs as shown below
   
  # Scenario Outline: User Login
   #Given User is at the MyMDM Login page
   #When User enters credentials "<username>" and Password "<password>" and clicks login
   #Then User is taken to the masters dashboard
   
  # Examples:
  # |username |password|
  # |Perfuser008 |abc123|
  # |Perfuser002 |abc123|
  # |Perfuser001 |abc123|
   
   
   Scenario Outline: User Login
   Given User is at the MyMDM Login page
   When User enters credentials "<username>" and Password <password> and clicks login
   Then User is taken to the masters dashboard
   
   Examples:
   |username |password|
   |Perfuser008 |123456|
   |Perfuser002 |123456|
   |Perfuser001 |123456|
   
   
   
   
  
    
    