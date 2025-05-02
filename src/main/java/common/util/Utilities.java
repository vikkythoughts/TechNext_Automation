package common.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;  
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ascentone.qa.base.TestBase;

public class Utilities extends TestBase {

	private static final Logger log = Logger.getLogger(TestBase.class.getName());

	// This function is used to get the user project directory
	public static String dir() {
		String workingDir = System.getProperty("user.dir");
		return workingDir;
	}

	// This function is used set the date format
	public static String dateFormat() {
		String dName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		return dName;
	}

	// This function is used to delete the folder
	public static void deleteFolder(String value) throws InterruptedException {
		delete(new File(dir() + "/" + value));
	}

	// This function is used to delete the file
	public static void delete(File file) {
		if (file.isDirectory()) {
			for (File deleteMe : file.listFiles()) {
				delete(deleteMe);
			}
		}
		file.delete();
	}

	// This function is used to is select check box
	public static void isSelectedCheckBox(WebElement checkBox) {
		if (checkBox.isSelected()) {
			log.info(checkBox.getDomAttribute("value") + " checkbox already selected.");
		} else {
			checkBox.click();
			log.info(checkBox.getDomAttribute("value") + " checkbox selected.");
		}
	}

	// This function is used to take screenshot
	public static String getScreenShot(String method) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = dir() + ReadUtils.getData("Path", 5, 2) + method + "_" + dateFormat() + ".png";
		File destFile = new File(destination);
		FileUtils.copyFile(srcFile, destFile);
		logger("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
				+ "' height='400' width='700'/> </a>");
		return destination;
	}

	// This function is used to file upload by send keys
	public static void fileUpload(WebElement element, String file) {
		element.sendKeys(file);
		log.info("File name :- " + file);
	}

	// This function is used to file download by robot class
	public void fileDownload() throws AWTException {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// This function is used to get the element css value
	public static String getCssValue(WebElement element, String cssVal) {
		String value = element.getCssValue(cssVal);
		log.info("Element Css value is :- " + value);
		return value;
	}

	// This function is used to get the color css value
	public static String getColor(WebElement element) {
		String value = element.getCssValue("color");
		log.info("Color of the element :- " + value);
		return value;
	}

	// This function is used to get the font size css value
	public static String getFontSize(WebElement element) {
		String value = element.getCssValue("font-size");
		log.info("Font size of the element :- " + value);
		return value;
	}

	// This function is used to get background color css value
	public static String getBackgroundColor(WebElement element) {
		String value = element.getCssValue("background-color");
		return value;
	}

	// This function is used to get background css value
	public static String getBackground(WebElement element) {
		String value = element.getCssValue("background");
		return value;
	}

	// This function is used to get border color css value
	public static String getBorderColor(WebElement element) {
		String value = element.getCssValue("border-top-color");
		return value;
	}

	// This function is used to get placeholder attribute value
	public static String getPlaceHolder(WebElement element) {
		String value = element.getDomAttribute("placeholder");
		return value;
	}

	// This function is used to get enter attribute value
	public static String getEnteredData(WebElement element) {
		String strValue = element.getDomAttribute("value");
		return strValue;
	}

	// This function is used to get the text field attribute value
	public static String getAttribute(WebElement element, String attribute) {
		String value = element.getDomAttribute(attribute);
		return value;
	}

	// This function is used to get the text value
	public static String getText(WebElement element) {
		waitForVisibilityOf(element);
		String strValue = element.getText();
		return strValue;
	}

	// This function is used to get current URL
	public static String getCurrentURL() {
		String getUrl = driver.getCurrentUrl();
		log.info("Current URL :-- " + getUrl);
		return getUrl;
	}

	// This function is used to get current URL
	public static String getCurrentTitle(String expTitle) {
		waitForTitle(expTitle);
		String actTitle = driver.getTitle();
		log.info("Expected title :- " + expTitle + " and Actual title :- " + actTitle);
		return actTitle;
	}

	// This function is used to get tool tip text value
	public static void getTooltip(WebElement element) {
		waitForVisibilityOf(element);
		String toolTipText = element.getDomAttribute("title");
		log.info("Tooltip value is:- " + toolTipText);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	// This function is used clear and enter the text in the input fields
	public static void type(WebElement element, String strValue) {
		waitForVisibilityOf(element);
		element.clear();
		element.sendKeys(strValue);
	}

	// This function is used to wait for title name
	public static void waitForTitle(String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleIs(text));
	}

	// This function is used to wait till to visibility of the element
	public static void waitForVisibilityOf(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// This function is used to get the info message
	public static String getInfoMessage(WebElement element) {
		String msg = getText(element);
		log.info("Displayed Info Message:- " + msg);
		return msg;
	}

	// This function is used to get the info message
	public static void getInfoMessage(WebElement infoMsg, String expectedResult) {
		String msg = getText(infoMsg);
		if (infoMsg.isDisplayed()) {
			if (infoMsg.getText().contains(expectedResult)) {
				log.info("Actual Message: " + msg + " and Expected info message contains: " + expectedResult);
				Assert.assertTrue(true);
			} else {
				log.error("Actual Message: " + msg + " and it doesn't contains: " + expectedResult);
			}
		} else {
			log.error("Info message is not displayed.");
		}
		Utilities.waitForInvisibilityOf(infoMsg);
	}

	// This function is used to verify the actual title with expected title
	public static void assertTitleName(String expectedResult) {
		waitForTitle(expectedResult);
		Assert.assertEquals(getCurrentTitle(expectedResult), expectedResult);
	}

	// This function is used to verify the actual url with expected url
	public static void assertCurrentURL(String expectedResult) {
		Assert.assertEquals(getCurrentURL(), expectedResult);
	}

	// This function is used to navigate to url
	public static void navigateToURL(String url) throws InterruptedException {
		driver.navigate().to(url);
		log.info("Navigate to URL: " + url);
	}

	// This function is used to navigate to back page
	public static void navigateToBackPage() throws InterruptedException {
		driver.navigate().back();
		log.info("Navigate to back page.");
	}

	// This function is used to navigate to forward page
	public static void navigateToForwardPage() throws InterruptedException {
		driver.navigate().forward();
		log.info("Navigate to forword page.");
	}

	// This function is used to refresh the current page
	public static void pageRefresh() throws InterruptedException {
		driver.navigate().refresh();
		log.info("Page refreshed.");
	}

	// This function is used to get both status displayed and enabled
	public static boolean getDisplayedAndEnabledStatus(WebElement element) {
		boolean elePresense = element.isEnabled();
		boolean elePresense1 = element.isDisplayed();
		return elePresense == elePresense1;
	}

	// This function is used to wait for page to get fully loaded
	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	// This function is used to get displayed status for element
	public static boolean getDisplayedStatus(WebElement element) {
		boolean elePresense = element.isDisplayed();
		return elePresense;
	}

	// This function is used to get enabled status for element
	public static boolean getEnabledStatus(WebElement element) {
		boolean elePresense = element.isEnabled();
		return elePresense;
	}

	// This function is used to get Selected status for element
	public static boolean getSelectedStatus(WebElement element) {
		boolean elePresense = element.isSelected();
		return elePresense;
	}

	// This function is used to verify link is broken or not
	public static String getURLStatus(String url) throws IOException {
		String result = "";
		URL siteURL = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		if (code == 200) {
			result = "Link is not broken";

		} else {
			result = "Link is broken";
		}
		return result;
	}

	// This function is used to scroll down on web page
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 2500)");

	}

	// This function is used to scroll down on web page
	public static void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(2500, 0)");

	}

	// This function is used to get the drop down list value by loop
	public static void getDropDownOptionsByLoop(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		log.info("Number of Options:-" + options.size());

		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
	}

	// This function is used to get the drop down first selected value
	public static String getFirstSelectedOption(WebElement element) {
		waitForVisibilityOf(element);
		Select dropDown = new Select(element);
		WebElement option = dropDown.getFirstSelectedOption();
		String strValue = option.getText();
		return strValue;
	}

	// This function is used to get the drop down list of all selected values
	public static String getAllSelectedOptions(WebElement element) {
		StringBuilder str = new StringBuilder();
		waitForVisibilityOf(element);
		Select dropDown = new Select(element);
		List<WebElement> options = dropDown.getAllSelectedOptions();
		for (WebElement option : options) {
			String text = option.getText();
			str.append(text);
		}
		String finalstr = str.toString();
		return finalstr;
	}

	// This function is used to select the drop down by selectByVisible method
	public static String selectByVisible(WebElement element, String strValue) {
		waitForVisibilityOf(element);
		Select sel = new Select(element);
		sel.selectByVisibleText(strValue);
		return strValue;
	}

	// This function is used to select the drop down by selectByValue method
	public static String selectByValue(WebElement element, String strValue) {
		waitForVisibilityOf(element);
		Select sel = new Select(element);
		sel.selectByValue(strValue);
		return strValue;
	}

	// This function is used to select the drop down by selectByIndex
	public static int selectByIndex(WebElement element, int value) {
		waitForVisibilityOf(element);
		Select sel = new Select(element);
		sel.selectByIndex(value);
		return value;
	}

	// This function is used to double click on WebElement
	public static void doubleClick(WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).build().perform();
	}

	// This function is used to drag the src location to target location
	public static void dragAndDrop(WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	// This function is used to mouse hover into element1
	public static void mouseHoverToElement(WebElement element) {
		waitForVisibilityOf(element);
		waitForElementToBeClickable(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	// This function is used to mouse hover into element1 and then element2
	public static void mouseHoverToElement(WebElement element, WebElement element1) {
		waitForVisibilityOf(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element1).build().perform();

	}

	// This function is used to mouse hover into element1, element2 and element3
	public static void mouseHoverToElement(WebElement element, WebElement element1, WebElement element2) {
		waitForVisibilityOf(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element1).build().perform();
	}

	// This function is used to mouse hover into element1, element2 and element3
	// then
	// click
	public static void mouseHoverAndClick(WebElement element, WebElement element1, WebElement element2) {
		waitForVisibilityOf(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element1).click(element2).build().perform();
	}

	// This function is used to wait till to visibility of the element
	public static void waitForAttributeValue(WebElement element, String attribute, String value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	}

	// This function is used to wait till to visibility of the element located
	public static void waitForVisibilityOfElementLocated(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	// This function is used to wait till to invisibility of the element
	public static void waitForInvisibilityOf(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// This function is used to wait for element to be click-able
	public static void waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// This function is used to wait for element to be click-able and then click
	public static void waitForElementToBeClickableAndClick(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	// This function is used to wait for element to be click-able and then click
	public static void waitForElementToBeEnabled(WebElement element) {
		try {
			while (!(element.isEnabled())) {
				waitForElementToBeEnabled(element);
			}
		} catch (Exception e) {
		}
	}

	// This function is used to wait for title name
	public static void waitForTitleContains(String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleContains(text));
	}

	// This function is used to wait for alert pop up
	public static void waitForAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// This function is used to scroll the page to view specific element
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	// This function is used to click on element by javaScript
	public static void javascriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

}
