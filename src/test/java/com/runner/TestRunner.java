package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Test runner class is used to run the tests with cucumber options and junit 
@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/com.feature",
		glue= {"com.stepDefinitions"},
//		dryRun=true,
	plugin = {"json:target/cucumber.json"}
//			tags="@api"
		)
public class TestRunner {

}
