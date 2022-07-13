package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonMethods.Common;
import Utils.Base;

public class PaymentDetails extends Base {

	public PaymentDetails() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
}
    @FindBy(xpath = "//input[@data-hook='payment-page_card-number']")
	public static WebElement Cardnumber;
    @FindBy(xpath = "//div[text()='Month']")
	public static WebElement Month;
    @FindBy(xpath = "//div[text()='Year']")
	public static WebElement Year;
    @FindBy(xpath = "//div[text()='2024']")
	public static WebElement Yearofexpiry;
    @FindBy(xpath = "//input[@data-hook='payment-page_card-cvv']")
	public static WebElement CVVfieldbox;
    @FindBy(xpath = "//input[@data-hook='payment-page_address-line-1']")
	public static WebElement Address;
    @FindBy(xpath = "//input[@data-hook='payment-page_city']")
	public static WebElement City;
    @FindBy(xpath = "(//div[text()='State'])[1]")
	public static WebElement State;
    @FindBy(xpath = "//input[@data-hook='payment-page_zip-code']")
	public static WebElement Zipcode;
    @FindBy(xpath = "//input[@data-hook='payment-page_phone-number']")
	public static WebElement Phonenumber;
    @FindBy(xpath = "//input[@data-hook='payment-page_email-address']")
	public static WebElement Email;
    @FindBy(xpath = "//input[@data-hook='payment-page_password']")
	public static WebElement NewPassword;
    @FindBy(xpath = "//input[@data-hook='payment-page_password-confirmation']")
	public static WebElement Passwordconfirmation;
	@FindBy(xpath = "//span[@data-hook='payment_terms-and-conditions-checkbox_label']")
	public static WebElement Checkbox;
	@FindBy(xpath = "//button[@data-hook='payment-page_ice-popup_close']//img")
	public static WebElement popup;
	
public void cardDetails(String cardno,String cvv,String pasAddress,String Cities,String Zipcodes,String Phonenumbers,String emailaddress) throws Exception {
		String months=monthselect;
		String years=yearselect;
		String states=stateselection;
		
		System.out.println("----Payment Page----");
		Common.performClick(popup, "Payment page popup is closed");
		//Common.title("Payment");
        Common.send(Cardnumber, cardno);
	    Common.displayed(Cardnumber,"cardnumber");
		Common.performClick(Month, "Month field box is selected ");
		Common.containsText(months,"C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.performClick(Year, "Year field box is selected ");
		Common.containsText(years,"C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.performClick(Yearofexpiry, "Year of expiry given");
		Common.performClick(CVVfieldbox, "Cvv field box clicked ");
		Common.send(CVVfieldbox, cvv);
		Common.displayed(CVVfieldbox,"Cvv field box");
		Common.sendKeys(Address,pasAddress,"Address given");
		Common.performClick(City, "city selected ");
		Common.sendKeys(City, Cities,"City given");
		Common.performClick(State, "State drop box is clicked ");
		Common.containsText(states,"C:\\Users\\gelumalai\\Desktop\\Screenshot\\New folder");
		Common.performClick(Zipcode, "Zipcode field clicked ");
		Common.sendKeys(Zipcode,Zipcodes, "Pincode given");
		Common.performClick(Phonenumber, "phonenumber field selected");
		Common.sendKeys(Phonenumber,Phonenumbers,"Phone number given");
		Common.performClick(Email, "Email field is clicked");
		Common.sendKeys(Email,emailaddress,"Email address given");
		Common.assertion(Checkbox, "Continue button");
		Common.performClick(Checkbox, "Checkbox is selected ");
		System.out.println("Payment page @Test terminated");
				System.out.println(" ");
			}
}
