package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.JavascriptUtility;
import utilities.WaitUtilities;

public class LandingPage extends BasePage
{
	JavascriptUtility jutil = new JavascriptUtility();
	WaitUtilities wutils = new WaitUtilities();
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//li//a[text()=' Signup / Login']")
	WebElement link_signup;
	
	@FindBy(xpath="//div[@id='accordian']//div[@class='panel panel-default']//div[@id='Women']")
	WebElement accrdn_women;
	
	@FindBy(xpath="//div[@id='accordian']//div[@class='panel panel-default']//div[@id='Men']")
	WebElement accrdn_men;
	
	@FindBy(xpath="//div[@id='accordian']//div[@class='panel panel-default']//div[@id='Kids']")
	WebElement accrdn_kids;
	
	
	public void clickOnSignIn()
	{
		wutils.elementtobeClickable(driver, link_signup);
		jutil.clickUsingJavascript(driver,link_signup);
		//link_signup.click();
	}
	
	
	
	
	
}
