package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtilities;

public class HomePage extends BasePage
{
	WaitUtilities wutils = new WaitUtilities();
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul//li//a//b[text()='Test Doe']") WebElement lbl_uname;
	@FindBy(xpath="//ul//li//a[text()=' Logout']") WebElement btn_logout;
	
	public boolean checkSuccessfullLogin()
	{
		return lbl_uname.isDisplayed();
	}
	
	public void clickLogout()
	{
		wutils.elementTobeVisible(driver, btn_logout);
		btn_logout.click();
	}
}
