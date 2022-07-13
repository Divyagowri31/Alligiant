package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class BundlesPage extends Base {

	public BundlesPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = "(//span[@class='GAClickEventTracker-sc-18kj7ko-0 hMXoDf'])[8]//button[@data-hook='select-tier-2']")
	public static WebElement Alligiantbonusselect;
	
	@FindBy(xpath="//span[text()='Continue']")
	public static WebElement Continuebutton;
	
	public void bundlesPage() throws Exception {
		System.out.println("----Bundles page----");
		//Common.title("Bundles");
		Common.performClick(Alligiantbonusselect, "Bonus selected");
		Common.assertion(Continuebutton, "Continue button");
		Common.performClick(Continuebutton, "Continue button clicked");
		System.out.println("Bundles page @Test terminated");
		System.out.println(" ");
	}
}
