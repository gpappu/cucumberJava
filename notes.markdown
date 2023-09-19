
# Cucumber Framework:

## Camel Case - Naming conventions
Any filename should start with upper case except for
- properties
- pom.xml

Folders should NOT have any upper case

Local variables should start with lower case and should follow camel case.

Constants should be all upper case with underscores.


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

## What is Cucumber Options?
In layman language, @CucumberOptions are like property files or settings for your test. Basically @CucumberOptions enables us to do all the things that we could have done if we have used cucumber command line. This is very helpful and of utmost importance, if we are using IDE such eclipse only to execute our project. 

Following Main Options are available in Cucumber:
- dryRun: Can be true or false. Default is false. Checks if the steps in the feature file has associated stepDefinitions. It will only compile the feature file. It will not execute any tests.
- features: Used to set the location of the feature files
- glue: used to set the location of the step definition file
- tags: used to execute tests with the tag name provided
- monochrome: set to see the test runner output in a more readable way. If set to true, everything is displayed in one color. If set to false, the console output is displayed in 2 colors.
- format: used to set report formatters. Ex: "pretty", "html:target/cucumber.html"
- strict: Will fail if there are undefined or pending steps 

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
- When we have a whole suite of tests, we can segregate those tests into categories by creating tags. For ex: some tests are smoke tests and some are regression. 
- We can run only the tests considered as smoke tests by tagging them in the feature file as **@SmokeTest** and update the test runner file to use this tag 
- Tags can have the keywords **and** to run test with more than one tag. They can have **or** to run any one of the tags. They can also have **not** to NOT run any tag

## The keyword BACKGROUND
- There could be an instance where all tests/scenarios would require some kind of prerequisites (a common set up) before running the test. Instead of setting up these steps for each scenario, they can be declared using the keyword **BACKGROUND**. 
- Background is declared before the scenarios are written. 
- Background is limited to the scope of the feature file it is defined in. It is NOT common to all feature files. 

## Cucumber HOOKS
**What are Hooks in Cucumber?**
Cucumber supports hooks, which are blocks of code that run before or after each scenario. You can define them anywhere in your project or step definition layers, using the methods @Before and @After. Cucumber Hooks allows us to better manage the code workflow and helps us to reduce the code redundancy. We can say that it is an unseen step, which allows us to perform our scenarios or tests.

**Why Cucumber Hooks?**
In the world of testing, you must have encountered the situations where you need to perform the prerequisite steps before testing any test scenario. This prerequisite can be anything from:

Starting a webdriver
Setting up DB connections
Setting up test data
Setting up browser cookies
Navigating to certain page
or anything before the test
In the same way, there are always after steps as well of the tests like:

Killing the webdriver
Closing DB connections
Clearing the test data
Clearing browser cookies
Logging out from the application
Printing reports or logs
Taking screenshots on error
or anything after the test
To handle these kinds of situations, cucumber hooks are the best choice to use. Unlike TestNG Annotations, cucumber supports only two hooks (Before & After) which works at the start and the end of the test scenario. As the name suggests, @before hook gets executed well before any other test scenario, and @after hook gets executed after executing the scenario.

**Cucumber hooks are similar to the BACKGROUND in a feature file but are used when the prerequisites(the test data )are not common for all the scenarios within the feature file. **

** If a feature file is not specified in the test runner, Hooks will run for all scenarios in all feature files unlike BACKGROUND which is limited to the scope of the feature file it is defined within **

** Hooks can also be limited to certain scenarios by using tags **

** ORDER OF EXECUTION**
Before hook -> Background -> Scenarios -> After Hook

## Cucumber Reports 
When ever we do test execution, it is also require to understand the out put of the execution. Whether it is Manual execution or an Automated, the output of the same has to be in format, which immediately depicts the overall results of the execution. Hence, our framework also should have the same capability to create output or generate test execution reports.

It is essential to know, how better we can generate our Cucumber test reports. As we know that Cucumber is a BDD framework, it does not have a fancy reporting mechanism. In order to achieve this, Cucumber itself has provided a nice feature to generate reports. These are very basic reports, but using the output of these reports anybody can build more detailed HTML reports

- Pretty Report
The first plugin, we will talk about is Pretty.  This provides more verbose output. To implement this, just specify plugin = "pretty" in CucumberOptions. This is what the code looks like:

@CucumberOptions( plugin = { "pretty" } )

- Usage Report
If we are more concerned about the time taken by each Step Definition, then we should use the usage plugin. This is how we specify the same in @CucumberOptions:

@CucumberOptions( plugin = { "usage" })

## Cucumber Report Output
You must be wondering that all we have seen above is actually good for a test or for a couple of tests. But if we run a full test suite, this report is not much useful in that case. On top of that, it is difficult to keep these console output safe for future use.

Cucumber gives us the capability to generate reports as well in the form of HTML, XML, JSON & TXT. Cucumber frameworks generate very good and detailed reports, which can be shared with all stakeholders. There are multiple options available for reports which can be used depending on the requirement.

- Cucumber HTML Reports
For HTML reports, add html:target/cucumber-reports to the @CucumberOptions plugin option.

- Cucumber JSON Report
For JSON reports, add json:target/cucumber-reports/Cucumber.json to the @CucumberOptions plugin option.

- Cucumber JUNIT XML Report
For JUNIT reports, add junit:target/cucumber-reports/Cucumber.xml to the @CucumberOptions plugin option.

## Exceptions observed in Cucumber
1. DuplicateStepDefinitionException

