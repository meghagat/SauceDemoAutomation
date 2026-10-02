package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.AbstractComponent;

public class CheckOutOverviewPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutOverviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".inventory_item_name")
	WebElement checkOutProductField;

	@FindBy(css = ".summary_subtotal_label")
	WebElement itemTotalField;
	
	@FindBy(id = "finish")
	WebElement finishButton;


	// String checkOutProduct =
	// driver.findElement(By.cssSelector(".inventory_item_name")).getText();

	public String getCheckOutProduct() {

		String checkOutProduct = checkOutProductField.getText();

		return checkOutProduct;

	}

	public String getCheckOutItemTotal() {

		String itemTotal = itemTotalField.getText();
		return itemTotal;
	}
	
	public CheckOutCompletePage clickOnFinish() {
		finishButton.click();
		return new CheckOutCompletePage(driver);
	}

}
