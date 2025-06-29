package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
		logger.info("Starting test execution...");
		LandingPage lp = new LandingPage(driver);
		
		logger.info("Clicking on SignIn button");
		lp.clickOnSignIn();
		
		
		SignInPage sp = new SignInPage(driver);
		logger.info("Validating if the signup page successfully accessed");
		AssertJUnit.assertEquals(sp.verifySignupPage(), true);
		
		logger.info("Entering username and email address");
		String username = "Test" +" " +RandomStrings();
		String email = username.replace(" ", ".")+"@yopmail.com";

		sp.setUserName(username);
		sp.setEmaikl(email);
		
		logger.info("Clicking in Sign up button...");
		sp.clickSignup();
		
		SignupInnerPage sip = new SignupInnerPage(driver);
		
		logger.info("Verifying access to sign up inner page..");
		
		AssertJUnit.assertEquals(sip.checkInnerSignupPage(), true);
		
		logger.info("Filling up the details..");
		
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
