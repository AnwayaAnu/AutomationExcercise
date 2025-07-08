package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

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
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//li//a[text()=' Logged in as ']") WebElement lbl_uname;
	@FindBy(xpath="//ul//li//a[text()=' Logout']") WebElement btn_logout;
	@FindBy(tagName="a") List<WebElement> links;
	@FindBy(id="search_product") WebElement txt_search;
	@FindBy(id="submit_search") WebElement btn_search;
	@FindBy(xpath="//ul[@class='nav nav-pills nav-justified']/li//a[text()='View Product']") WebElement btnView;
	
	
	
	public void clickOnViewProduct()
	{
		wutils.elementtobeClickable(driver, btnView);
		btnView.click();
	}
	
	
	
	public void setSearchKeyword(String skeyword)
	{
		txt_search.sendKeys(skeyword);
	}
	
	public void clickOnSearchButton()
	{
		wutils.elementtobeClickable(driver, btn_search);
		btn_search.click();
	}
	
	public boolean checkSuccessfullLogin()
	{
		return lbl_uname.isDisplayed();
	}
	
	public void clickLogout()
	{
		wutils.elementTobeVisible(driver, btn_logout);
		btn_logout.click();
	}
	
	public int ReturnBrokenLinks() throws IOException
	{
		int count = 0;
		for(WebElement link:links)
		{
			String urlText = link.getDomProperty("href");
			
			if(urlText==null || urlText.isEmpty())
			{
				System.out.println("The url is empty or null");
			}
			else
			{
				URI uri = URI.create(urlText);
				URL url = uri.toURL();
				
				HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
				hcon.connect();
				
				if(hcon.getResponseCode()>400)
				{
					System.out.println("Broken URL");
					count++;
				}
				else
				{
					System.out.println("Valid links..");
				}
			}
			
			
			
		}
		return count;
	}
}
