package com.prestashops.step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.prestashops.pages.HomePage;
import com.prestashops.pages.ItemPage;
import com.prestashops.utilities.BrowserUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductInformnationValidationStepDefs {
 
	HomePage homePage = new HomePage();
	ItemPage itemPage = new ItemPage();

	@When("the user should be able to see {string}")
	// .item gets argument and returns the Element on the homepage
	public void the_user_should_be_able_to_see(String productName) {
		assertTrue(homePage.item(productName).isDisplayed());
	}

	@When("the user should be able to see following products")
	public void the_user_should_be_able_to_see_following_products(List<String> products) {
		System.out.println(products.size());
		for (String product : products) {
			System.out.println(products);
			assertTrue(homePage.item(product).isDisplayed());
		}
	}

	@Then("the product be available in the following sizes")
	public void the_product_be_available_in_the_following_sizes(List<String> sizes) {
		System.out.println("number of sizes: " + sizes.size());

		for (String expectedSize : sizes) {
			System.out.println(expectedSize);
		}

		// FROM THE DROP DOWN-> WE PRINTED ALL OPTIONS AND 
		// PUT THE ELEMENTS INSIDE THE LIST
		// sizeSelect.getOptions()->> shows all options of drop-down list
		// 
		
		Select sizeSelect = itemPage.size();
		// will contain the actual sizes

		List<String> actualList = new ArrayList<>();
		
		// get all options from the drop-down and 
		// add the text of the option to the actuallist
		for (WebElement optionElement : sizeSelect.getOptions()) {
			actualList.add(optionElement.getText());
		}
		
		assertTrue(sizes.equals(actualList));
	}
	
	@Then("the system should display the product information:")
	public void the_system_should_display_the_product_information(Map<String, String> product) {
	    System.out.println(product);
	    
		ItemPage itemPage = new ItemPage();
	    
	    String expectedName = product.get("name");
	    System.out.println("Product name: " +expectedName);
	    assertEquals(expectedName, itemPage.itemName.getText());
	    
	    String expectedPrice = product.get("price");
	    System.out.println("Product price: " +expectedPrice);
	    assertEquals(expectedPrice, itemPage.price.getText());
	    
	    String expectedSize = product.get("size");
	    System.out.println("Product size: " +expectedSize);
	    assertEquals(expectedSize, itemPage.size().getFirstSelectedOption().getText());
	    
	    String expectedCondition = product.get("condition");
	    System.out.println("Product condition: " +expectedCondition);
	    assertEquals(expectedCondition, itemPage.conditon.getText());
	    
	    String expectedCount = product.get("count");
	    System.out.println("Product count: " +expectedCount);
	    assertEquals(expectedCount, itemPage.count.getAttribute("value"));

	}



}
