package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class CarPage extends Base {

	public CarPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	@FindBy(xpath = "//p[contains(text(),'Drivers must be at least')]")
	public static WebElement scrolldown;
	@FindBy(xpath = "//button[@data-hook='cars-page_continue']//span")
	public static WebElement carpagecontinue;
	
	public void car()
	{
		System.out.println("----Car Page----");
		Common.scroll(scrolldown);
		//Common.title("Cars");
		Common.assertion(carpagecontinue, "Continue button");
		Common.performClick(carpagecontinue, "Car page continue button is selected ");
		System.out.println("Car page @Test terminated");
		System.out.println(" ");	
	}
}
