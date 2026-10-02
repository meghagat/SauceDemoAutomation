package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusableComponents.AbstractComponent;

public class ProductsPage extends AbstractComponent {
	
	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css=".title")
	WebElement productsPageTitle;
	
	@FindBy(css=".inventory_item_description")
	List<WebElement> products;
	
	By productLabel = By.cssSelector(".inventory_item_label a div");
	
	By priceBarButton= By.cssSelector(".pricebar button");
	
	@FindBy(css=".shopping_cart_badge")
	WebElement cartBadge;
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartButton;
	
	@FindBy(css=".inventory_item_price")
	WebElement itemPriceField;


	
	public String verifyProductsPageTitle()
	
	{
		String productsHeader= productsPageTitle.getText();
		return productsHeader;
		
	}
	
	public WebElement getMatchingProduct(String productName)
	{
		WebElement matchedProduct = products.stream()
				.filter(product -> product.findElement(productLabel).getText()
						.equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		
		return matchedProduct;

	}
	
	
	public void addToCart(String productName) {
		WebElement matchedProduct=getMatchingProduct(productName);
		matchedProduct.findElement(priceBarButton).click();
	}

	public String getCartBadge() 
	{
		String badgeNum= cartBadge.getText();
		return badgeNum;
		
	}
	
	public String getItemPrice() 
	{
		String itemPrice= itemPriceField.getText();
		return itemPrice;
		
	}

	
	//		String price = matchedProduct.findElement(By.cssSelector(".inventory_item_price")).getText();

	
	public CartPage clickOnCart() {
		cartButton.click();
		return new CartPage(driver);
	}

}
