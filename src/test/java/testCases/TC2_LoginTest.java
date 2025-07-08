package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.SignInPage;

public class TC2_LoginTest extends BaseClass
{
	@Test(groups = "sanity")
	public void VerigyLoginFeature()
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
		
		
		logger.info("Clicking on logout button");
		hp.clickLogout();

		
		
		logger.info("Finishing execution....");
		
	}
}
