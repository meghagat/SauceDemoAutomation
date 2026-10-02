package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusableComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="first-name")
	WebElement firstNameField;
	
	@FindBy(id="last-name")
	WebElement LastNameField;
	
	@FindBy(id="postal-code")
	WebElement postalCodeField;
	
	@FindBy(id="continue")
	WebElement continueButton;

	
	


	
	/*		
	 * 	driver.findElement(By.id("first-name")).sendKeys("selenium");
		driver.findElement(By.id("last-name")).sendKeys("automation");
		driver.findElement(By.id("postal-code")).sendKeys("90090");

		driver.findElement(By.id("continue")).click();

		String checkOutProduct = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
		Assert.assertEquals(checkOutProduct, productName);
	
*/
	
	public void fillCheckOutInformation(String firstName,String LastName,String postalCode) 
	{
		firstNameField.sendKeys(firstName);
		LastNameField.sendKeys(LastName);
		postalCodeField.sendKeys(postalCode);
	}
	
	public CheckOutOverviewPage clickContinue() {
		continueButton.click();
		
		return new CheckOutOverviewPage(driver);
	}

}
