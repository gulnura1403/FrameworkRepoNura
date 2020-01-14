package com.prestashops.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.prestashops.utilities.ConfigurationReader;
import com.prestashops.utilities.Driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks { //can be any class name
	
	//hooks normally used to set up db connection, authoraz in api
	//if test uses 1 website, can be added in Hooks
	//import from Cucumber io, so that it will run before every cucum scenario
	// hooks will run only before and after each cucum scenario
	// HOOKS ARE GOOD TO TAKE SCREENSHOTS IN THE AFTRE METHOD
	
	@Before 
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Driver.getDriver().manage().window().fullscreen();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}
	
	@Before ("@amazon_check")
	public void setUpAmazon() {
		System.out.println("before scenario");
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Driver.getDriver().manage().window().fullscreen();
		Driver.getDriver().get("http://amazon.com");
	}
	
	// best place to put a method taking screensh, if test fails
	// IF U CALL CLOSING THE DRIVER U MIGHT BREAK THE FLOW OF THE TEST, THE NEXT TEST WILL FAIL
	@After 
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		
		if(scenario.isFailed()) {
			
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
					.getScreenshotAs(OutputType.BYTES);
			
			// adding the screensh to the report
			scenario.embed(screenshot, "image/png");
		}
		//Driver.closeDriver();
	}
}
