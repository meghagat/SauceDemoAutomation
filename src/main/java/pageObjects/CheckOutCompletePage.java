package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.AbstractComponent;

public class CheckOutCompletePage extends AbstractComponent {
	WebDriver driver;


	public CheckOutCompletePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css=".complete-header")
	WebElement successMessageField;

	
	public String getSuccessMessage()
	{
		return successMessageField.getText();
		
	}

}
