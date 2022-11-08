package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

		
	public static WebDriver openChromeBrowser() 
	{  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smart\\Desktop\\Automation\\chrome\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		return driver;
	}
	
	public static WebDriver openOpreaBrowser()
	{
		System.setProperty("webdriver.opera.driver","C:\\Users\\Smart\\Desktop\\Automation\\opera\\operadriver_win64\\operadriver.exe");

		WebDriver driver=new OperaDriver(); 
		
		return driver;
	}
//	public static WebDriver openOpreaBrowser()
//	{
//		System.setProperty("webdriver.opera.driver","C:\\Users\\Smart\\Desktop\\Automation\\opera\\operadriver_win64\\operadriver.exe");
//
//		WebDriver driver=new OperaDriver(); 
//		
//		return driver;
//	}
}
