package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;


	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item_name")
	WebElement cartProduct;
	
	@FindBy(css="#checkout")
	WebElement checkOutButton;

	
	
	public String getCartProduct() 
	{
		String addedProduct=cartProduct.getText();
		return addedProduct;
		
	}
	
	public CheckOutPage clickOnCheckOut() 
	{
		checkOutButton.click();
		return new CheckOutPage(driver);
	}

}
