package com.prestashops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.prestashops.utilities.Driver;

public class ItemPage {
	
	public ItemPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	} 
	
	@FindBy(tagName = "h1")  ////h1[.='Printed Dress']
	public WebElement itemName;
	
	@FindBy(id = "quantity_wanted") 
	public WebElement count;
	
	@FindBy(className = "icon-plus") 
	public WebElement plus;
	
	@FindBy(className = "icon-minus") 
	public WebElement minus;
	
	@FindBy(css = "#product_condition>.editable") 
	public WebElement conditon;
	
	@FindBy(className = "our_price_display") 
	public WebElement price;
	
	
	// Select drop down object
	public Select size() {
		return new Select(Driver.getDriver().findElement(By.id("group_1")));
	}
	
	@FindBy(xpath = "//table[@class='table-data-sheet']/tbody/tr[2]/td[2]") 
	public WebElement styles;
	
	@FindBy(css = ".color_pick.selected") //-> means has 2 classes(.): class .color_pic and class .selected
	public WebElement selectedColor;
	
	
}
