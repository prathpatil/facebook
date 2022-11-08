package testpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Forget_acc_link;
import pages.Loginpage;
import setup.Base;
import utils.Utility;

public class VerifyForgetAccLinkAndLogInPage extends Base{
	
	private WebDriver driver;
	private Forget_acc_link forgottenaccount;
	private Forget_acc_link identifyemail;
	private Forget_acc_link searchbutton;
	private Forget_acc_link searchbuttondisplayed;
	private boolean result;
	private Loginpage email;
	private Loginpage password;
	private Loginpage loginbutton;
	public int testID;
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchTheBrowser(String browserName){
		
		
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
	    }
		
		if(browserName.equals("Opera"))
		{
			driver=openOpreaBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@BeforeClass
	
	public void createPOMobjects()
	{
		forgottenaccount = new Forget_acc_link(driver);
		identifyemail = new Forget_acc_link(driver);
		searchbutton = new Forget_acc_link(driver);
		searchbuttondisplayed = new Forget_acc_link(driver);
		
		email = new Loginpage(driver);
		password = new Loginpage(driver);
		loginbutton = new Loginpage(driver);
	}
	@BeforeMethod
	public void openFacebookHomePage()  {
		//System.out.println("before method");
	
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void VerifyForgetAccLink() {
		testID=101;
		System.out.println("forgeyacclink");
	
		forgottenaccount.clickonforgoteaccount();	
		identifyemail.identifyemail();
		searchbutton.clicksearchbutton();
		result=searchbuttondisplayed.searchbuttonisdisplayed();
		
	    System.out.println(result);	

		//Assert.assertEquals(result, true);  
	    Assert.assertEquals(result, false);
		
	}
	
	@Test
	public void VerifyLoginFuncationlity() throws EncryptedDocumentException, IOException {
		testID=201;
		System.out.println("loginfunctionality");
		
		String value = Utility.getDataFromExelSheet("Document",6,0);
		email.sendemail(value);
		
	    value = Utility.getDataFromExelSheet("Document",6,1);
		password.senspassword(value);
		
		loginbutton.clickloginbutton();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "https://www.facebook.com/");
		Assert.assertEquals(title, "Log in to Facebook");
		
		//https://www.facebook.com/
        //Facebook – log in or sign up
	
	
	}
	
	@AfterMethod
	public void logoutFromFacebook(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.capturescreenshot(testID, driver);
		}
		System.out.println("after method");
		System.out.println("logout");
	}
	
	@AfterClass
	public void clearObject() {
		
		forgottenaccount = null;
		identifyemail =null;
		searchbutton = null;
		searchbuttondisplayed = null;
		email =null;
		password = null;
		loginbutton =null;
	}
	
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("after class");
		driver.close();
		driver=null;
		System.gc();
	}
	


}
