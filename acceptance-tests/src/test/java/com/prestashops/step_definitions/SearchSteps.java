package com.prestashops.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.prestashops.pages.SearchResultsPage;
import com.prestashops.utilities.BrowserUtils;
import com.prestashops.utilities.Driver;
import com.prestashops.utilities.ExcelUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	SearchResultsPage searchPage = new SearchResultsPage();

	@Given("the user clicks on link Dresses")
	public void the_user_clicks_on_link_Dresses() {
		searchPage.dresses.click();
	}

	@When("the user sorts by {string}")
	public void the_user_sorts_by(String option) {
		searchPage.sortBy().selectByVisibleText(option);
	}

	@Then("the following product should be displayed on top")
	public void the_following_product_should_be_displayed_on_top(Map<String, String> product) {
		Actions action = new Actions(Driver.getDriver());
		action.sendKeys(Keys.ARROW_DOWN).perform();

		String expectedName = product.get("name");
		String expectedPrice = product.get("price");
		String actualName = searchPage.getProductName(1).getText();
		String actualPrice = searchPage.getProductPrice(1).getText();

		assertEquals(expectedName, actualName);
		assertEquals(expectedPrice, actualPrice);

	}

	@Then("the user should be able to sort results")
	public void the_user_should_be_able_to_sort_results() throws InterruptedException {
		// open excel
		// String fileLoco = TestCostants.TEST_DATA_FOLDER+"myown.xlsx";
		ExcelUtil excelObject = new ExcelUtil("myown.xlsx", "sheet1");
		// iterate through data
		List<Map<String, String>> data = excelObject.getDataList();

		boolean passing = false;
		for (int i = 0; i < data.size(); i++) {
			Map<String, String> row = data.get(i);
			
			if (row.get("Execute").equals("Y")) {
				// sort based on excel sort value
				searchPage.sortBy().selectByVisibleText(row.get("Option"));
				Thread.sleep(1000);
				// BrowserUtils.waitFor(1);
				Actions action = new Actions(Driver.getDriver());
				action.sendKeys(Keys.ARROW_DOWN).perform();

				// verify name and price based on value from excel
				String expectedName = row.get("Name");
				String expectedPrice = row.get("Price");
				String actualName = searchPage.getProductName(1).getText();
				String actualPrice = searchPage.getProductPrice(1).getText();

				if (expectedName.equals(actualName) && expectedPrice.equals(actualPrice)) {
					excelObject.setCellData("Passed", "Status", i + 1);
				} else {
					excelObject.setCellData("Failed", "Status", i + 1);
				}

			} else {
				excelObject.setCellData("Skipped", "Status", i + 1);
				passing = false;
			}
		}
		// see if we execute that row
		assertTrue(passing);

}
}

