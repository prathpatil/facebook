package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Signup_page {
	

	@FindBy (xpath="//a[text()='Sign Up']")
	private WebElement creatnewaccount;
	
	@FindBy (xpath="//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement surename;
	
	@FindBy (xpath="//input[@name='reg_email__']")
	private WebElement mobileno;
	
	@FindBy (xpath="//input[@name='reg_passwd__']")
	private WebElement newpassword;

	@FindBy (xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy (xpath="//select[@id='month']")
	private WebElement month;

	@FindBy (xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy (xpath="//label[text()='Male']")
	private WebElement gender;

	@FindBy (xpath="(//button[text()='Sign Up'])[1]")
	private WebElement signup;
	
	//Constructor-Initialization
	
	public Signup_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
	//Methods-action on WebElement
	
		public void clickoncreatenewaccount() {
			creatnewaccount.click();
		}
		public void sendfirstname() {
			firstname.sendKeys("lalu");
		}
		public void sendsurname() {
			surename.sendKeys("yadav");
		}
		public void sendmobileno() {
			mobileno.sendKeys("0000000000");
		}
		public void setnewpassword() {
			newpassword.sendKeys("laluyadav");
		}
		public void sendday() {
			Select d=new Select(day);
			d.selectByValue("1");
		}
		public void sendmonth() {
			Select m=new Select(month);
			m.selectByIndex(0);
		}
		public void sendyear() {
			Select y=new Select(year);
			y.selectByValue("2000");
		}
		public void clickonmale() {
			gender.click();
		}
		public void clickonsignin() {
			signup.click();
		}


}
