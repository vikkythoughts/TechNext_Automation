package com.ascentone.qa.pages.create_new_student;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ascentone.qa.base.TestBase;
import com.ascentone.qa.pages.home.HomePage;

import common.util.Utilities;

public class CreateNewStudent extends TestBase{
	
	// Locators of Add New Student
	
	@FindBy(xpath = "//button[@onclick = 'CreateNewStudent(this);']")
	static private WebElement newStudentBtn;

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
	
	@FindBy(xpath = "//button[@onclick='SaveStudent();']")
	static private WebElement doneButton;
	
	// Locators of Add Family Member
	
	@FindBy(xpath = "//button[normalize-space()='Add Family Member']")
	private WebElement addFmlyMemBtn;
	
	@FindBy(id = "select2-ddlTitle_fam-container")
	private WebElement titleFamilyMember;
	
	@FindBy(id = "txtfirst_name_fam")
	private WebElement fam_FirstName;
	
	@FindBy(id = "txtmiddle_name_fam")
	private WebElement fam_MiddleName;
	
	@FindBy(id="select2-ddlGender_fam-container")
	private WebElement fam_Gender;
	
	@FindBy(id ="txtdob_fam")
	private WebElement fam_Dob;
	
	@FindBy(id ="select2-ddlMaritalStatus_fam-container")
	private WebElement fam_Marital_Status;
	
	@FindBy(id ="txtmarriage_date_fam")
	private WebElement fam_Marriage_Date;
	
	@FindBy(id = "select2-ddlRelationship_fam-container")
	private WebElement fam_Relation;
	
	@FindBy(id = "select2-ddlCountry_fam-container")
	private WebElement fam_Nationality;
	
	@FindBy(xpath = "//button[@onclick='saveNewMemberDetails();']")
	private WebElement fam_Savebtn;
	
	// Locators of Add Address tab
	
	@FindBy(id = "addrss-tab")
	private WebElement addressTab;
	
	@FindBy(xpath = "//button[normalize-space()='Add Address']")
	private WebElement addAddressBtn;
	
	@FindBy(id = "select2-ddl_per_cntry-container")
	private WebElement country;
	
	@FindBy(id = "select2-ddl_per_state-container")
	private WebElement state;
	
	@FindBy(id = "txt_per_city")
	private WebElement city;
	
	@FindBy(id = "txt_per_add1")
	private WebElement addressLine1;
	
	@FindBy(id = "txt_per_postcode")
	private WebElement postcode;
	
	@FindBy(xpath = "//input[starts-with(@id,'add')]")
	private WebElement chckBox;
	
	@FindBy(id = "btn_saveAddrss")
	private WebElement saveAddressBtn;
	
	// Locators of Passport tab
	
	@FindBy(id = "passport-tab")
	private WebElement passportTab;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][normalize-space()='Add Passport']")
	private WebElement addPassportBtn;
	
	@FindBy(id = "select2-ddlpass_family-container")
	private WebElement familyMember;
	
	@FindBy(id = "select2-ddlpass_cntry-container")
	private WebElement countryOfIssue;
	
	@FindBy(id = "txtpass_number")
	private WebElement passportNumber;
	
	@FindBy(id = "txtpass_IssueAuth")
	private WebElement issuingAutority;
	
	@FindBy(id = "dtpass_DOI")
	private WebElement doi;
	
	@FindBy(id = "dtpass_DOE")
	private WebElement doe;
	
	@FindBy(id = "btnsavePass")
	private WebElement saveBtnPassport;
	
	
	
	
	
	// Constructor to initialize WebElement
		public CreateNewStudent(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
		
	// Functions of Create new student
		
	public void navigateOnAdmissionPage() throws InterruptedException {
		HomePage.goToAdmissionApplicationPage();
		log.info("Reached on Admission application page");
	}
	
	public void clickOnNewStudentButton(){
		Utilities.waitForElementToBeClickableAndClick(newStudentBtn);
		log.info("Clicked on new student button");
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
		Utilities.waitForElementToBeClickableAndClick(dateOfBirth);
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
	
	public void enterEmailAddress(String email) {
		Utilities.type(emailAddress, email);
		log.info("Entered student email address");
	}
	
	public void clickOnSubmitButton() {
		Utilities.waitForElementToBeClickableAndClick(doneButton);
		log.info("Cliked on done button after entered student details");
	}
	
	public String getCreatedNewStudentName() {
		WebElement studentName = driver.findElement(By.xpath("//span[@id='spnStuName']"));
		String stuName = Utilities.getText(studentName);
		return stuName;
	}
	
	public void enterDataInNewStudentForm(ArrayList<String> list) throws InterruptedException {
		selectTitle(list.get(0));
		enterName(list.get(1));
		enterMiddleName(list.get(2));
		selectGender(list.get(3));
		enterDateOfBirth(list.get(4));
		selectMaritalStatus(list.get(5));
		selectCountryOfCitizenship(list.get(6));
		selectCountryOfCurrentResidence(list.get(7));
		selectMobileCountry(list.get(8));
		enterMobileNumber(list.get(9));
		enterEmailAddress(list.get(10));
	}
	
	
	// Functions of family member tab
	
	public void clickOnAddFamilyMemberButton() {
		Utilities.scrollIntoView(addFmlyMemBtn);
		Utilities.waitForElementToBeClickable(addFmlyMemBtn);
		Utilities.waitForElementToBeClickableAndClick(addFmlyMemBtn);
		log.info("Clicked on Add Family member button");
		
	}
	
	public void selectFamTitle(String famTitleStr) {
		Utilities.waitForElementToBeClickableAndClick(titleFamilyMember);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ famTitleStr + "')]")).click();
		log.info("Family Title selected");
	}
	
	public void enterFamFirstName(String famFirstName) {
		Utilities.type(fam_FirstName, famFirstName);
	}
	
	public void enterFamMidName(String famMidName) {
		Utilities.type(fam_MiddleName, famMidName);
	}
	
	public void selectFamGender(String famGender) {
		Utilities.waitForElementToBeClickableAndClick(fam_Gender);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ famGender + "')]")).click();
		log.info("Family Gender selected");
	}
	
	public void enterFamDateOfBirth(String famDob) {
		Utilities.waitForElementToBeClickableAndClick(fam_Dob);
		Utilities.type(fam_Dob, famDob);
		log.info("Entered Family Member date of birth");
	}
	
	public void selectFamMaritalStatus(String famMaritalSts) {
		Utilities.waitForElementToBeClickableAndClick(fam_Marital_Status);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ famMaritalSts + "')]")).click();
		log.info("Family Member Marital status selected");
	}
	
	public void enterFamMarriageDate(String MarriageDate) {
		Utilities.waitForElementToBeClickableAndClick(fam_Marriage_Date);
		Utilities.type(fam_Marriage_Date, MarriageDate);
		log.info("Entered Family Member Marriage date");
	}
	
	public void selectFamRelation(String famRelation) {
		Utilities.waitForElementToBeClickableAndClick(fam_Relation);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+ famRelation + "')]")).click();
		log.info("Family Member relation selected");
	}
	
	public void selectFamMemNationality(String famNationality) {
		Utilities.waitForElementToBeClickableAndClick(fam_Nationality);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(famNationality);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ famNationality +"']")).click();
		log.info("Family Member nationality selected");
	}
	
	public void clickOnDoneButtonForFamilymember() {
		Utilities.waitForElementToBeClickableAndClick(fam_Savebtn);
		log.info("Clicked on Done button for Add Family Member");
	}
	
	public String getCreatedFamilyMember(String FamMemberName) {
		
		WebElement Name = driver.findElement(By.xpath("//div[normalize-space()='" + FamMemberName + "']"));
		Utilities.scrollIntoView(Name);
		Utilities.waitForElementToBeClickable(Name);
		String famName = Utilities.getText(Name);
		return famName;
	}
	
	public void enterDataInAddFamilyMemberForm(ArrayList<String> list) {
		selectFamTitle(list.get(0));
		enterFamFirstName(list.get(1));
		enterFamMidName(list.get(2));
		selectFamGender(list.get(3));
		enterFamDateOfBirth(list.get(4));
		selectFamMaritalStatus(list.get(5));
		enterFamMarriageDate(list.get(6));
		selectFamRelation(list.get(7));
		selectFamMemNationality(list.get(8));
	}
	
	
	//Functions of Address tab
	
	public void clickOnAddressTab() {
		Utilities.scrollIntoView(addressTab);
		Utilities.waitForElementToBeClickable(addressTab);
		Utilities.waitForElementToBeClickableAndClick(addressTab);
		log.info("Clicked on Address Tab");
	}
	
	public void clickOnAddAddressBtn() {
		Utilities.scrollIntoView(addAddressBtn);
		Utilities.waitForElementToBeClickableAndClick(addAddressBtn);
		log.info("Clicked on Address Button");
	}
	
	public void selectCountry(String countryStr) {
		Utilities.waitForElementToBeClickableAndClick(country);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(countryStr);
		driver.findElement(By.xpath("//span/ul/li[text()='"+countryStr+"']")).click();
		log.info("Country selected for Add Address");
	}
	
	public void selectState(String stateStr) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(state);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(stateStr);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span/ul/li[text()='"+stateStr+"']")).click();
		log.info("Country selected for Add Address");
	}
	
	public void enterCity(String cityStr) {
		Utilities.type(city, cityStr);
		log.info("Entered city ");
	}
	
	public void enterAddressLine1(String addressLine1Str) {
		Utilities.type(addressLine1, addressLine1Str);
		log.info("Entered address");
	}
	
	public void enterPostCode(String postcodeStr) {
		Utilities.type(postcode, postcodeStr);
		log.info("Entered PostCode");
	}
	
	public void clickOnFamMemberCheckBox() {
//		Utilities.waitForElementToBeClickableAndClick(chckBox);
		Utilities.javascriptClick(chckBox);
		log.info("check box checked");
	}
	
	public void clickOnDoneButtonForAddress() {
		Utilities.waitForElementToBeClickableAndClick(saveAddressBtn);
		log.info("Clicked on Done button for Add Family Member");
	}
	
	public String getAddress(String address) {
		WebElement AddressName = driver.findElement(By.xpath("//div[@class='info-name' and contains(text(),'"+address+"')]"));
		Utilities.scrollIntoView(AddressName);
		String Name = Utilities.getText(AddressName);
		return Name;
	}
	
	public void enterDataInAddAddressForm(ArrayList<String> list) throws InterruptedException {
		selectCountry(list.get(0));
		selectState(list.get(1));
		enterCity(list.get(2));
		enterAddressLine1(list.get(3));
		enterPostCode(list.get(4));
		clickOnFamMemberCheckBox();
		
	}
	
	
	// Functions of Passport tab
	
	public void clickOnPassportTab() {
		Utilities.scrollIntoView(passportTab);
		Utilities.waitForElementToBeClickableAndClick(passportTab);
		log.info("Clicked on Passport Tab");
	}
	
	public void clickOnAddPassportBtn() {
		Utilities.scrollIntoView(addPassportBtn);
		Utilities.waitForElementToBeClickableAndClick(addPassportBtn);
		log.info("Clicked on Add Passport Button");
	}
	
	public void selectFamilyMemberForPassport(String str) {
		Utilities.waitForElementToBeClickableAndClick(familyMember);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'"+str+"')]")).click();
		log.info("Selected family member for Passport");
	}
	
	public void selectIssueCountry(String str) {
		Utilities.waitForElementToBeClickableAndClick(countryOfIssue);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+str+"']")).click();
		log.info("Issue Country selected for Passport");
	}
	
	public void enterPassportNumber(String str) {
		Utilities.type(passportNumber, str);
		log.info("Entered Passport number");
	}
	
	public void enterIssuingAuthorityName(String str) {
		Utilities.type(issuingAutority, str);
		log.info("Entered Issuing Authority name");
	}
	
	public void enterDOI(String str) {
		Utilities.type(doi, str);
		log.info("Entered date of issue");
	}
	
	public void enterDOE(String str) {
		Utilities.type(doe, str);
		log.info("Entered date of expiry");
	}
	
	public void clickOnDoneButtonForPassport() {
		Utilities.waitForElementToBeClickableAndClick(saveBtnPassport);
		log.info("Clicked on Done button to save Passport details");
	}
	
	public void enterDataInPassportForm(ArrayList<String> list) {
		selectFamilyMemberForPassport(list.get(0));
		selectIssueCountry(list.get(1));
		enterPassportNumber(list.get(2));
		enterIssuingAuthorityName(list.get(3));
		enterDOI(list.get(4));
		enterDOE(list.get(5));;
	
	}


}
