## Cucumber Java Boilerplate with Liferay Poshi-Runner
This is a boilerplate for getting started with using [Liferay's Poshi-Runner](https://github.com/liferay/com-liferay-poshi-runner)
with [Cucumber Java](https://github.com/cucumber/cucumber-jvm) and Selenium for automated browser or webapp testing. The boilerplate includes a simple feature file with one scenario,
some additional unused step definitions to serve as examples. There is also an interface with several methods to demonstrate extending
or overriding the LiferaySelenium webdriver.


## Code Overview
### Core Cucumber files
* `cucumber\boilerplate\TestRunner.java` acts as the test runner, and contains `@CucumberOptions` and JUnit `@BeforeClass` and `@AfterClass` hooks.
    * In `@CucumberOptions`, the user can set various options such as the location of feature files (by directory or by path to a specific feature file).
      The glue parameter is the location of your step definitions.
    * The `@BeforeClass` hook runs once before all feature files, and the `@AfterClass` runs once after all feature files.
        * In `@BeforeClass`, we declare the location and type (chromedriver, geckodriver, etc) of our WebDriver and set some properties for it. We use
           [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) for automatic management and download of Selenium WebDriver binaries during runtime.
        * In `@AfterClass`, we close the WebDriver instance.

* `cucumber\boilerplate\steps\CucumberHooks.java` contains Cucumber hooks (rather than JUnit hooks in Testrunner.java).
`@Before` will run prior to *each* Scenario/Background. If a feature file has multiple Scenarios, it will run prior to each Scenario;
if the feature has a Background, it will run prior to the Backgroun for each Scenario. The `@After` hook will likewise run after each Scenario.

### WebDriver
* The interface `cucumber\boilerplate\driver\ProjectSelenium.java` extends the LiferaySelenium and WebDriver interfaces, allowing it to access methods from both.
This is where overriding or additional methods would be declared (but not implemented).

* `cucumber/boilerplate/driver/ProjectWebDriverImpl.java` extends `BaseWebDriverImpl.java` from Poshi-Runner and implements methods declared in `ProjectSelenium.java`.

* `cucumber/boilerplate/driver/ProjectWebDriver.java` wraps the WebDriver, for use by `ProjectSeleniumUtil.java`

* `cucumber/boilerplate/util/ProjectSeleniumUtil::getProjectSelenium` instantiates a single instance of `ProjectSelenium`

### Steps
* `cucumber/boilerplate/steps/pages/BasePage.java` calls `ProjectSeleniumUtil::getProjectSelenium` to initialize `_projectSelenium` as a protected variable.
All step definition files extend this `BasePage` so that `_projectSelenium` is readily available.

### Misc
* Although not used in the example feature file, `cucumber/boilerplate/util/ProjectRestUtil.java` is a simple util for making requests to an endpoint that
 will return the response as an `AppResponse` object. The handling and packaging of the response into an `AppResponse` object occurs in `ProjectResponseHandler.java`.


## Usage
The TestRunner can be started from commandline using `./gradlew test` or ran with a JUnit config pointing to `cucumber.boilerplate.TestRunner` within IntelliJ.
