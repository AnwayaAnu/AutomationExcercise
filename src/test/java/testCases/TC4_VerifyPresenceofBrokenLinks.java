package testCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.SignInPage;

public class TC4_VerifyPresenceofBrokenLinks extends BaseClass
{
	@Test
	public void CheckBrokenLinks() throws IOException
	{
		logger.info("Starting test execution...");
		LandingPage lp = new LandingPage(driver);
		
		logger.info("Clicking on SignIn button");
		lp.clickOnSignIn();
		
		
		SignInPage sp = new SignInPage(driver);
		logger.info("Validating if the signup page successfully accessed");
		AssertJUnit.assertEquals(sp.verifySignupPage(), true);
		
		logger.info("Entering username and email address");
		
		sp.setloginuname("test.doe@yopmail.com");
		sp.setloginpassword("Anwaya94*");
		
		logger.info("Clicking on login button");
		sp.clickOnLogin();
		
		
		logger.info("Verifying if the user successfully logged in");
		HomePage hp = new HomePage(driver);
		AssertJUnit.assertEquals(hp.checkSuccessfullLogin(), true);
		
		logger.info("Checking if the links are broken or not");
		int brokenLinks = hp.ReturnBrokenLinks();
		
		System.out.println("The total no of broken links are: " +brokenLinks);
		
		logger.info("Execution finishing....");
	}
}
