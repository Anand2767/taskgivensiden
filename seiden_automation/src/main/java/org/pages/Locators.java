package org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.CommanUtility;

public class Locators extends CommanUtility {
	public Locators() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(name = "login-button")
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void login(String username, String password) {
		sendKeys(getUsername(), username);
		sendKeys(getPassword(), password);
		click(getLogin());
	}

	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
	private WebElement product;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement basket;
	@FindBy(xpath = "//button[@name='checkout']")
	private WebElement checkout;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement firstname;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement lastname;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement postalcode;
	
	
	@FindBy(id = "continue")
	private WebElement continuebutton;
	
	

	@FindBy(id = "finish")
	private WebElement finishbutton;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement beforeitemname;
	
	
	public WebElement getBeforeitemname() {
		return beforeitemname;
	}


	public WebElement getProduct() {
		return product;
	}

	public WebElement getBasket() {
		return basket;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPostalcode() {
		return postalcode;
	}

	public WebElement getContinuebutton() {
		return continuebutton;
	}

	public WebElement getFinishbutton() {
		return finishbutton;
	}
	
	
	
	//3
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<WebElement> itemname;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement addeditemname;
	

	public WebElement getAddeditemname() {
		return addeditemname;
	}
	
	public List<WebElement> getItemname() {
		return itemname;
	}
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private List<WebElement> itemPrice;
	
	
	
	public List<WebElement> getItemPrice() {
		return itemPrice;
	}
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private WebElement afitemPrice;
	
	
	
	public WebElement getAfItemPrice() {
		return afitemPrice;
	}
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errormsg;
	
	public WebElement getErrormsg() {
		return errormsg;
	}
	

}
