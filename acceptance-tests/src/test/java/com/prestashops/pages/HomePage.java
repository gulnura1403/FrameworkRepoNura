package com.prestashops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.prestashops.utilities.Driver;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="search_query_top")
	public WebElement search;
	
	// FindBy works only with fixed string
	@FindBy(className="login")
	public WebElement signin;
	
	// takes a name of product, bulds a smart css based on the name
	// and locates the product with new css, @param product name  
	// css will return any item u pass in the same kind of elements
	public WebElement item(String item) {
		String css = "#center_column a.product-name[title='"+item+"']";
		return Driver.getDriver().findElement(By.cssSelector(css));
	}
	
}
