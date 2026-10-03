package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.LoginPage;



public class BaseTest {
	


		
		public WebDriver driver;
	    public LoginPage loginPage;
	    public String username;
	    public String password;

		
		@BeforeMethod(alwaysRun=true)
		public  void initializeDriver() throws IOException 
		{
			//Read properties file
			
			Properties prop = new Properties();
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//GlobalData.properties");
			prop.load(fis);
			
			//Read browser
			
			String browserName=	System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			
			//Decide which browser to launch
			
			if(browserName.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions options = new ChromeOptions();

				Map<String, Object> prefs = new HashMap<>();

				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				options.setExperimentalOption("prefs", prefs);

				options.addArguments("--disable-features=PasswordLeakDetection");

				driver = new ChromeDriver(options);

			}
			
			driver.manage().window().maximize();
			
			driver.get(prop.getProperty("url"));

			
			 loginPage = new LoginPage(driver);


			
		}
		public String getScreenShot(String testCaseName) throws IOException 
		{
			TakesScreenshot ts =(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+".png");
			FileUtils.copyFile(src, file);
			return System.getProperty("user.dir")+"//reports//"+ testCaseName+".png";
			
		}

		@AfterMethod(alwaysRun=true)
		public void closeDriver() 
		{
			driver.quit();
		}
		

	}



