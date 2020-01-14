package com.prestashops.step_definitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.github.javafaker.Faker;
import com.prestashops.beans.User;
import com.prestashops.pages.AccountInformationPage;
import com.prestashops.pages.MyAccountPage;
import com.prestashops.pages.RegistrationPage;
import com.prestashops.pages.SigninPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationStepDefs {  

	SigninPage signinPage = new SigninPage();
	RegistrationPage registrationPage = new RegistrationPage();
	MyAccountPage myAccountPage = new MyAccountPage();

	@Given("the user enters a random email")
	public void the_user_enters_a_random_email() {
		String email = new Faker().internet().emailAddress();
		signinPage.signupEmail.sendKeys(email + Keys.ENTER);

	}

	@Given("the user enters personal information")
	public void the_user_enters_personal_information(Map<String, String> user) {
		System.out.println(user);
		registrationPage.firstName.sendKeys(user.get("First Name"));
		registrationPage.lastName.sendKeys(user.get("Last Name"));
		registrationPage.address.sendKeys(user.get("Address"));
		registrationPage.city.sendKeys(user.get("City"));
		registrationPage.company.sendKeys(user.get("Company"));
	}

	@Given("the user enters user information")
	public void the_user_enters_user_information(List<User> users) {
		for (User user : users) {
			System.out.println(user.getFirstName());
			System.out.println(user.getLastName());
			System.out.println(user.getAddress());
			System.out.println(user.getCity());
			System.out.println(user.getCompany());
			
			registrationPage.firstName.sendKeys(user.getFirstName());
			registrationPage.lastName.sendKeys(user.getLastName());
			registrationPage.address.sendKeys(user.getAddress());
			registrationPage.city.sendKeys(user.getCity());
			registrationPage.company.sendKeys(user.getCompany());

		}
	}
	
	@When("the user clicks on my personal information button")
	public void the_user_clicks_on_my_personal_information_button() {
	    myAccountPage.myPersonalInformation.click();
	}

	@Then("the system should display the users account information")
	public void the_system_should_display_the_users_account_information(List<User> users) {
		AccountInformationPage accountInformationPage = new AccountInformationPage();
		User user = users.get(0);
	    String firstName = user.getFirstName();
	    String lastName = user.getLastName();
	    Assert.assertEquals(firstName, accountInformationPage.firstName.getAttribute("value"));
	    Assert.assertEquals(lastName, accountInformationPage.lastName.getAttribute("value"));

	}

}
