package CucumberOptions;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features" ,
		glue = "Stepdefinition")

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
