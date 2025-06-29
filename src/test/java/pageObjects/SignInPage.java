package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtilities;

public class SignInPage extends BasePage
{
	
	WaitUtilities wutils = new WaitUtilities();
	WebDriver driver;
	
	public SignInPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//form[@action='/login']//input[@name='email'] ")
	WebElement txt_usernamelogin;
	
	
	@FindBy(xpath="//form[@action='/login']//input[@name='password'] ")
	WebElement txt_passwordlogin;
	
	@FindBy(xpath="//form[@action='/login']//button[text()='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//form[@action='/signup']//input[@data-qa='signup-name']")
	WebElement txt_signupName;
	
	@FindBy(xpath="//form[@action='/signup']//input[@data-qa='signup-email']")
	WebElement txt_signupEmail;
	
	@FindBy(xpath="//form[@action='/signup']//button[text()='Signup']")
	WebElement btn_signup;
	
	@FindBy(xpath="//div[@class='signup-form']//h2[text()='New User Signup!']")
	WebElement lbl_newSignUp;
	
	
	public void setUserName(String uname)
	{
		//wutils = new WaitUtilities();
		wutils.elementTobeVisible(driver, txt_signupName);
		txt_signupName.sendKeys(uname);
	}
	
	public void setEmaikl(String email)
	{
		//wutils = new WaitUtilities();

		wutils.elementTobeVisible(driver, txt_signupEmail);
		txt_signupEmail.sendKeys(email);
	}
	
	public void clickSignup()
	{
		//wutils = new WaitUtilities();

		wutils.elementtobeClickable(driver, btn_signup);
		btn_signup.click();
	}
	
	public boolean verifySignupPage()
	{
		return lbl_newSignUp.isDisplayed();
	}
	
}
