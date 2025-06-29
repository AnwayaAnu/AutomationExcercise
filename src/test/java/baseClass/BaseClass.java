package baseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"Os","Browser"})
	public void setUp(String os, String br) throws IOException
	{
		
		logger = LogManager.getLogger(this.getClass());
		
		p = new Properties();
		FileReader file = new FileReader("/Users/anwaya/eclipse-workspace1/AutomationExcercise/src/test/resources/config.properties");
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge"   : driver = new EdgeDriver();break;
		case "Firefox": driver = new FirefoxDriver();break;
		default : System.out.println("Invalid browser option...");
		
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		
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
