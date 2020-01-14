package com.prestashops.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) //we pass cucumber file to junit
@CucumberOptions(
		plugin = {
				//"pretty",
				"html:target/default-cucumber-reports",  // generates report
				"json:target/cucumber.json" //another way of generat report in json format
		}, 
 		tags = "@temp",
		//tags = "@login",
		features="src/test/resources/com/prestashop/features", //cont feature classes
		glue="com/prestashops/step_definitions" //class which contain definition classes
		//,dryRun = true //does not actually run,just checks if step defs should be added
		)
public class CukesRunner {
	
}

// WHEN WE RUN CukesRunner, IT GENERATED STEP DEFINITIONS, WE COPIED AND PASTED INTO
// HomePageStepDefs
