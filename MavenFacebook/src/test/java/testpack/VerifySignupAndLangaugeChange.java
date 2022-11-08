package testpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import pages.Langauge_change;
import pages.Signup_page;
import setup.Base;
import utils.Utility;

public class VerifySignupAndLangaugeChange extends Base{

	WebDriver driver;
	Signup_page creatnewaccount;
	Signup_page firstname;
	Signup_page surename;
	Signup_page mobileno;
	Signup_page newpassword;
	Signup_page d;
	Signup_page m;
	Signup_page y;
	Signup_page gender;
	Signup_page signup;
	Langauge_change marathilangauge;
	Langauge_change englishlangauge;
	Langauge_change morelangauge;
	Langauge_change nepalilangauge;
	Langauge_change searchbuttonisclickable;
	boolean result;
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
	
	public void createPOMobjects() {
		creatnewaccount = new Signup_page(driver);
		firstname = new Signup_page(driver);
		surename = new Signup_page(driver);
		mobileno = new Signup_page(driver);
		newpassword = new Signup_page(driver);
		d = new Signup_page(driver);
		m = new Signup_page(driver);
		y = new Signup_page(driver);
		gender = new Signup_page(driver);
		signup = new Signup_page(driver);
		marathilangauge = new Langauge_change(driver);
		englishlangauge = new Langauge_change(driver);
		morelangauge = new Langauge_change(driver);
		nepalilangauge = new Langauge_change(driver);
		searchbuttonisclickable = new Langauge_change(driver);
	}
	
	@BeforeMethod
	public void openFacebookHomePage() {
		//System.out.println("before method");
		
		driver.get("https://www.facebook.com/");
	}
	

	@Test  (priority=1)
	public void VerifySignUpPageFuncationlity() {
		testID=301;
		System.out.println("signuppage");
		
		
		creatnewaccount.clickoncreatenewaccount();
		firstname.sendfirstname();
		surename.sendsurname();
		mobileno.sendmobileno();
		newpassword.setnewpassword();
		d.sendday();
		m.sendmonth();
		y.sendyear();
		gender.clickonmale();
		signup.clickonsignin();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "https://www.facebook.com/reg/");
		Assert.assertEquals(title, "Sign up for Facebook | Facebook");
		
	}
	
	@Test (priority=2)
	public void VerifyLangaugeChangeFuncationality() {
		testID=401;
		System.out.println("langaugechange");
		
		
		marathilangauge.clickonmarathi();
		englishlangauge.clickonenglish();
		morelangauge.clickonmoreoption();
		nepalilangauge.clickonnepali();
		
		
		result=searchbuttonisclickable.searchbuttonisenabled();
		
		System.out.println(result);
		
		Assert.assertEquals(result, true);
		
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
		creatnewaccount =null;
		firstname = null;
		surename = null;
		mobileno = null;
		newpassword = null;
		d = null;
		m = null;
		y = null;
		gender = null;
		signup = null;
		marathilangauge = null;
		englishlangauge = null;
		morelangauge = null;
		nepalilangauge = null;
		searchbuttonisclickable = null;
		
	}
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("after class");
		driver.close();
		driver=null;
		System.gc();
	}

}
