package testpack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.Loginpage;

public class Login_page {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smart\\Desktop\\Automation\\chrome\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Loginpage email = new Loginpage(driver);
		email.sendemail(null);
		
		Loginpage password = new Loginpage(driver);
		password.senspassword(null);
		
		Loginpage loginbutton = new Loginpage(driver);
		loginbutton.clickloginbutton();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "https://www.facebook.com/");
		Assert.assertEquals(title, "Log in to Facebook");
		
	
}
}
