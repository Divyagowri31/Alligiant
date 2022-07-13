package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class SeatSelection extends Base {
	
	public SeatSelection() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath="(//div[@class='Block-ml0umf-1 gvuLyD'])[4]//h2[text()='Economy']")
	public static WebElement Economy;
	
	@FindBy(xpath="//li[@class='Section__SeatWrapper-noco0i-3 jyeirM']//span[@data-hook='select-economy-seat_unrestricted_4B']//span")
	public static WebElement seat1;
	
	@FindBy(xpath = "//span[@data-hook='select-economy-seat_unrestricted_16B']//span")
	public static WebElement departureseatselect;

	@FindBy(xpath = "//span[contains(text(),'Select Returning')]")
	public static WebElement Returnseatselectionbutton;

	@FindBy(xpath = "//span[@data-hook='select-economy-seat_unrestricted_10B']")
	public static WebElement Returnseat;

	@FindBy(xpath = "//button[@class='Button__StyledButton-sc-1ececxa-1 bUstXr']//span")
	public static WebElement Continue;
	
	@FindBy(xpath="//div[contains(text(),'Select Seats For Me!')]")
	public static WebElement Selectseatforme;
	public void seatSelection() throws InterruptedException {
		String Deppassenger1=Departureseat;
		String Deppassenger2=Departureseat2;
		String Returnpassenger1=returnseat;
		String Returnpassenger2=returnseat2;
		System.out.println("----Flight seat selection Page----");
	    Thread.sleep(6000);
	    Common.seat(Deppassenger1,"First passenger departure seat selected");
		Common.seat(Deppassenger2,"Second passenger departure seat selected");
		Thread.sleep(2000);
		Common.performClick(Returnseatselectionbutton, "Return seat selection button clicked");
		Thread.sleep(4000);
		Common.seat(Returnpassenger1,"First passenger return seat selected");
		Common.seat(Returnpassenger2,"Second passenger return seat selected");
		//Common.title("Seats");
		Common.assertion(Continue, "Continue button");
		Common.performClick(Continue, "Seat selection completed");
		System.out.println("Seat selection @Test terminated");
		System.out.println(" ");
		}
	

}
