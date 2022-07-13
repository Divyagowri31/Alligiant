package Runner;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestCases.MainPage;
import TestCases.PassengerData;
import Utils.Base;
import Utils.Browser;
import Utils.Exceldata;
import TestCases.BagPage;
import TestCases.BundlesPage;
import TestCases.CarPage;
import TestCases.FlightSelection;
import TestCases.HotelPage;
import TestCases.PaymentDetails;
import TestCases.SeatSelection;

public class Runner extends Base {

	@DataProvider(name = "data")
	public String[][] passenger() {
		String loc = "./test-data/Excelworkbook.xlsx";
		String shtname = "Passengerdata";
		String[][] exceldata = Exceldata.getExcelData(loc, shtname);
		return exceldata;
	}

	@DataProvider(name = "payments")
	public String[][] paymentdtl() {
		String loc = "./test-data/Excelworkbook.xlsx";
		String shtname = "Paymentdetails";
		String[][] exceldata = Exceldata.getExcelData(loc, shtname);
		return exceldata;
	}

	@BeforeTest
	public static void browserInvoke() {
		Browser.url(browser, url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	}

	@Test(priority=1)
	public static void firstPage() throws Exception {
		Thread.sleep(4000);
		new MainPage().alligentFirstPage();
	}

	@Test(priority=2)
	public static void flightPage() {
		new FlightSelection().flightSelection();
	}

	@Test(priority=3)
	public static void bundlesPage() throws Exception {
		Thread.sleep(4000);
		new BundlesPage().bundlesPage();
	}

	@Test(priority=4, dataProvider = "data")
	public static void travelerPage(String name2, String name1, String yearrr, String pname1, String pname2,
			String year2) throws Exception {
		new PassengerData().traveler(name1, name2, yearrr, pname1, pname2, year2);
	}

	@Test(priority=5)
	public static void seatSelection() throws InterruptedException {
		Thread.sleep(4000);
		new SeatSelection().seatSelection();
	}

	@Test(priority=6)
	public static void bagPage() throws Exception {
		new BagPage().bag();
	}
	
	@Test(priority=7)
	public static void hotelPage() throws Exception {
		new HotelPage().hotelPage();
	}
	
	@Test(priority=8)
	public static void carPage() throws Exception {
		new CarPage().car();
	}
	
    @Test(priority=9, dataProvider = "payments")
	public static void payment(String cardno, String cvv, String pasAddress, String City, String Zipcode,
			String Phonenumber, String emailaddress) throws Exception {
		new PaymentDetails().cardDetails(cardno, cvv, pasAddress, City, Zipcode, Phonenumber, emailaddress);
	}

	@AfterTest
	public static void quit() {
		driver.quit();
	}
}
