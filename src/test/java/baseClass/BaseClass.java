package baseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	
	@BeforeClass(groups="sanity")
	@Parameters({"Os","Browser"})
	public void setUp(String os, String br) throws IOException
	{
		
		logger = LogManager.getLogger(this.getClass());
		
		p = new Properties();
		FileReader file = new FileReader("/Users/anwaya/eclipse-workspace1/AutomationExcercise/src/test/resources/config.properties");
		p.load(file);
		
		if(p.getProperty("env").equals("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			switch(os.toLowerCase())
			{
			case "Windows" : cap.setPlatform(Platform.WIN11);break;
			case "Mac"     : cap.setPlatform(Platform.MAC);
			default        : System.out.println("Invalid os...");
			}
			
			switch(br.toLowerCase())
			{
			case "chrome"  : cap.setBrowserName("chrome");break;
			case "edge"    : cap.setBrowserName("edge");break;
			case "firefox" : cap.setBrowserName("firefox");break;
			default        : System.out.println("Invalid browser option...");
			
			}
			
		    driver = new RemoteWebDriver(new URL("https://localhost:4444"), cap);
			
		}
		
		if(p.getProperty("env").equals("local"))
		
		
		
		{
			
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge"   : driver = new EdgeDriver();break;
		case "Firefox": driver = new FirefoxDriver();break;
		default : System.out.println("Invalid browser option...");
		
		}
		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		
	}
	
	
	

	@AfterClass(groups="sanity")
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
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
