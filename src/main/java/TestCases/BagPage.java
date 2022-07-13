package TestCases;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class BagPage extends Base {

	public BagPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(xpath="//span[contains(text(),'No thanks, skip seat selection.')]")
	public static WebElement skipseatselection;
	
	@FindBy(xpath="//button[@data-hook='ancillaries-page-traveler_0_checked-in_increment']")
	public static WebElement Checkedbag;
	
	@FindBy(xpath="(//span[text()='Continue'])[1]")
	public static WebElement continuee;

	@FindBy(xpath = "//p[contains(text(),'Drivers must be at least 21 years')]")
	public static WebElement paragraph;
	
	@FindBy(xpath = "//span[@data-hook='prohibited-items-title']")
	public static WebElement whatcanwecarry;

	@FindBy(xpath = "//div[contains(text(),'Tail of Plane')]")
	public static WebElement scrolltocontinue;
	
	@FindBy(xpath = "//button[@data-hook='pet-in-cabin-card_add-to-cart']")
	public static WebElement petincabinaddtocard;

	@FindBy(xpath = "(//span[@data-hook='extras-popup-flight-leg_checkbox-label'])[1]")
	public static WebElement petincabincheckbox;
	
	@FindBy(xpath = "//button[@data-hook='pet-in-cabin-modal_add-to-cart']")
	public static WebElement finalAddtocard;
	
		public void bag() throws Exception {
		
		System.out.println("----Bag Page----");
		Common.performClick(Checkedbag, "Selecting bag");
		//Common.title("Bags and Extras");
		Common.performClick(petincabinaddtocard, "Petcabin add to card button clicked");
		Common.performClick(petincabincheckbox, "Pet cabin selected");
		Common.performClick(finalAddtocard, "Petcabin final add to card button clicked");
		Common.assertion(continuee, "Continue button");
		Common.performClick(continuee, "clicking continue button");
		System.out.println("Bag page @Test terminated");
		System.out.println(" ");
	}
	
	
}
