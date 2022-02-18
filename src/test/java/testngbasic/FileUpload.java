	package testngbasic;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.commandhandler.UploadFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class FileUpload {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Downloads/CD/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String baseURL="https://geophy.com/evra/";
		driver.get(baseURL);   //navigates to the page
		
		
	}

	@Test
	
	public  static void fileUpload() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='hero__buttons']//a[@href='https://evra.geophy.com/']")).click();
		driver.findElement(By.xpath("//div[@class='flex flex-row mt-8 space-x-4']//button[contains(text(), 'Log in')]")).click();
		String userName="skillschallenge@geophy.com";
		String passWord ="*WPs!8)s)/g.06an3bs}";
		String address="555 N. College Avenue, Tempe, AZ, 85281";
		String description= "Number of Units: 200\r\n" + 
					"Year of Construction: 2000\r\n" + 
					"Net Operating Income: $2,000,000";
		
		driver.findElement(By.xpath("//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@id='signInFormUsername' and  @type='text' ]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@id='signInFormPassword' and  @type='password' ]")).sendKeys(passWord);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@name='signInSubmitButton' and @type='Submit']")).click();
	
		driver.switchTo().frame("JSD widget"); //switch to frame 
		driver.findElement(By.xpath("//div[@id='help-button' and @class='icon']")).click();
		
		
	
		driver.findElement(By.id("summary")).sendKeys(address);
		driver.findElement(By.id("description")).sendKeys(description);
 
	
		Thread.sleep(2000);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file' and @name='attachment']"));
		chooseFile.sendKeys("C:\\Users\\hp\\Desktop\\xpath.txt");
	
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("submit-button")).click();
	
	
		Thread.sleep(1000);

	
}
}
