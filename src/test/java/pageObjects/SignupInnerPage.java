package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="//input[@type='radio' and @value='Mr']") WebElement btn_radioMale;
	
	@FindBy(xpath="//input[@type='radio' and @value='Mrs']") WebElement btn_radiofemale;
	
	@FindBy(id="name") WebElement txt_name;
	
	@FindBy(id="email") WebElement txt_email;
	
	@FindBy(id="password") WebElement txt_password;
	
	@FindBy(id="days") WebElement drp_days;
	
	@FindBy(id="months") WebElement drp_months;
	
	@FindBy(id="years") WebElement drp_years;
	
	@FindBy(xpath="//div[@class='login-form']//h2//b[text()='Enter Account Information']") WebElement lbl_innersignup;
	
	@FindBy(id="first_name") WebElement txt_fname;
	
	@FindBy(id="last_name") WebElement txt_lname;
	
	@FindBy(id="address1") WebElement txt_addr1;
	
	@FindBy(id="country") WebElement drp_country;
	
	@FindBy(id="state") WebElement txt_state;
	
	@FindBy(id="city") WebElement txt_city;
	
	@FindBy(id="zipcode") WebElement txt_zipcode;
	
	@FindBy(id="mobile_number") WebElement txt_phone;
	
	@FindBy(xpath="//button[text()='Create Account']") WebElement btn_createAccount;
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']//h2//b[text()='Account Created!']") WebElement checkAccountcreation;
	
	
	
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
	
	public void setFirstName(String firstname)
	{
		txt_fname.sendKeys("firstname");
	}
	
	public void setLastname(String lastname)
	{
		txt_lname.sendKeys(lastname);
	}
	
	public void setAddress(String addrs)
	{
		txt_addr1.sendKeys(addrs);
	}
	
	public void selectCountry(String cntry)
	{
		Select st = new Select(drp_country);
		st.selectByVisibleText(cntry);
	}
	
	public void setState(String state)
	{
		txt_state.sendKeys(state);
	}
	
	public void setCity(String city)
	{
		txt_city.sendKeys(city);
	}
	
	public void setZipcode(String zip)
	{
		txt_zipcode.sendKeys(zip);
	}
	
	public void setPhoneNo(String ph)
	{
		txt_phone.sendKeys(ph);
	}
	
	public void clickOnCreateAccount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView", btn_createAccount);
		//wutils.elementtobeClickable(driver, btn_createAccount);
		txt_phone.click();
	}
	
	public boolean CheckaccountCreation()
	{
		
		wutils.elementTobeVisible(driver, checkAccountcreation);
		return checkAccountcreation.isDisplayed();
	}
	
	
	
}
