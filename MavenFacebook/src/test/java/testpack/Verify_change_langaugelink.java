package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.Langauge_change;

public class Verify_change_langaugelink {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smart\\Desktop\\Automation\\chrome\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Langauge_change marathilangauge = new Langauge_change(driver);
		marathilangauge.clickonmarathi();
		
		Langauge_change englishlangauge = new Langauge_change(driver);
		englishlangauge.clickonenglish();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Langauge_change morelangauge = new Langauge_change(driver);
		morelangauge.clickonmoreoption();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Langauge_change nepalilangauge = new Langauge_change(driver);
		nepalilangauge.clickonnepali();
		
		Langauge_change searchbuttonisclickable = new Langauge_change(driver);
		boolean result=searchbuttonisclickable.searchbuttonisenabled();
		
		System.out.println(result);
		
		Assert.assertEquals(result, true);
	
}
}