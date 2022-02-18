package testngbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SignINTestNG {
	static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Downloads/CD/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String baseURL="https://geophy.com/evra/";
		driver.get(baseURL);
		
	}
	
	
	@Test
	
	public  static void logintoGeophy() throws InterruptedException
	{
		
		String userName="skillschallenge@geophy.com";
		String passWord ="*WPs!8)s)/g.06an3bs}";
		String address= "555 N. College Avenue, Tempe, AZ, 85281";
		String noofUnits ="200";
		String year_built = "2000";
		String net_operating_income= "2000000";
				
		driver.findElement(By.xpath("//div[@class='hero__buttons']//a[@href='https://evra.geophy.com/']")).click();
		driver.findElement(By.xpath("//div[@class='flex flex-row mt-8 space-x-4']//button[contains(text(), 'Log in')]")).click();
		String title = driver.getTitle();
	
		System.out.println("the page title is :"+title);
		
		
		Assert.assertEquals(title, "Signin");
		Thread.sleep(2000);
     	driver.findElement(By.xpath("//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@id='signInFormUsername' and  @type='text' ]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@id='signInFormPassword' and  @type='password' ]")).sendKeys(passWord);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@name='signInSubmitButton' and @type='Submit']")).click();
	
	

		boolean menubuttonpresence1=driver.findElement(By.xpath("//div//a[@href=\"/report/recent\" and contains(text(),'Property Due Diligence')]")).isDisplayed();
		Assert.assertTrue(menubuttonpresence1);
		System.out.println("Property Due Dilience Menu Button Present : " + menubuttonpresence1);
		boolean menubuttonpresence2=driver.findElement(By.xpath("//div//a[@href=\"/properties\" and contains(text(),'Property Map')]")).isDisplayed();
		Assert.assertTrue(menubuttonpresence2);
		System.out.println("Property Map Menu Button Present : " + menubuttonpresence2);
		boolean menubuttonpresence3=driver.findElement(By.xpath("//div//a[@href=\"/insights-portal\" and contains(text(),'Insights Portal')]")).isDisplayed();
		Assert.assertTrue(menubuttonpresence3);
		System.out.println("Insights Portal Menu Button Present : " + menubuttonpresence3);
        
  
		driver.findElement(By.xpath("//div[@class='text-sm pt-4 text-gray-500 underline text-center']//a[contains(text(),'View Sample Property')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("address_input")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search for a property by name or address']")).sendKeys(address);
		Thread.sleep(5000);

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(5000);
		keyDown.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div//div[contains(text(),'Additional inputs required for Evra Valuation')]")).click();
		driver.findElement(By.id("number_of_units")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("number_of_units")).sendKeys(noofUnits);
		driver.findElement(By.id("year_built")).clear();
		driver.findElement(By.id("year_built")).sendKeys(year_built);
		driver.findElement(By.id("noi")).sendKeys(net_operating_income);
		driver.findElement(By.xpath("//button[@type='submit' and @class='w-full button']")).click();
		driver.findElement(By.xpath("//span[@class='hidden lg:inline text-gray-dark ml-2 text-sm group-hover:text-mint']")).click();
		driver.findElement(By.xpath("//span[@class='ml-2 text-gray-dark text-sm group-hover:text-mint']")).click();

  

		Thread.sleep(2000);

	}

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
	


