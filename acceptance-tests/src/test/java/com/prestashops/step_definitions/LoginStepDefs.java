package com.prestashops.step_definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.prestashops.pages.HomePage;
import com.prestashops.pages.MyAccountPage;
import com.prestashops.pages.RegistrationPage;
import com.prestashops.pages.SigninPage;
import com.prestashops.utilities.BrowserUtils;
import com.prestashops.utilities.ConfigurationReader;
import com.prestashops.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

	SigninPage signinPage = new SigninPage();
	String email;

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		// opens website
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		// go to login page
		new HomePage().signin.click();
	}  

	@When("the user logs in using username {string} and password {string}")
	public void the_user_logs_in_using_username_and_password(String username, String password) {
		signinPage.loginEmail.sendKeys(username);
		signinPage.password.sendKeys(password+Keys.ENTER);
		//signinPage.password.click();
		// .submit() -> submits current method from selenium, if specifically states
		// "Sign in", u can't use submit
		// signinPage.password.submit();//instead of "Sign in" button
	}

	@Then("users full name {string} should be displayed")
	public void users_full_name_should_be_displayed(String fullName) {
		// String expected = firstName + " " +lastName;
		String expected = fullName;
		String actual = new MyAccountPage().fullName.getText();
		assertEquals(expected, actual);
	}

	@When("the user tries to register an invalid email")
	public void the_user_tries_to_register_an_invalid_email() {
		signinPage.signupEmail.sendKeys("noranora.com");
		signinPage.signupEmail.submit();
	}

	@Then("the system should display error message {string}")
	public void the_system_should_display_error_message(String message) {
		// we fixed the error:
		// ...the_system_should_display_error_message(LoginStepDefs.java:62)...
		// signinPage.errorMessage is always present on the page with or without any
		// error
		// but it only becomes visible when there is an actual error message
		// calling an explicit wait utility method to wait for visibility of the error
		// message

		BrowserUtils.waitForVisibility(signinPage.errorMessage, 5);

		// now that element is fully LOADED, we can capture the text
		String actual = signinPage.errorMessage.getText();
		assertEquals(message, actual);
	}

	@When("the user tries to register blank email")
	public void the_user_tries_to_register_blank_email() {
		// submit the form without entering an email
		// u can submit only after u send keys
		signinPage.signupEmail.sendKeys("");
		signinPage.signupEmail.submit();
	}

	@Given("there is an existing user")
	public void there_is_an_existing_user() throws InterruptedException {

		// generate and enter new email
		// click register
		// enter first name, lastname, password, address ...
		// finalize registration

		Faker fake = new Faker();
		new HomePage().signin.click();
		email = fake.name().username() + "@gmail.com";
		signinPage.signupEmail.sendKeys(email + Keys.ENTER);

		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.firstName.sendKeys(fake.name().firstName());
		registrationPage.lastName.sendKeys(fake.name().lastName());
		registrationPage.password.sendKeys("password123");
		Address address = fake.address();
		registrationPage.address.sendKeys(address.buildingNumber() + " " + address.streetName());
		registrationPage.city.sendKeys(address.city());

		// BrowserUtils.waitFor(2); -> since i don't have this meth, use thread.sleep
		// Thread.sleep(2);
		Select stateList = registrationPage.stateList();
		stateList.selectByValue("2");

		registrationPage.zipCode.sendKeys("60625");
		registrationPage.mobilePhone.sendKeys(fake.phoneNumber().cellPhone()+Keys.TAB);
		registrationPage.register.click();
		
		MyAccountPage myAccountPage = new MyAccountPage();
		myAccountPage.logout.click();

//		BrowserUtils.waitFor(2); -> programmatically fail to get the screenshot
//		fail();

	}

	@When("the user tries to register the same email")
	public void the_user_tries_to_register_the_same_email() {
		signinPage.signupEmail.sendKeys(email +Keys.ENTER);
	}

}
