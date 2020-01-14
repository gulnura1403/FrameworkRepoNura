package com.prestashops.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.prestashops.pages.HomePage;
import com.prestashops.pages.SigninPage;
import com.prestashops.utilities.ConfigurationReader;
import com.prestashops.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefs {
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
	    System.out.println("Open home page");
	    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	@When("the user enters a search term")
	public void the_user_enters_a_search_term() {
		System.out.println("Enter search term: t shirt");
		HomePage homePage = new HomePage();
		homePage.search.sendKeys("t shirt");
	}

	@Then("the search box should contain the search term")
	public void the_search_box_should_contain_the_search_term() {
		System.out.println("Verify search term");
		HomePage homePage = new HomePage();
		String actual = homePage.search.getAttribute("search_query");
		assertEquals("T shirt", actual, "text doesn't match");
		System.out.println("OK");
	}
	
	String title;
	@When("the user gets title of the page")
	public void the_user_gets_title_of_the_page() {
		System.out.println("user gets title");
	    title =  Driver.getDriver().getTitle();
	}

	@Then("title should be Search - My Store")
	public void title_should_be_Search_My_Store() {
		System.out.println("verify title");
		assertEquals("My Store", title);
	}
	
	@When("the user clicks on the Sign in link")
	public void the_user_clicks_on_the_Sign_in_link() {
		HomePage homePage = new HomePage();
		homePage.signin.click();
	}

	@Then("username and password fields ahould be displayed")
	public void username_and_password_fields_ahould_be_displayed() {
	    SigninPage signinPage = new SigninPage();
	    assertTrue(signinPage.loginEmail.isDisplayed());
	    assertTrue(signinPage.password.isDisplayed());
	    
	}
	
	@Then("the title and url should be:")
	public void the_title_and_url_should_be(Map<String, String> map) {
	    
		String expectedTitle = map.get("Title");
	    assertEquals(expectedTitle, Driver.getDriver().getTitle());
	    
	    String expectedUrl = map.get("Url");
	    assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());
	}

	@When("the user is on the signin page")
	public void the_user_is_on_the_signin_page() {
	    
	}





}
