# Cucumber Framework: 

## What is BDD? 
BDD is an approach in software development that emphasizes the behavior of an application for business needs. It was conceived to address issues arising from ill-defined requirement specifications and to align business and QA professionals. 

BDD brings together key stakeholders in the Software Development Process, often called the “Three Amigos” – the Business, Development, and QA teams. Using tests written in plain English allows all stakeholders to understand and agree on the software’s expected behavior, ensuring that the “right product” is being developed.

The three principles of BDD are:

Focus on the desired behavior or outcomes
Collaboration between developers, testers, and business stakeholders
Use of a common language for communication and understanding.
BDD is an evolution of the Test-Driven Development Methodology (TDD), but it shifts the focus from high test coverage to defining the application’s behavior.

## What is the BDD Process?
Think of BDD as a play. In a play, you have characters (the business team, the development team, and the QA team) and a script (the behaviors or requirements). 

The business team is like the playwright, writing the script based on what they want the audience (the users) to experience. 
The development team is like the actors, bringing the script to life on the stage (the software). 
The QA team is like the director, ensuring the actors perform their parts correctly and the play goes as planned.
In BDD, the “script” is written in a language called Gherkin, which uses simple words like “Given”, “When”, and “Then” to describe the behavior of the software. For example, “Given a user is logged in, When they click on the ‘logout’ button, they should be logged out and redirected to the login page.” This script is then turned into automated tests that check if the software behaves as expected.

The beauty of BDD is that everyone involved in the play, from the playwright to the director, understands the script and agrees on the final performance. This way, everyone is on the same page, and the chances of the play being a hit are much higher!

## What is Cucumber Framework?
Cucumber FrameworkCucumber Framework executes automated acceptance tests written in the **“Gherkin”** language. Gherkin is a domain-specific language for behavior descriptions. Gherkin is business-readable.

Cucumber test automation makes use of two important files:

Feature file – Contains code written in Gherkin (plain English text)
Step definition file – Contains the actual code written by the developer
Cucumber acts as a bridge between the following teams:

- Business Analysts and Software Engineers
- Manual and Automation Testers
- Manual Testers and Developers

## How does Cucumber work?
Cucumber BDD framework mainly consists of three major parts:

**Feature File**:
Cucumber tests are written in plain text files called feature files stored with the extension – “.feature”. 
A Feature File can be described to make the documentation more legible. 
These files describe the behavior and functionality of the software using a specific syntax called **Gherkin**. 
    - Gherkin is a structured language that uses keywords like Given, When, and Then to define the steps of a test scenario.
    
**Step Definitions**:
Each step in a feature file is associated with a step definition implemented in the code. 
Step definitions define the actions or operations that must be executed for each step of the test scenario. 
They map the plain text steps in the feature file to the corresponding code implementation.

**Test Runner File**: 
In Cucumber, the test runner file executes the Cucumber feature files and coordinates the steps defined in those feature files with the corresponding step definitions.