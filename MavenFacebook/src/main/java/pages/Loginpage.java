package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()='Log in']")
	private WebElement loginbutton;
	

	

	//Constructor-Initialization
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
	//Methods-action on WebElement
	
		public void sendemail(String name)
		{
		    email.sendKeys(name);
		}
		public void senspassword(String pass) 
		{
			password.sendKeys(pass);
			
		}
		public void clickloginbutton() {
			loginbutton.click();
		}
		


}
