package baseClass;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public static WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String RandomStrings()
	{
		return RandomStringUtils.randomAlphabetic(3);
	}
	
	public String RandomNos()
	{
		return RandomStringUtils.randomNumeric(3);
	}
	
	public String Alphanos()
	{
		return RandomStringUtils.randomAlphanumeric(3);
	}
	
	
	
}
