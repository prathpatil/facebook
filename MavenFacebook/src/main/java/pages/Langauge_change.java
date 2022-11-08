package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Langauge_change {

	@FindBy (xpath="//a[text()='मराठी']")
	private WebElement marathilangauge;
	
	@FindBy (xpath="//a[text()='English (UK)']")
	private WebElement englishlangauge;
	
	@FindBy (xpath="//a[@class='_42ft _4jy0 _517i _517h _51sy']")
	private WebElement morelangauge;
	
	@FindBy (xpath="(//a[text()='नेपाली'])[1]")
	private WebElement nepalilangauge;
	
	@FindBy (xpath="//button[text()='लग इन गर्नुहोस्']")
	private WebElement searchbuttonisclickable;
	
	
	

	//Constructor-Initialization
	
	public Langauge_change(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
	//Methods-action on WebElement
	
		public void clickonmarathi() {
			marathilangauge.click();
		}
		public void clickonenglish() {
			englishlangauge.click();
		}
		public void clickonmoreoption() {
			morelangauge.click();
		}
		public void clickonnepali() {
			nepalilangauge.click();
		}
		public boolean searchbuttonisenabled() {
			boolean result=searchbuttonisclickable.isEnabled();
			return result;
		}

}
