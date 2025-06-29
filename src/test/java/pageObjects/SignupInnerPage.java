package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtilities;

public class SignupInnerPage extends BasePage
{
	
	WaitUtilities wutils = new WaitUtilities();
	public SignupInnerPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@type='radio' and @value='Mr']")
	WebElement btn_radioMale;
	
	@FindBy(xpath="//input[@type='radio' and @value='Mrs']")
	WebElement btn_radiofemale;
	
	@FindBy(id="name")
	WebElement txt_name;
	
	@FindBy(id="email")
	WebElement txt_email;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="days")
	WebElement drp_days;
	
	@FindBy(id="months")
	WebElement drp_months;
	
	@FindBy(id="years")
	WebElement drp_years;
	
	@FindBy(xpath="//div[@class='login-form']//h2//b[text()='Enter Account Information']")
	WebElement lbl_innersignup;
	
	
	public boolean checkInnerSignupPage()
	{
		wutils.elementTobeVisible(driver, lbl_innersignup);
		return lbl_innersignup.isDisplayed();
	}
	
	public void selectGender()
	{
		btn_radioMale.click();
	}
	
	public String returnUsername()
	{
		return txt_name.getDomAttribute("value");
	}
	
	public String returnEmail()
	{
		return txt_email.getDomAttribute("value");
	}
	
	public void setPassword(String pw)
	{
		txt_password.sendKeys(pw);
	}
	
	public void setDay(String day)
	{
		Select st = new Select(drp_days);
		st.selectByValue(day);
	}
	
	public void setMonth(String mnth)
	{
		Select st = new Select(drp_months);
		st.selectByVisibleText(mnth);
	}
	
	public void setYear(String yr)
	{
		Select st = new Select(drp_years);
		st.selectByValue(yr);
	}
	
	
	
}
