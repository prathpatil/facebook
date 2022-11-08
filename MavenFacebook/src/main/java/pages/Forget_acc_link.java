package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forget_acc_link {

	@FindBy (xpath="//a[text()='Forgotten password?']")
	private WebElement forgottenaccount;
	
	@FindBy (xpath="//input[@id='identify_email']")
	private WebElement identifyemail;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement searchbutton;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement searchbuttondisplayed;
	
	

	//Constructor-Initialization
	
	public Forget_acc_link(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
	 //Methods-action on WebElement
	
		public void clickonforgoteaccount() {
			forgottenaccount.click();
		}
		public void identifyemail() {
			identifyemail.sendKeys("patil");
		}
		public void clicksearchbutton() {
			searchbutton.click();
		}
		public boolean searchbuttonisdisplayed() {
			boolean result=searchbuttondisplayed.isDisplayed();
			return result;
		}
		
}
