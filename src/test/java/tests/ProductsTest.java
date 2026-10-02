package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsPage;



public class ProductsTest extends BaseTest {
	
	String product1 = "Sauce Labs Backpack";
	String product2 = "Sauce Labs Bike Light";
	
    @Test
	public void addSingleProductTest() 
    {
		ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
		productsPage.addToCart(product1);
		String cartBadge=productsPage.getCartBadge();
		Assert.assertEquals(cartBadge, "1");

    }
    
    @Test
    public void addMultipleProductsTest()  {
    	
		ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
		productsPage.addToCart(product1);
		productsPage.addToCart(product2);
		String cartBadge=productsPage.getCartBadge();
		Assert.assertEquals(cartBadge, "2");


        // TC04
    }
}
