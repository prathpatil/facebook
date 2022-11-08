package testpack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.Forget_acc_link;


public class Forgotacc_link {
	
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smart\\Desktop\\Automation\\chrome\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	
	Forget_acc_link forgottenaccount = new Forget_acc_link(driver);
	forgottenaccount.clickonforgoteaccount();
	
	Forget_acc_link identifyemail = new Forget_acc_link(driver);
	identifyemail.identifyemail();
	
	Forget_acc_link searchbutton = new Forget_acc_link(driver);
	searchbutton.clicksearchbutton();
	
	Forget_acc_link searchbuttondisplayed = new Forget_acc_link(driver);
	
	boolean result=searchbuttondisplayed.searchbuttonisdisplayed();
	
    System.out.println(result);	

	Assert.assertEquals(result, true);  
	
	
}
}