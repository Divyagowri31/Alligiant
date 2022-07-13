package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class PassengerData extends Base {

	public PassengerData() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(xpath = "//input[@name='adults.0.first-name']")
	public static WebElement FirstName;

	@FindBy(xpath = "//input[@name='adults.1.first-name']")
	public static WebElement PassengerfirstName;

	@FindBy(xpath = "//input[@name='adults.0.last-name']")
	public static WebElement LastName;

	@FindBy(xpath = "//input[@name='adults.1.last-name']")
	public static WebElement PassengerlastName;

	@FindBy(xpath = "(//span[@data-hook='undefined_label'])[2]")
	public static WebElement Gender;

	@FindBy(xpath = "(//span[text()='Female'])[2]")
	public static WebElement SecondGender;

	@FindBy(xpath = "//div[text()='Month']")
	public static WebElement Month;

	@FindBy(xpath = "((//div[@data-hook='travelers-form_adults_1_dob-month'])//div[2])[2]")
	public static WebElement secondpassengerbirthMonth;

	@FindBy(xpath = "//div[text()='October']")
	public static WebElement October;

	@FindBy(xpath = "(//div[@data-hook='travelers-form_adults_0_dob-day']//div)[7]")
	public static WebElement Day;

	@FindBy(xpath = "(//div[@data-hook='travelers-form_adults_1_dob-day']//div)[7]")
	public static WebElement secondPassengerbirthday;

	@FindBy(xpath = "//div[text()='31']")
	public static WebElement day31;

	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_0_dob-year']")
	public static WebElement Year;

	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_1_dob-year']")
	public static WebElement SecondpassengerYear;

	@FindBy(xpath = "//button[@data-hook='travelers-page_continue']")
	public static WebElement Continue;

	@FindBy(xpath = "//input[@name='adults.0.middle-name']")
	public static WebElement Middlename;

	@FindBy(xpath = "//span[@data-hook='travelers-page_page-heading']")
	public static WebElement Travellerspage;

	public void traveler(String name2, String name1, String yearrr, String pname1, String pname2, String year2)
			throws Exception {
		String birthMonth = dataformonth;
		String birthMonth1 = dataformonth1;
		String birthdate = date;
		String birthdate1 = date1;
		System.out.println("----Travellers pages----");
		System.out.println("****First passenger details****");
		Common.sendKeys(FirstName, name1, "First name");
		Common.sendKeys(LastName, name2, "Last name");
		Common.performClick(Gender, "Gender field clicked");
		Common.selected(Gender, "Gender");
		Common.performClick(Month, "Month field clicked");
		Common.containsText(birthMonth, "C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.performClick(Day, "Day field is clicked");
		Common.containsText(birthdate, "C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Thread.sleep(2000);
		Common.sendKeys(Year, yearrr, "Year of birth");

		//Common.title("Travelers");

		System.out.println("****Second passenger details****");
		Common.performClick(PassengerfirstName, "Second passenger first name field clicked");
		Common.sendKeys(PassengerfirstName, pname1, "First name");
		Common.performClick(PassengerlastName, "Second passenger last name field clicked");
		Common.sendKeys(PassengerlastName, pname2, "Last name");
		Common.performClick(SecondGender, "Gender field clicked");
		Common.selected(SecondGender, "Gender");
		Common.performClick(secondpassengerbirthMonth, "Month field clicked");
		Common.containsText(birthMonth1, "C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.performClick(secondPassengerbirthday, "Day field is clicked");
		Common.containsText(birthdate1, "C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.sendKeys(SecondpassengerYear, year2, "Year of birth");
		Common.assertion(Continue, "Continue button");
		Common.performClick(Continue, "Passenger details given completed");
		System.out.println("Travelers page @Test terminated");
		System.out.println(" ");
	}
}
