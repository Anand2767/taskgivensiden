package org.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pages.Locators;
import org.utilities.CommanUtility;

import io.cucumber.java.en.*;

public class AutomationSteps extends CommanUtility {
	Locators l;
	List<String> productname;
	List<String> pricename;
	List<String> afterpricename;

	@Given("the user should be in  saucedemo")
	public void the_user_should_be_in_saucedemo() {
		ChromeLaunch();
		UrlLaunch("https://www.saucedemo.com/");
		implicitWait(10);
	}

	@When("The user login to application")
	public void the_user_login_to_application() {
		l = new Locators();
		l.login("standard_user", "secret_sauce");
	}

	@When("The user add the products to the cart")
	public void the_user_add_the_products_to_the_cart() {
		click(l.getProduct());
		click(l.getBasket());
		click(l.getCheckout());
		sendKeys(l.getFirstname(), "Anand");
		sendKeys(l.getLastname(), "Kumaran");
		sendKeys(l.getPostalcode(), "623623");
		click(l.getContinuebutton());
		click(l.getFinishbutton());
	}

	@Then("To validate the added product is correct or not")
	public void to_validate_the_added_product_is_correct_or_not() {
		click(l.getContinuebutton());
		click(l.getFinishbutton());
		String text = l.getAddeditemname().getText();
		Assert.assertTrue(l.getBeforeitemname().getText().equals(text));
		quit();
	}

	@When("To get all products")
	public void to_get_all_products() {
		List<WebElement> name = l.getItemname();
		 productname=new LinkedList<String>();
		for (WebElement x : name) {
			productname.add(x.getText());
	}}

	@Then("To validate the {string} is availabale or not")
	public void to_validate_the_is_availabale_or_not(String shirt) {
		for (String name : productname) {
			if(name.equals(shirt)) {
				Assert.assertEquals(shirt, name);
			}
		}
		quit();
	}

	@When("To get all product price details and remove the dollor symbol")
	public void to_get_all_product_price_details_and_remove_the_dollor_symbol() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> price = l.getItemPrice();
	 pricename = new LinkedList<String>();
		for (WebElement e : price) {
			String pp = e.getText();
		if(	pp.contains("")) {
			String rp = pp.replace("$", "");
			pricename.add(rp);
		}
		}
	}

	@Then("Validate the product price when user click the product price same or not")
	public void validate_the_product_price_when_user_click_the_product_price_same_or_not() {
		List<WebElement> pn = l.getItemPrice();
		List<WebElement> name = l.getItemname();
		afterpricename = new LinkedList<String>();
		for(int i=0; i<name.size(); i++) {
			name.get(i).click();
			String tt = l.getAfItemPrice().getText();
			if(tt.contains("$")) {
				String rr = tt.replace("$", "");
				afterpricename.add(rr);
			}
			back();
		}
		Assert.assertEquals("Product prices validation",pricename, afterpricename);
		quit();
	}
	@When("The user login to application with ivalid data")
	public void the_user_login_to_application_with_ivalid_data() {
		l = new Locators();
	   l.login("anana", "anana@123");
	}
	@Then("Validate the invalid login error message")
	public void validate_the_invalid_login_error_message() {
		String text = l.getErrormsg().getText();
		Assert.assertTrue("Ivalid login",text.contains("Username and password do not match"));
		quit();
	}

}
