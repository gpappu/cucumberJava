# Cucumber Framework: 

## What is BDD?

BDD is an approach in software development that emphasizes the behavior of an application for business needs. It was conceived to address issues arising from ill-defined requirement specifications and to align business and QA professionals. 

BDD brings together key stakeholders in the Software Development Process, often called the “Three Amigos” – the Business, Development, and QA teams. Using tests written in plain English allows all stakeholders to understand and agree on the software’s expected behavior, ensuring that the “right product” is being developed.

**The three principles of BDD are:**

• Focus on the desired behavior or outcomes
• Collaboration between developers, testers, and business stakeholders
• Use of a common language for communication and understanding.

BDD is an evolution of the Test-Driven Development Methodology (TDD), but it shifts the focus from high test coverage to defining the application’s behavior.

## What is the BDD Process?

Think of BDD as a play. In a play, you have characters (the business team, the development team, and the QA team) and a script (the behaviors or requirements). 

• The business team is like the playwright, writing the script based on what they want the audience (the users) to experience.
• The development team is like the actors, bringing the script to life on the stage (the software).
• The QA team is like the director, ensuring the actors perform their parts correctly and the play goes as planned.

In BDD, the “script” is written in a language called Gherkin, which uses simple words like “Given”, “When”, and “Then” to describe the behavior of the software. 

For example, “Given a user is logged in, When they click on the ‘logout’ button, they should be logged out and redirected to the login page.” This script is then turned into automated tests that check if the software behaves as expected.

The beauty of BDD is that everyone involved in the play, from the playwright to the director, understands the script and agrees on the final performance. This way, everyone is on the same page, and the chances of the play being a hit are much higher!

## What is Cucumber Framework?

Cucumber Framework executes automated acceptance tests written in the “Gherkin” language. Gherkin is a domain-specific language for behavior descriptions. Gherkin is business-readable.

Cucumber test automation makes use of two important files:

• Feature file – Contains code written in Gherkin (plain English text)
• Step definition file – Contains the actual code written by the developer

Cucumber acts as a bridge between the following teams:

* Business Analysts and Software Engineers
* Manual and Automation Testers
* Manual Testers and Developers

How does Cucumber work?
Cucumber BDD framework mainly consists of three major parts:

**Feature File:**
Cucumber tests are written in plain text files called feature files stored with the extension – “.feature”. 

A Feature File can be described to make the documentation more legible.
These files describe the behavior and functionality of the software using a specific syntax called **Gherkin**.
    - **Gherkin** is a structured language that uses keywords like Given, When, and Then to define the steps of a test scenario.
Feature files are created in the src/test/java folder. 

**Step Definitions:**
Each step in a feature file is associated with a step definition implemented in the code. 

Step definitions define the actions or operations that must be executed for each step of the test scenario.
They map the plain text steps in the feature file to the corresponding code implementation.

**Test Runner File:** 

* In Cucumber, the test runner file executes the Cucumber feature files and coordinates the steps defined in those feature files with the corresponding step definitions.
* For the test runner to execute, we use an annotation called @CucumberOptions which takes in the location of feature files and step definitions as arguments
* The test runner class also requires to inherit properties from the AbstactTestNGCucumberTests to execute the feature file.

## Example of a Cucumber Test

A cucumber test starts with creating a feature file that uses the following keywords:

* **Feature**: Used to describe the feature for which test cases are being written
* **Rule (as of Gherkin 6)**
* **Scenario (or Example)**: Used to write a test case using the keywords Given, When, Then, And, and But
* **Given, When, Then, And, But for steps (or *)** : Used to define the preconditions, actions taken, and the result
* **Background**
* **Scenario Outline (or Scenario Template)**: Used when the same scenario has to be executed with multiple values 
* **Examples (or Scenarios)**: Used with Scenario Outline when the same scenario has to be executed with multiple values 

## Using Scenario Outline

When using scenario outline, we can use parameterization as shown below:
Scenario Outline: User Login
   Given User is at the MyMDM Login page
   When User enters credentials "<username>" and Password "<password>" and clicks login
   Then User is taken to the masters dashboard

   Examples:
   |username |password|
   |Perfuser008 |abc123|
   |Perfuser002 |abc123|

In the above example <username> and <password> are the 2 parameters used to execute the same scenario multiple times.

We now modify the stepDefinitions file to include the parameters used in the feature file as shown below:

@When("User enters credentials {string} and Password {string} and clicks login")
	public void user_enters_credentials_and_password_and_clicks_login(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User " + username +" enters password "+password+" and logs in");

   

**Instead of hard coding the parameters as strings(in double quotes), we can also use REGULAR EXPTESSIONS as shown below:**

Password is now an integer (without double quotes)
Scenario Outline: User Login
   Given User is at the MyMDM Login page
   When User enters credentials "<username>" and Password <password> and clicks login
   Then User is taken to the masters dashboard

   Examples:
   |username |password|
   |Perfuser008 |123456|
   |Perfuser002 |123456|

The step Definition file will be modified as follows:
The .+ is the regular exptession that will take any type of data and insert it in the method
** @When("^User enters credentials (.+) and Password (.+) and clicks login$") **
    public void user_enters_credentials_and_password_and_clicks_login(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User " + username +" enters password "+password+" and logs in");

   

**When we have many parameters to enter (For ex: filling a form that has first name, last name, dob, address, etc.), we can provide all that data as a list within the scenario as ahown below:**
 Scenario: Enter form on landing apge
    Given User is on the practice page
    When User fills the data on the form
    |Gayatri| #firstname
    |Pappu| #lastname
    |gpappu@gmail.com| #email
    |7573324984| #phone#
    Then User logs in

@When("User fills the data on the form")
    public void user_fills_the_data_on_the_form(List<String> data) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

## Using Cucumber Tags
When we have a whole suite of tests, we can segregate those tests into categories by creating tags. For ex: some tests are smoke tests and some are regression. 
We can run only the tests considered as smoke tests by tagging them in the feature file as **@SmokeTest** and update the test runner file to use this tag 

