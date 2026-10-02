package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reusableComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

		
	}
	
	@FindBy(id="user-name")
	WebElement userNameField;
	
	@FindBy(id="password")
	WebElement userPasswordField;
	
	@FindBy(id="login-button")
	WebElement submit;
	
	@FindBy(css="h3[role='alert']")
	WebElement errorAlert;
	
	String url = "/inventory";
	
	public ProductsPage validLogin(String userName,String password) 
	{
		userNameField.sendKeys(userName);
		userPasswordField.sendKeys(password);
		submit.click();
		waitForUrl(url);
		return new ProductsPage(driver);
	}
	
	public String invalidLogin(String userName,String password) 
	{
		userNameField.sendKeys(userName);
		userPasswordField.sendKeys(password);
		submit.click();
		waitForElement(errorAlert);
		return errorAlert.getText();
	}



}
