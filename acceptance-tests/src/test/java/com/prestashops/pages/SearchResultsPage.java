package com.prestashops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.prestashops.utilities.Driver;

public class SearchResultsPage {
	
	public SearchResultsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	} 
	
	@FindBy(id = "selectProductSort")  
	public WebElement sortByElement;
	
	@FindBy(linkText = "Dresses") 
	public WebElement dresses;
	
	//public Select sortBy = new Select(sortByElement);
	public Select sortBy() {
		return new Select(sortByElement);
	}
	
	public WebElement getProductName(int index) {
		String xpath = "(//*[@class='product-container'//a[@class='product-name'])["+index+"]";
		return Driver.getDriver().findElement(By.xpath(xpath));
	}
	
	public WebElement getProductPrice(int index) {
		String xpath = "(//ul[@class='product-list grid row']/li//div[@class='right-block']//span[@class='price product-price'])["+index+"]";
		return Driver.getDriver().findElement(By.xpath(xpath));
	}

}
