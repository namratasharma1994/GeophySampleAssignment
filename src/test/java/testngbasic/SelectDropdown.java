package testngbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SelectDropdown {
	static WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Downloads/CD/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://geophy.com/evra/");
	}
@Test

public  static void logintoGeophy() throws InterruptedException
{
	String userName="skillschallenge@geophy.com";
	String passWord ="*WPs!8)s)/g.06an3bs}";
	String address="555 N College Ave, Tempe, AZ 85281, USA";
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
	 driver.findElement(By.xpath("//div[@class='ml-2 pb-2']")).click();
	 driver.findElement(By.xpath("//a[@class='nav-main-link hover:text-mint' and @href='/history']")).click();
	 String text=driver.findElement(By.xpath("//a[@class='no-underline text-blue-dark' and @href='/report/db4aeca9-32e2-4069-bbb2-eddab3b565d6/overview']")).getText();
	 System.out.println("First Entry in History Page is : " + text);
	 Assert.assertTrue(text.equals(address));
	 
	
	

}




	
	
}



