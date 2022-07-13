package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class FlightSelection extends Base{

	public FlightSelection() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	@FindBy(xpath = "//button[@data-hook='flights-page_continue']")
	public static WebElement Flightselection;
	@FindBy(xpath = "(//span[contains(text(),'Harry Reid International Airport (LAS)')])[1]")
	public static WebElement Depflightfrom;	
	@FindBy(xpath = "(//span[contains(text(),'Harry Reid International Airport (LAS)')])[2]")
	public static WebElement returnflightto;
	@FindBy(xpath = "(//span[contains(text(),'Bellingham International Airport (BLI)')])[2]")
	public static WebElement Depflightto;
	@FindBy(xpath = "(//span[contains(text(),'Bellingham International Airport (BLI)')])[1]")
	public static WebElement returnflightfrom;
	@FindBy(xpath = "//button[@data-hook='flights-page_continue']//span")
	public static WebElement Continuebutton;
	@FindBy(xpath="(//span[@data-hook='flight-price'])[1]")
	public static WebElement Depflight1;
	@FindBy(xpath="(//span[@data-hook='flight-price'])[2]")
	public static WebElement Depflight2;
	@FindBy(xpath="(//span[@data-hook='flight-price'])[3]")
	public static WebElement Returnflight1;
	@FindBy(xpath="(//span[@data-hook='flight-price'])[4]")
	public static WebElement Returnflight2;
	@FindBy(xpath="//span[contains(text(),'Select Flights')]")
	public static WebElement flightselectpagetext;
	@FindBy(xpath="(//span[@data-hook='flight-number'])[1]")
	public static WebElement flighnumber1;
	@FindBy(xpath="(//span[@data-hook='flight-number'])[2]")
	public static WebElement flighnumber2;
	@FindBy(xpath="(//span[@data-hook='flight-number'])[3]")
	public static WebElement flighnumber3;
	@FindBy(xpath="(//span[@data-hook='flight-number'])[4]")
	public static WebElement flighnumber4;
	
	public void flightSelection() {
		System.out.println("----Flight selection Page----");
		Common.flightSelection(Depflight1,"Departure flight cost :",Depflight2,"Departure flight number :",flighnumber1,flighnumber2);
		Common.flightSelection(Returnflight1,"Return flight cost :",Returnflight2,"Return flight number :",flighnumber3,flighnumber4);
		//Common.title("Flights");
		Common.displayed(Depflightfrom, "Departing Flight from - Harry Reid International Airport (LAS) :");
		Common.displayed(Depflightto, "Departing Flight to - Bellingham International Airport (BLI) :");
		Common.displayed(returnflightfrom, "Returning Flight from - Bellingham International Airport (BLI) :");
		Common.displayed(returnflightto, "Returning Flight to - Harry Reid International Airport (LAS) :");
		Common.assertion(Continuebutton, "Continue button");
		Common.performClick(Continuebutton, "Flight selection completed ");
		System.out.println("Flight page @Test terminated");
		System.out.println(" ");
	}
}
