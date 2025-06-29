package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LandingPage;
import pageObjects.SignInPage;
import pageObjects.SignupInnerPage;

public class TC1_SignUp extends BaseClass
{
	@Test
	public void VarifySignup() throws InterruptedException
	{
		LandingPage lp = new LandingPage(driver);
		
		lp.clickOnSignIn();
		
		
		SignInPage sp = new SignInPage(driver);
		Assert.assertEquals(sp.verifySignupPage(), true);
		
		String username = "Test" +" " +RandomStrings();
		String email = username.replace(" ", ".")+"@yopmail.com";

		sp.setUserName(username);
		sp.setEmaikl(email);
		sp.clickSignup();
		
		SignupInnerPage sip = new SignupInnerPage(driver);
		
		Assert.assertEquals(sip.checkInnerSignupPage(), true);
		
		sip.selectGender();
		String UserN = sip.returnUsername();
		
		String em = sip.returnEmail();
		
		String password = "Test"+"@"+RandomStrings();
		
		sip.setPassword(password);
		
		sip.setDay("3");
		sip.setMonth("January");
		sip.setYear("2021");
		
		Thread.sleep(3000);

	}
}
