package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutCompletePage;
import pageObjects.CheckOutOverviewPage;
import pageObjects.CheckOutPage;
import pageObjects.ProductsPage;

public class EndToEndPurchaseTest extends BaseTest {

	String product1 = "Sauce Labs Backpack";

	@Test
	public void completePurchaseTest() {

		// Login
		ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
		// Add product to cart
		productsPage.addToCart(product1);
		String cartBadge = productsPage.getCartBadge();
		// Verify Cart number
		Assert.assertEquals(cartBadge, "1");
		// Get price
		String price = productsPage.getItemPrice();
		// Click on Cart
		CartPage cartPage = productsPage.clickOnCart();
		// Verify Product in cart
		String addedProduct = cartPage.getCartProduct();
		Assert.assertEquals(addedProduct, product1);
		// Click on checkout
		CheckOutPage checkOutPage = cartPage.clickOnCheckOut();
		// Fill information in checkoutform
		checkOutPage.fillCheckOutInformation("Selenium", "Automation", "90090");
		// Click on continue
		CheckOutOverviewPage checkOutOverviewPage = checkOutPage.clickContinue();
		// Verify product in checkout form
		String checkOutProduct = checkOutOverviewPage.getCheckOutProduct();
		Assert.assertEquals(checkOutProduct, product1);
		// Verify price
		String totalPrice = checkOutOverviewPage.getCheckOutItemTotal();
		Assert.assertTrue(totalPrice.contains(price));
		//Click finish
		CheckOutCompletePage checkOutCompletePage = checkOutOverviewPage.clickOnFinish();
		//Verify success Message
		String successMessage = checkOutCompletePage.getSuccessMessage();
		Assert.assertEquals(successMessage, "Thank you for your order!");

	}

}
