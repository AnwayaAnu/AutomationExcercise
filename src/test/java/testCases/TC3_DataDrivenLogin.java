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
import utilities.DataProviderUtility;

public class TC3_DataDrivenLogin extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviderUtility.class, groups="datadriven")
	public void VerigyDatadrivenLoginFeature(String username, String password, String res)
	{
		logger.info("Starting test execution...");
		try
		{
		
		LandingPage lp = new LandingPage(driver);
		
		logger.info("Clicking on Login/SignIn button");
		lp.clickOnSignIn();
		
		
		SignInPage sp = new SignInPage(driver);
		logger.info("Validating if the signup page successfully accessed");
		AssertJUnit.assertEquals(sp.verifySignupPage(), true);
		
		logger.info("Entering username and email address");
		
		sp.setloginuname(username);
		sp.setloginpassword(password);
		
		logger.info("Clicking on login button");
		sp.clickOnLogin();
		
		logger.info("Verifying if the user successfully logged in");
		HomePage hp = new HomePage(driver);
		
		boolean checkSuccess = hp.checkSuccessfullLogin();
		
		if(res.equals("Valid"))
		{
			if(checkSuccess==true)
			{
				AssertJUnit.assertTrue(true);
				hp.clickLogout();
				
			}
			else
			{
				AssertJUnit.assertTrue(false);
			}
		}
		else
		{
			if(checkSuccess==true)
			{
				AssertJUnit.assertTrue(false);
				hp.clickLogout();
			}
			else
			{
				AssertJUnit.assertTrue(true);
			}
		}
		
	}
		catch(Exception e)
		{
			AssertJUnit.fail("An exception occured..." +e.getMessage());
		}
		
		
		logger.info("Finishing execution....");

	}
	
		
		
}
