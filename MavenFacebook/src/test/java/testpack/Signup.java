 package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.Signup_page;

public class Signup {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smart\\Desktop\\Automation\\chrome\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Signup_page creatnewaccount = new Signup_page(driver);
		creatnewaccount.clickoncreatenewaccount();
		
		Signup_page firstname = new Signup_page(driver);
		firstname.sendfirstname();
		
		Signup_page surename = new Signup_page(driver);
		surename.sendsurname();
		
		Signup_page mobileno = new Signup_page(driver);
		mobileno.sendmobileno();
		
		Signup_page newpassword = new Signup_page(driver);
		newpassword.setnewpassword();
		
		Signup_page d = new Signup_page(driver);
		d.sendday();
		
		Signup_page m = new Signup_page(driver);
		m.sendmonth();
		
		Signup_page y = new Signup_page(driver);
		y.sendyear();
		
		Signup_page gender = new Signup_page(driver);
		gender.clickonmale();
		
		Signup_page signup = new Signup_page(driver);
		signup.clickonsignin();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "https://www.facebook.com/reg/");
		Assert.assertEquals(title, "Sign up for Facebook | Facebook");
		
}
}