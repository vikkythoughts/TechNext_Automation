package com.ascentone.qa.pages.register_student;

import java.util.ArrayList;
import org.apache.log4j.Logger;  

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ascentone.qa.base.TestBase;

import common.util.ReadUtils;
import common.util.Utilities;

public class StudentRegistration extends TestBase {
	
	private static final Logger log = Logger.getLogger(StudentRegistration.class);
	
	
	@FindBy(xpath = "//button[@onclick = 'CreateNewStudent(this);']")
	static private WebElement rigisterButton;

	@FindBy(id = "select2-ddlTitle-container")
	static private WebElement title;

	@FindBy(id = "txtFirstName")
	static private WebElement givenName;

	@FindBy(id = "txtMiddleName")
	static private WebElement middleName;

	@FindBy(id = "select2-ddlGender-container")
	static private WebElement gender;

	@FindBy(id = "dtDob")
	static private WebElement dateOfBirth;

	@FindBy(id = "select2-ddlMaritalStatus-container")
	static private WebElement maritalStatus;

	@FindBy(id = "select2-ddlCitizen-container")
	static private WebElement countryOfCitizenship;

	@FindBy(id = "select2-ddlResident-container")
	static private WebElement countryOfCurrentresidency;

	@FindBy(id = "txtEmail")
	static private WebElement emailAddress;

	@FindBy(id = "select2-ddlMobileCountry-container")
	static private WebElement mobileCountry;

	@FindBy(id = "txtMobile")
	static private WebElement mobile;

	@FindBy(id = "select2-ddlSecretQuestion-container")
	static private WebElement secretQuestion;

	@FindBy(id = "txtSecretAnswer")
	static private WebElement secretAnswer;

	@FindBy(id = "txtPassword")
	static private WebElement password;

	@FindBy(id = "txtConfirmPassword")
	static private WebElement confirmPassword;

	@FindBy(id = "btnRegister")
	static private WebElement doneButton;

	@FindBy(id = "txtLoginPassword")
	static private WebElement enterPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	static private WebElement loginBtn;
	
	
    // Constructor to initialize WebElement
	public StudentRegistration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnRegistorButton() {
		Utilities.waitForElementToBeClickableAndClick(rigisterButton);
		log.info("Cliked on register button from login page");
	}

	public void selectTitle(String titleStr) {
		Utilities.waitForElementToBeClickableAndClick(title);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ titleStr + "')]")).click();
		log.info("Title selected");
	}

	public void enterName(String name) {
		Utilities.type(givenName, name);
		log.info("Entered student name");
	}

	public void enterMiddleName(String midName) {
		Utilities.type(middleName, midName);
		log.info("Entered student middle name");
	}

	public void selectGender(String genderStr) {
		Utilities.waitForElementToBeClickableAndClick(gender);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ genderStr + "')]")).click();
		log.info("Gender selected");
	}

	public void enterDateOfBirth(String dob) {
		Utilities.type(dateOfBirth, dob);
		log.info("Entered student date of birth");
	}

	public void selectMaritalStatus(String maritalSts) {
		Utilities.waitForElementToBeClickableAndClick(maritalStatus);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ maritalSts + "')]")).click();
		log.info("Marital status selected");
	}

	public void selectCountryOfCitizenship(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(countryOfCitizenship);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("Country Of Citizenship selected");
	}

	public void selectCountryOfCurrentResidence(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(countryOfCurrentresidency);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("Country Of Current Residence selected");
	}

	public void enterEmailAddress(String email) {
		Utilities.type(emailAddress, email);
		log.info("Entered student email address");
	}

	public void selectMobileCountry(String mobCountry) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(mobileCountry);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(mobCountry);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ mobCountry + "')]")).click();
		log.info("Mobile country selected");
	}

	public void enterMobileNumber(String mobNo) {
		Utilities.type(mobile, mobNo);
		log.info("Entered student mobile number");
	}

	public void selectSecretQuestion(String scrQues) {
		Utilities.waitForElementToBeClickableAndClick(secretQuestion);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ scrQues + "')]")).click();
		log.info("Secret Question selected");
	}

	public void selectSecretAnswer(String scrAns) {
		Utilities.type(secretAnswer, scrAns);
		log.info("Secret Answer entered");
	}

	public void enterPassword(String pwd) {
		Utilities.type(password, pwd);
		log.info("Entered Password");
	}

	public void enterConfirmPassword(String confPwd) {
		Utilities.type(confirmPassword, confPwd);
		log.info("Entered Confirm Password");
	}

	public void clickOnSubmitButton() {
		Utilities.waitForElementToBeClickableAndClick(doneButton);
		log.info("Cliked on done button after entered student details");
	}
	
	public void getVerificationCodeAndVerify(String yopUrl, String mail) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(yopUrl);
		WebElement yopmail= driver.findElement(By.xpath("//input[@id='login']"));
		Thread.sleep(2000);
		Utilities.type(yopmail, mail);
		driver.findElement(By.xpath("//button[@class='md']/i")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ifmail']")));
		Thread.sleep(2000);
		WebElement code = driver.findElement(By.xpath("//p[contains(text(),'Your verification code is:')]/strong"));
		String verificationCode = Utilities.getText(code);
		System.out.println("Verification Code fetch Successfully");
		
		driver.switchTo().defaultContent();
		
		  for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	           if(driver.getCurrentUrl().equals(ReadUtils.getData("URL", 1, 2))) {
	        	   break;
	           }
	        }
		  
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtCode']")).sendKeys(verificationCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Verify']")).click();
//		if(driver.findElement(By.xpath("//div[contains(text(),'verification code is invalid..!!')]")).isDisplayed()) {
//			log.info("Verification code is invalid..!!");
//		}else {
//		log.info("Registered student email is successfully verified");
//		}
	}

	public void enterPasswordForLogin(String loginPwd) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.type(enterPassword, loginPwd);
		log.info("Entered Password to login registered student");
	}
	
	public void clickOnLoginButton() {
		Utilities.waitForElementToBeClickableAndClick(loginBtn);
		log.info("Cliked on login button");
	}

	public  String verifyStudentName() {
		WebElement studentName = driver.findElement(By.xpath("//div[@class = 'info-lbl' and contains(text(),'Name')]/following-sibling::div"));
		String stuName = Utilities.getText(studentName);
		return stuName;
	}
	
	public void enterDataInRegistrationForm(ArrayList<String> list) throws InterruptedException {
		selectTitle(list.get(0));
		enterName(list.get(1));
		enterMiddleName(list.get(2));
		selectGender(list.get(4));
		enterDateOfBirth(list.get(5));
		selectMaritalStatus(list.get(6));
		selectCountryOfCitizenship(list.get(8));
		selectCountryOfCurrentResidence(list.get(9));
		enterEmailAddress(list.get(10));
		selectMobileCountry(list.get(11));
		enterMobileNumber(list.get(12));
		selectSecretQuestion(list.get(13));
		selectSecretAnswer(list.get(14));
		enterPassword(list.get(15));
		enterConfirmPassword(list.get(16));
		clickOnSubmitButton();
		
	}

}
