package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class HotelPage extends Base {

	public HotelPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = "//button[@data-hook='hotels-page_continue']")
	public static WebElement Continuebutton;
	
	public void hotelPage() {
		System.out.println("----Hotel Page----");
		Common.scroll(Continuebutton);
		//Common.title("Hotels");
		Common.assertion(Continuebutton, "Continue button");
		Common.performClick(Continuebutton, "Continue button clicked");
		System.out.println("Hotel page @ test completed");
		System.out.println(" ");

	}
}

