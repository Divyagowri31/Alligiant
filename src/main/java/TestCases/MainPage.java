package TestCases;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import CommonMethods.Common;
import Utils.Base;

public class MainPage extends Base {

	public MainPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(xpath = "//img[@alt=\"closeIcon\"]")
	public static WebElement Popup;
	@FindBy(xpath = "//div[@data-hook='flight-search-origin']")
	public static WebElement Departure;
	@FindBy(xpath = "//div[@id='onetrust-close-btn-container']//button")
	public static WebElement Cookiepopup;
	@FindBy(xpath = "//div[@data-hook='flight-search-destination']")
	public static WebElement Destination;
	@FindBy(xpath = "//button[@data-hook='flight-search-date-picker_expand-start-date']")
	public static WebElement startDate;
	@FindBy(xpath = "//button[@data-hook='flight-search-submit']")
	public static WebElement Searchbutton;
	@FindBy(xpath = "//button[@data-hook='flight-search-date-picker_expand-end-date']")
	public static WebElement EndDate;
	@FindBy(xpath = "//button[@data-hook='flights-page_continue']")
	public static WebElement Flightselection;
	@FindBy(xpath = "//a[@data-hook='header-top-bar-menu-item_check-in']")
	public static WebElement login;
	@FindBy(xpath = "//span[@data-hook='flight-search-date-picker_calendar-0_display-month-year']")
	public static WebElement monthYear;
	@FindBy(xpath = "(//div[@class='Calendar__Grid-epvxa4-0 Calendar__DateGrid-epvxa4-3 gNEFIj'])[1]")
	public static WebElement month;
	@FindBy(xpath = "//span[@data-hook='flight-search-date-picker_calendar-1_display-month-year']")
	public static WebElement monthYear1;
	@FindBy(xpath = "//button[@data-hook='flight-search-date-picker_navigate-next-month']")
	public static WebElement next;
	@FindBy(xpath = "//button[@data-hook='flight-search-date-picker_expand-end-date']")
	public static WebElement rtndate;
	@FindBy(xpath = "//button[@data-hook='flight-search-travelers-expando-button']//div[@class='TravelersField__ArrowIconContainer-sc-13wj9y9-7 hNSGKx']")
	public static WebElement passenger;
	@FindBy(xpath = "//button[@data-hook='flight-search-adults_increment']")
	public static WebElement passengerincrement;
	@FindBy(xpath = "//button[@data-hook='flight-search-adults_increment']")
	public static WebElement incrementbutton;
	
	public void alligentFirstPage() throws Exception {
		String x=Dep;
		String y=Des;
		System.out.println("----Main Page----");
		Common.performClick(Popup, "Bonus point offer popup closed ");
		Common.performClick(Cookiepopup, "Accept all cookie popup closed");
		//Common.title("Allegiant® | Cheap Flights, Airline Tickets, Vacation & Hotel Deals");
		Common.currentURL("URL");
		Common.performClick(Departure, "Departure field clicked");
		Common.containsText(x,"C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.getText(Departure , "Departure city");
		Common.performClick(Destination, "Destination field clicked");
		Common.containsText(y,"C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.getText(Destination, "Destination city");
		Common.click(startDate, "Calender field is clicked ");
		Common.datePicker(next, monthYear, "30", "June", "2022","Trip start date", 0);
		Common.click(rtndate, "Return calender field is clicked");
		Common.click(rtndate, "Return month selected");
		Common.datePick(next, monthYear1, "3", "July", "2022","Return date", 1);
		Common.performClick(passenger, "Passenger field clicked");
		Common.performClick(passengerincrement, "Clicking + symbol to add the passenger");
		Common.assertion(Searchbutton, "Search button");
		Common.performClick(Searchbutton, "Search button is clicked");
		System.out.println("Main page @Test terminated");
		System.out.println(" ");
	}
}
