package CommonMethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.Base;

public class Common extends Base {

	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public static void performClick(WebElement element, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(element));
		popup.click();
		System.out.println(Value);
	}

	public static void sendKeys(WebElement element, String value, String value1) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(element));
		popup.sendKeys(value);
		System.out.println(value1 + " : " + value);
	}

	public static void enabledMethod(WebElement element, String string) {

		boolean enb = element.isEnabled();
		if (enb = true) {
			System.out.println(string + " " + " enabled" + " " + enb);
		} else {
			System.out.println(enb + ":Value not enabled");
		}
	}

	public static void title(String value) {

		String title1 = driver.getTitle();
		System.out.println("Current page title :" + title1);
		Assert.assertTrue(title1.contains(value));
	}

	public static void click(WebElement webelement, String string) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement clicking = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		clicking.click();
		/*
		 * try { JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		 * javaScriptExecutor.executeScript("arguments[0].click()", webelement); }
		 * catch(Exception exe) {
		 * 
		 * takeSnapShot(path); }
		 */
	}

	public static void currentURL(String string) {
		System.out.println("Current page URL :" + driver.getCurrentUrl());
	}

	public static void send(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(element));
		popup.sendKeys(value);
	}

	public static void selected(WebElement element, String string)

	{
		boolean val = element.isSelected();
		if (val == true)
			System.out.println(string + " " + "selected" + " " + val);
		else {
			System.out.println(val + ":Element is not selected");
		}
	}

	public static void displayed(WebElement element, String string) {
		boolean dis = element.isDisplayed();
		if (dis == true)
			System.out.println(string + " " + "displayed" + " " + dis);
		else {
			System.out.println(dis + ":Element is not displayed");
		}
	}

	public static String[] getMonthVal(String monthyear) {
		return monthyear.split(" ");
	}

	public static void datePicker(WebElement val, WebElement monyear, String expdate, String expMonth, String expYear,
			String value, int a) {

		String date = monyear.getText();
		System.out.println(date);
		while (!(getMonthVal(date)[0].equals(expMonth)) && (getMonthVal(date)[1].equals(expYear))) {
			val.click();
			date = monyear.getText();
		}

		WebElement Date = driver.findElement(By.xpath(
				"(//button[@data-hook='flight-search-date-picker_calendar-" + a + "_select-day-" + expdate + "'])[2]"));

		System.out.println("Flight available on the given date:" + Date.isEnabled());

		if (Date.isEnabled()) {
			Date.click();
			System.out.println(value + " : " + expdate + " " + expMonth + " " + expYear);
		}

		else {

			throw new ElementNotSelectableException("Selected date is disabled try select another date");
		}
	}
	
	public static void datePick(WebElement val, WebElement monyear, String expdate, String expMonth, String expYear,
			String value, int a) {

		String date = monyear.getText();
		System.out.println(date);
		while (!(getMonthVal(date)[0].equals(expMonth)) && (getMonthVal(date)[1].equals(expYear))) {
			val.click();
			date = monyear.getText();
		}

		WebElement Date = driver.findElement(By.xpath(
				"//button[@data-hook='flight-search-date-picker_calendar-" + a + "_select-day-" + expdate + "']"));

		System.out.println("Flight available on the given date:" + Date.isEnabled());

		if (Date.isEnabled()) {
			Date.click();
			System.out.println(value + " : " + expdate + " " + expMonth + " " + expYear);
		}

		else {

			throw new ElementNotSelectableException("Selected date is disabled try select another date");
		}
	}
	public static void scroll(WebElement element) {
		JavascriptExecutor val = (JavascriptExecutor) driver;
		val.executeScript("arguments[0].scrollIntoView(true)", element);
	
}

	public static void containsText(String string, String path) throws Exception {
		try {
			WebElement days = driver.findElement(By.xpath("//div[contains(text(),'" + string + "')]"));
			days.click();

		} catch (Exception exp) {
			System.out.println("Incorrect parameter passed");
			takeSnapShot(path);
		}
	}

	public static void getText(WebElement element, String value) {

		System.out.println(value + " : " + element.getText());
	}

	public static void takeSnapShot(String fileWithPath) throws Exception {
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File(fileWithPath + System.currentTimeMillis() + ".png"));
		System.out.println("Screenshot taken-stored in the given path");
	}
	public static void flightSelection(WebElement element1, String string, WebElement element2, String string1,
			WebElement element3, WebElement element4) {

		if (element1.isEnabled()) {
			element1.click();
			System.out.println(string1 + element3.getText());
			System.out.println(string + element1.getText());

		} else {
			element2.click();
			System.out.println(string1 + element4.getText());
			System.out.println(string + element2.getText());

		}
	}

	public static void seat(String string, String string1) {
		WebElement returnSeat = driver.findElement(By.xpath(
	"//div[@class='SeatMap__Plane-sc-1vfc0qg-0 kmUvjz']//span[@data-hook='select-economy-seat_unrestricted_"+string+"']//span"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(returnSeat));
		popup.click();

	}

	public static void assertion(WebElement element,String string) {
		if(element.isEnabled()) {
			boolean result=element.isEnabled();
			System.out.println(string+ " " + "enabled"+" " +result);
		}
		else {
			Assert.assertFalse(element.isEnabled());
		}
	}
}
