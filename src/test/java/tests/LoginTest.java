package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DataReader;
import pageObjects.ProductsPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void validLoginTest() {
		
		ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
		String productsHeader =productsPage.verifyProductsPageTitle();
		Assert.assertEquals(productsHeader, "Products");

	}
	
	@Test(dataProvider= "invalidLoginData")
	public void inValidLoginTest(HashMap<String, String> input) {
		
		String errorMessage = loginPage.invalidLogin(input.get("username"), input.get("password"));
		Assert.assertTrue(errorMessage.contains("Username and password do not match any user in this service"));

	}
	
	@DataProvider
	public Object[][] invalidLoginData() throws IOException {
		
		DataReader reader = new DataReader();

	    List<HashMap<String, String>> data =
	            reader.getJsonData(
	                System.getProperty("user.dir")+"//src//test//java//resources//LoginData.json");
	    

	    return new Object[][] {
	        {data.get(0)},
	        {data.get(1)},
	        {data.get(2)}
	    };
	}


}
