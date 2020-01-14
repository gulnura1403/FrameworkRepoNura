package com.prestashops.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestashops.utilities.Driver;

public class MyAccountPage {
	
	public MyAccountPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	} 
	
	@FindBy(css =".account > span")
	public WebElement fullName;
	
	@FindBy(id="email")
	public WebElement loginEmail;
	
	@FindBy(id="passwd")
	public WebElement password;

	@FindBy(id="SubmitLogin")
	public WebElement submitLogin;
	
	@FindBy(id="logout")
	public WebElement logout;
	
	@FindBy(css="a[title='Information']")
	public WebElement myPersonalInformation;
}
