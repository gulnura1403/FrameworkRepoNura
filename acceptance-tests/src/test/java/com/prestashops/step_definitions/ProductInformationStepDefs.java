package com.prestashops.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import com.prestashops.pages.HomePage;
import com.prestashops.pages.ItemPage;
import com.prestashops.utilities.Driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductInformationStepDefs {

	HomePage homePage = new HomePage(); // if u create outside may be issues

	@When("the user selectes Printed Summer Dress")
	public void the_user_selectes_Printed_Summer_Dress() {
		homePage.item("Printed Summer Dress").click();
	}

	@Then("product information page should be displayed")
	public void product_information_page_should_be_displayed() {
		String actual = Driver.getDriver().getTitle();
		String expected = "Printed Summer Dress";

		assertTrue(actual.contains(expected));
	}

	@Then("product name should be Printed Summer Dress")
	public void product_name_should_be_Printed_Summer_Dress() {

		ItemPage itemPage = new ItemPage();
		assertEquals("Printed Summer Dress", itemPage.itemName.getText());

	}

	@Then("correct default count size should be displayed")
	public void correct_default_count_size_should_be_displayed() {
		ItemPage itemPage = new ItemPage();

		assertEquals("1", itemPage.count.getAttribute("value"));
		assertEquals("S", itemPage.size().getFirstSelectedOption().getText());
	}

	@When("the user selectes {string}")
	public void the_user_selectes(String item) {
		homePage.item(item).click();
		System.out.println(item);
	}

	@Then("product page title should contain {string}")
	public void product_page_title_should_contain(String item) {
		assertTrue(Driver.getDriver().getTitle().contains(item));
		System.out.println(item);
	}

	@Then("product name should be {string}")
	public void product_name_should_be(String item) {
		ItemPage itemPage = new ItemPage();
		assertEquals(item, itemPage.itemName.getText());
		System.out.println(item);
	}
	
	@Then("correct default count should be {int}")
	public void correct_default_count_should_be(Integer count) {
		ItemPage itemPage = new ItemPage();
		//assertEquals(count, Integer.valueOf(itemPage.count.getAttribute("value")));
		assertEquals(count+"", itemPage.count.getAttribute("value")); //to make it Str/Integer
	}

	@Then("the user should be able to toggle the count")
	public void the_user_should_be_able_to_toggle_the_count() {
		ItemPage itemPage = new ItemPage();
		
		int number = new Random().nextInt(10)+2;
		for (int i = 0; i <= number; i++) {
			itemPage.plus.click();
			assertEquals(i+2+"", itemPage.count.getAttribute("value"));
		}
		
		for (int i = number; i >= 0; i--) {
			itemPage.minus.click();
			assertEquals(i+1+"", itemPage.count.getAttribute("value"));
		}
		
		//VERIFY THAT DEFAULT COUNT OF ITEM GO DOWN BELOW 1
		itemPage.minus.click();
		assertEquals("1", itemPage.count.getAttribute("value"));
		
//		itemPage.plus.click();
//		itemPage.plus.click();
//		itemPage.plus.click();
//		assertEquals(4, itemPage.count.getAttribute("value"));
//		itemPage.minus.click();
//		itemPage.minus.click();
//		assertEquals(2, itemPage.count.getAttribute("value"));


	}
	 
	@Then("the price should be {string}")
	public void the_price_should_be(String expectedPrice) {
	    String actualPrice = new ItemPage().price.getText();
		assertEquals(expectedPrice, actualPrice);
	}
	


}
