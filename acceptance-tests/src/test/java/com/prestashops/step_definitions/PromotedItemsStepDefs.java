package com.prestashops.step_definitions;

import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import com.prestashops.pages.HomePage;
import com.prestashops.pages.ItemPage;
import com.prestashops.utilities.Driver;
import com.prestashops.utilities.ExcelUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PromotedItemsStepDefs {

	HomePage homePage = new HomePage();
	ItemPage itemPage = new ItemPage();

	@When("the system should display the promoted items")
	public void the_system_should_display_the_promoted_items() {
		// read excel file

		ExcelUtil excelObject = new ExcelUtil("myown.xlsx", "data");
		// get the value of execute column, if yes
		// get all rows
		List<Map<String, String>> allRows = excelObject.getDataList();
		// to look at each row individually
		for (Map<String, String> row : allRows) {
			// get the value of execute from each row, if yes

			String product = row.get("Product");
			if (row.get("Execute").equalsIgnoreCase("Y")) {
				System.out.println("Testing " + product);
				assertTrue(homePage.item(product).isDisplayed());
			} else {
				System.out.println("Skipping " + product);
			}
		}

		// get the product name and verify it is displayed on the homepage
	}

	@Then("the item details should be correct")
	public void the_item_details_should_be_correct() {
		// read excel file
		ExcelUtil excelObject = new ExcelUtil("myown.xlsx", "data");
		// get all rows
		List<Map<String, String>> allRows = excelObject.getDataList();
		
		// to look at each row individually
		for (int i = 0; i < allRows.size();  i++) {
			Map<String, String> row = allRows.get(i);
	
			// get the value of execute from each row, if yes
			String product = row.get("Product");
			if (row.get("Execute").equalsIgnoreCase("Y")) {
				homePage.item(product).click();
				// get the expected values from the excel
				String price = row.get("Price");
				String color = row.get("Color");
				String style = row.get("Style");
				System.out.println("Price " + price);
				System.out.println("Color " + color);
				System.out.println("Style " + style);
				// actual values from UI
				String actualPrice = itemPage.price.getText();
				// Color elements doesnt have text, th ecol saved in th ename attribute
				String actualColor = itemPage.selectedColor.getAttribute("Name");
				String actualStyle = itemPage.styles.getText();
				
				if(price.endsWith(".0")) {
					price = "$"+price+"0";
				}else {
					price = "$"+price;
				}
				
				assertEquals(price, actualPrice);
				assertEquals(color, actualColor);
				assertEquals(style, actualStyle);
				
				// go back to home page
				Driver.getDriver().navigate().back();
				
				excelObject.setCellData("pass", "Status", (i+1));

			} else {
				System.out.println("Skip " + product);
				excelObject.setCellData("Skipped", "Status", (i+1));
			}
		}
	}

}
