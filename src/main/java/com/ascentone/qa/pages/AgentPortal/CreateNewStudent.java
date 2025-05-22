package com.ascentone.qa.pages.AgentPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ascentone.qa.base.TestBase;
import com.ascentone.qa.pages.home.HomePage;

import common.util.Utilities;

public class CreateNewStudent extends TestBase {

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

	@FindBy(id = "select2-ddlGender_fam-container")
	private WebElement fam_Gender;

	@FindBy(id = "txtdob_fam")
	private WebElement fam_Dob;

	@FindBy(id = "select2-ddlMaritalStatus_fam-container")
	private WebElement fam_Marital_Status;

	@FindBy(id = "txtmarriage_date_fam")
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

	@FindBy(xpath = "//button[@class='btn btn-primary'][normalize-space()='Add Passport']")
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

	@FindBy(xpath = "//a[contains(@aria-label,'View Options')]//i[contains(@class,'fas fa-ellipsis-v-alt fs-lg')]")
	private WebElement threeDotsForPassport;

	@FindBy(xpath = "//a[@aria-label='Upload Documents']")
	private WebElement documentOptForPassport;

	@FindBy(xpath = "//button[@onclick='Upload_PAS_DOC();']")
	private WebElement doneBtnUploadForPassport;

	// Locators of Visa History

	@FindBy(id = "visHis-tab")
	private WebElement visahistoryTab;

	@FindBy(id = "select2-ddlVisSubCls-container")
	private WebElement visaType;

	@FindBy(xpath = "//div[@id='dvAddVisaApp_Vis_His']//button[@role='button'][normalize-space()='Add application']")
	private WebElement addVisaAppBtn;

	@FindBy(id = "select2-ddl_vis_family_member-container")
	private WebElement famMemberForVisa;

	@FindBy(id = "select2-ddl_vis_his_country-container")
	private WebElement countryForVisa;

	@FindBy(id = "select2-ddl_vis_type-container")
	private WebElement typeVisa;

	@FindBy(id = "vis_his_application_date")
	private WebElement visaAppDate;

	@FindBy(id = "vis_his_decision_date")
	private WebElement visaDecisionDate;

	@FindBy(id = "select2-ddl_vis_his_outcom-container")
	private WebElement appOutcome;

	@FindBy(xpath = "//button[contains(@onclick,'SaveVisHisDetails();')]")
	private WebElement visaHisSaveBtn;

	@FindBy(xpath = "//div[@id='div_visHis_tab_detailed']//i[@class='fas fa-ellipsis-v-alt fs-lg']")
	private WebElement threeDotsOfVisa;

	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//a[@aria-label='Upload Documents'][normalize-space()='Document']")
	private WebElement documentOptForVisa;

	@FindBy(xpath = "//button[contains(@onclick,'Upload_PAS_DOC();')]")
	private WebElement doneBtnUploadForVisa;

	// Locators for Academics tab

	@FindBy(id = "btnVisaHisNext")
	private WebElement visaHisNextBtn;

	@FindBy(id = "btnAddEDU")
	private WebElement addQualificatioBtn;

	@FindBy(id = "select2-ddlEDU_family-container")
	private WebElement famMemForAcademic;

	@FindBy(xpath = "//span[@id='select2-ddl_edu_cntry-container']")
	private WebElement countryForAcademic;

	@FindBy(id = "select2-ddl_edu_state-container")
	private WebElement stateForAcademic;

	@FindBy(id = "txt_edu_city")
	private WebElement cityForAcademic;

	@FindBy(id = "txt_edu_qualifctn")
	private WebElement qualification;

	@FindBy(id = "txt_edu_studyAt")
	private WebElement studyAt;

	@FindBy(id = "txt_edu_award")
	private WebElement awardingBody;

	@FindBy(id = "select2-ddl_edu_score_type-container")
	private WebElement scoreType;

	@FindBy(id = "txt_edu_score")
	private WebElement score;

	@FindBy(id = "txt_edu_startDt")
	private WebElement startDate;

	@FindBy(id = "txt_edu_endDt")
	private WebElement endDate;

	@FindBy(xpath = "//button[contains(@onclick,'saveAcademics(this)')]")
	private WebElement saveBtnForAcademic;

	@FindBy(xpath = "//div[@id='edu_0']//i[@class='fas fa-ellipsis-v-alt fs-lg']")
	private WebElement threeDotsOfAcademics;

	@FindBy(xpath = "//a[@aria-label='Upload Documents'][normalize-space()='Documents']")
	private WebElement documentOptOfAcademics;

	@FindBy(xpath = "//button[contains(@onclick,'Upload_PAS_DOC();')]")
	private WebElement doneBtnOfAcademicsDoc;

	// Locators of English Ability tab

	@FindBy(id = "engAblt-tab")
	private WebElement englishAbilityTab;

	@FindBy(xpath = "//a[contains(text(),'Add English Test')]")
	private WebElement englishAbilitytestBtn;

	@FindBy(id = "select2-ddlEDU_ENG_DUO-container")
	private WebElement famMemForDuo;

	@FindBy(id = "dt_duolingo")
	private WebElement testDateForDuo;

	@FindBy(id = "txtduolingo")
	private WebElement testNumberForDuo;

	@FindBy(id = "_duo_speaking")
	private WebElement duoSpeaking;

	@FindBy(id = "_duo_writing")
	private WebElement duoWriting;

	@FindBy(id = "_duo_reading")
	private WebElement duoReading;

	@FindBy(id = "_duo_listening")
	private WebElement duoListening;

	@FindBy(id = "_duo_Production")
	private WebElement duoProd;

	@FindBy(id = "_duo_Literacy")
	private WebElement duoLiteracy;

	@FindBy(id = "_duo_Comprehension")
	private WebElement duoCompre;

	@FindBy(id = "_duo_Conversation")
	private WebElement duoCoversation;

	@FindBy(id = "_duo_verall")
	private WebElement duoOverall;

	@FindBy(id = "_saveduolingo")
	private WebElement saveBtnForDuo;

	// Locators for Finance Tab

	@FindBy(id = "FinancialAbilityA-tab")
	private WebElement financeTab;

	@FindBy(xpath = "//button[normalize-space()='Add Sponsor']")
	private WebElement addSponsorBtn;

	@FindBy(id = "select2-ddlTitle_Sponsor-container")
	private WebElement sponsorTitle;

	@FindBy(id = "txtSponsorFirstName")
	private WebElement sponsorFirstName;

	@FindBy(id = "txtSponsorMiddleName")
	private WebElement sponsorMidName;

	@FindBy(id = "txtSponsorLastName")
	private WebElement sponsorLastName;

	@FindBy(id = "select2-ddlRelationShip_Sponsor-container")
	private WebElement sponsorRelationShip;

	@FindBy(id = "select2-ddlCountry_Sponsor-container")
	private WebElement sponsorNationality;

	@FindBy(id = "select2-ddlCountry_CYcurrency-container")
	private WebElement CY_Currency;

	@FindBy(id = "txtIncomeCY")
	private WebElement CY_Income;

	@FindBy(id = "select2-ddlCountry_LYcurrency-container")
	private WebElement LY_Currency;

	@FindBy(id = "txtIncomeLY")
	private WebElement LY_Income;

	@FindBy(xpath = "//div[@class='modal-footer']//div//button[@onclick='addUpdateSponsor();']")
	private WebElement doneBtnForAddSponsor;

	// Locators of OSHC tab

	@FindBy(id = "oshc-tab")
	private WebElement OSHCTab;

	@FindBy(id = "chkadditional_OSHC")
	private WebElement OSHCToggleBtn1;

	@FindBy(id = "chkadditional_OSHC_edu")
	private WebElement OSHCToggleBtn2;

	@FindBy(id = "txtprovider")
	private WebElement OSHCProvider;

	@FindBy(id = "txtmembernumber_oshc")
	private WebElement OSHCMembershipNo;

	@FindBy(id = "dt_additional_expiry_oshc")
	private WebElement OSHCExpiryDate;

	@FindBy(id = "btn_addtionalDoc_oshc")
	private WebElement uploadOSHCPolicyBtn;

	@FindBy(xpath = "//button[@onclick='SaveAddInfo_OSHC(this);']")
	private WebElement OSHCSaveBtn;

	// Locators of Employment tab

	@FindBy(id = "emplmnt-tab")
	private WebElement employmentTab;

	@FindBy(id = "btnAddEMP")
	private WebElement addEmploymentBtn;

	@FindBy(id = "select2-ddlEDU_EMP-container")
	private WebElement famMemForAddEmp;

	@FindBy(id = "select2-ddlCountry_emp-container")
	private WebElement countryForAddEmp;

	@FindBy(id = "select2-ddlState-container")
	private WebElement stateForAddEmp;

	@FindBy(id = "txtCityTNAllow")
	private WebElement cityForAddEmp;

	@FindBy(id = "lblBusinessName")
	private WebElement buisnessNameForAddEmp;

	@FindBy(id = "lblPosition")
	private WebElement positionForAddEmp;

	@FindBy(id = "dtpFromDate")
	private WebElement startDtForAddEmp;

	@FindBy(xpath = "//button[@onclick='SaveEmploymentDetails();']")
	private WebElement doneBtnForAddEmp;

	// Constructor to initialize WebElement
	public CreateNewStudent(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Functions of Create new student

	public void navigateOnAdmissionPage() throws InterruptedException {
		HomePage.goToAdmissionApplicationPage();
		log.info("Reached on Admission application page");
	}

	public void clickOnNewStudentButton() {
		Utilities.waitForElementToBeClickableAndClick(newStudentBtn);
		log.info("Clicked on new student button");
	}

	public void selectTitle(String titleStr) {
		Utilities.waitForElementToBeClickableAndClick(title);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + titleStr + "')]")).click();
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
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + genderStr + "')]")).click();
		log.info("Gender selected");
	}

	public void enterDateOfBirth(String dob) {
		Utilities.waitForElementToBeClickableAndClick(dateOfBirth);
		Utilities.type(dateOfBirth, dob);
		log.info("Entered student date of birth");
	}

	public void selectMaritalStatus(String maritalSts) {
		Utilities.waitForElementToBeClickableAndClick(maritalStatus);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + maritalSts + "')]")).click();
		log.info("Marital status selected");
	}

	public void selectCountryOfCitizenship(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(countryOfCitizenship);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Country Of Citizenship selected");
	}

	public void selectCountryOfCurrentResidence(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(countryOfCurrentresidency);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Country Of Current Residence selected");
	}

	public void selectMobileCountry(String mobCountry) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(mobileCountry);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(mobCountry);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + mobCountry + "')]")).click();
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

	public String getCreatedNewStudentName() throws InterruptedException {
		Thread.sleep(10000);
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
		Utilities.waitForPageLoad();
		Utilities.scrollIntoView(addFmlyMemBtn);
		Utilities.waitForElementToBeClickable(addFmlyMemBtn);
		Utilities.waitForElementToBeClickableAndClick(addFmlyMemBtn);
		log.info("Clicked on Add Family member button");

	}

	public void selectFamTitle(String famTitleStr) {
		Utilities.waitForElementToBeClickableAndClick(titleFamilyMember);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + famTitleStr + "')]")).click();
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
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + famGender + "')]")).click();
		log.info("Family Gender selected");
	}

	public void enterFamDateOfBirth(String famDob) {
		Utilities.waitForElementToBeClickableAndClick(fam_Dob);
		Utilities.type(fam_Dob, famDob);
		log.info("Entered Family Member date of birth");
	}

	public void selectFamMaritalStatus(String famMaritalSts) {
		Utilities.waitForElementToBeClickableAndClick(fam_Marital_Status);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + famMaritalSts + "')]")).click();
		log.info("Family Member Marital status selected");
	}

	public void enterFamMarriageDate(String MarriageDate) {
		Utilities.waitForElementToBeClickableAndClick(fam_Marriage_Date);
		Utilities.type(fam_Marriage_Date, MarriageDate);
		log.info("Entered Family Member Marriage date");
	}

	public void selectFamRelation(String famRelation) {
		Utilities.waitForElementToBeClickableAndClick(fam_Relation);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + famRelation + "')]")).click();
		log.info("Family Member relation selected");
	}

	public void selectFamMemNationality(String famNationality) {
		Utilities.waitForElementToBeClickableAndClick(fam_Nationality);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(famNationality);
		driver.findElement(By.xpath("//span/ul/li[text()='" + famNationality + "']")).click();
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

	// Functions of Address tab

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
		driver.findElement(By.xpath("//span/ul/li[text()='" + countryStr + "']")).click();
		log.info("Country selected for Add Address");
	}

	public void selectState(String stateStr) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(state);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(stateStr);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span/ul/li[text()='" + stateStr + "']")).click();
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
		Utilities.javascriptClick(chckBox);
		log.info("check box checked");
	}

	public void clickOnDoneButtonForAddress() {
		Utilities.waitForElementToBeClickableAndClick(saveAddressBtn);
		log.info("Clicked on Done button for Add Family Member");
	}

	public String getAddress(String address) {
		WebElement AddressName = driver
				.findElement(By.xpath("//div[@class='info-name' and contains(text(),'" + address + "')]"));
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
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + str + "')]")).click();
		log.info("Selected family member for Passport");
	}

	public void selectIssueCountry(String str) {
		Utilities.waitForElementToBeClickableAndClick(countryOfIssue);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
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

	public void clickOnThreeDotsForPassport() {
		Utilities.waitForElementToBeClickableAndClick(threeDotsForPassport);
		log.info("Clicked on three dots to upload passport documents");
	}

	public void clickOnDocumentOptionForPassport() {
		Utilities.waitForElementToBeClickableAndClick(documentOptForPassport);
		log.info("Clicked on documents option to upload passport documents");
	}

	public void uploadPassportDoc() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		clickOnThreeDotsForPassport();
		clickOnDocumentOptionForPassport();
		Thread.sleep(2000);

		WebElement photoPageDoc = driver
				.findElement(By.xpath("(//button[@role='button'][normalize-space()='Upload'])[2]"));
		String photoPageDocFilePath = "C:\\Users\\vikas.verma\\Downloads\\Invoice--AGENT--1.pdf";
		Utilities.uploadFile(photoPageDocFilePath, photoPageDoc);
		log.info("Photo page doc uploaded successfully");

		WebElement signaturePageDoc = driver
				.findElement(By.xpath("(//button[@role='button'][normalize-space()='Upload'])[3]"));
		String signaturePageDocFilePath = "C:\\Users\\vikas.verma\\Downloads\\Invoice--AGENT--1.pdf";
		Utilities.uploadFile(signaturePageDocFilePath, signaturePageDoc);
		log.info("Signature page doc uploaded successfully");

		WebElement visaPageDoc = driver
				.findElement(By.xpath("(//button[@role='button'][normalize-space()='Upload'])[4]"));
		String visaPageDocFilePath = "C:\\Users\\vikas.verma\\Downloads\\Invoice--AGENT--1.pdf";
		Utilities.uploadFile(visaPageDocFilePath, visaPageDoc);
		log.info("Visa page doc uploaded successfully");
	}

	public void clickOnUploadPassDocDoneBtn() {
		Utilities.waitForElementToBeClickableAndClick(doneBtnUploadForPassport);
		log.info("Clicked on done button after upload passport docs");
	}

	public void enterDataInPassportForm(ArrayList<String> list) {
		selectFamilyMemberForPassport(list.get(0));
		selectIssueCountry(list.get(1));
		enterPassportNumber(list.get(2));
		enterIssuingAuthorityName(list.get(3));
		enterDOI(list.get(4));
		enterDOE(list.get(5));
	}

	// Functions of Visa History tab

	public void clickOnVisaHistoryTab() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.javascriptClick(visahistoryTab);
		log.info("Clicked on Visa History Tab");
	}

	public void clickOnAddApplicationBtnForVisa() {
		Utilities.scrollIntoView(addVisaAppBtn);
		Utilities.waitForElementToBeClickable(addVisaAppBtn);
		Utilities.javascriptClick(addVisaAppBtn);
		log.info("Clicked on add application button for Visa History");
	}

	public void selectFamMemberForVisa(String str) {
		Utilities.waitForElementToBeClickableAndClick(famMemberForVisa);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + str + "')]")).click();
		log.info("Selected family member for Visa");
	}

	public void selectCountryForVisa(String str) {
		Utilities.waitForElementToBeClickableAndClick(countryForVisa);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Country selected for Visa");
	}

	public void selectVisaType(String str) {
		Utilities.waitForElementToBeClickableAndClick(typeVisa);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Visa type selected for Visa History");
	}

	public void enterVisaApplicationDate(String str) {
		Utilities.type(visaAppDate, str);
		log.info("Entered Viusa application date");
	}

	public void enterVisaDecisionDate(String str) {
		Utilities.type(visaDecisionDate, str);
		log.info("Entered Visa Decision date");
	}

	public void selectAppOutcome(String str) {
		Utilities.waitForElementToBeClickableAndClick(appOutcome);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Visa type selected for Visa History");
	}

	public void clickOnDoneButtonForVisa() {
		Utilities.waitForElementToBeClickableAndClick(visaHisSaveBtn);
		log.info("Clicked on Done button to save visa application details");
	}

	public void clickOnThreeDotsForVisa() {
		Utilities.waitForElementToBeClickableAndClick(threeDotsOfVisa);
		log.info("Clicked on three dots to upload visa documents");
	}

	public void clickOnDocumentOptionForVisa() {
		Utilities.waitForElementToBeClickableAndClick(documentOptForVisa);
		log.info("Clicked on documents option to upload visa documents");
	}

	public void uploadVisaDoc() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		clickOnThreeDotsForVisa();
		clickOnDocumentOptionForVisa();
		Thread.sleep(2000);
		
		WebElement visaOutcomeLetterDoc = driver.findElement(By.xpath(
				"//button[contains(@class,'btn btn-primary btn-md waves-effect waves-themed')][normalize-space()='Upload']"));
		String visaOutcomeLetterFilePath = "C:\\Users\\vikas.verma\\Downloads\\Invoice--AGENT--1.pdf";
		Utilities.uploadFile(visaOutcomeLetterFilePath, visaOutcomeLetterDoc);
		log.info("Visa doc uploaded successfully");
	}

	public void clickOnUploadVisaDocDoneBtn() {
		Utilities.waitForElementToBeClickableAndClick(doneBtnUploadForVisa);
		log.info("Clicked on done button after upload visa docs");
	}

	public void enterDataInVisaHistoryForm(ArrayList<String> list) {
		selectFamMemberForVisa(list.get(0));
		selectCountryForVisa(list.get(1));
		selectVisaType(list.get(2));
		enterVisaApplicationDate(list.get(3));
		enterVisaDecisionDate(list.get(4));
		selectAppOutcome(list.get(5));
	}

	// Functions of Academics tab

	public void clickOnNextBtnOnVisaHisPage() {
		Utilities.scrollIntoView(visaHisNextBtn);
		Utilities.waitForElementToBeClickable(visaHisNextBtn);
		Utilities.javascriptClick(visaHisNextBtn);
		log.info("Clicked on next button on visa history page");
	}

	public void clickOnAddQualificationBtn() {
		Utilities.scrollIntoView(addQualificatioBtn);
		Utilities.javascriptClick(addQualificatioBtn);
		log.info("Clicked on add qualification ");
	}

	public void selectFamMemForAcademic(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(famMemForAcademic);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + str + "')]")).click();
		log.info("Selected family member for academics qualification");
	}

	public void selectCountryForAcademic(String str) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(countryForAcademic);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Country selected for academics qualification");
	}

	public void selectStateForAcademic(String str) throws InterruptedException {
		Thread.sleep(3000);
		Utilities.waitForElementToBeClickableAndClick(stateForAcademic);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("State selected for academics qualification");
	}

	public void enterCityForAcademic(String str) {
		Utilities.type(cityForAcademic, str);
		log.info("Entered city for academics");
	}

	public void enterqualificationForAcademic(String str) {
		Utilities.type(qualification, str);
		log.info("Entered qualification for academics");
	}

	public void enterStudyAtForAcademic(String str) {
		Utilities.type(studyAt, str);
		log.info("Entered study at for academics");
	}

	public void enterAwardingBodyForAcademic(String str) {
		Utilities.type(awardingBody, str);
		log.info("Entered awarding body for academics");
	}

	public void selectScoreType(String str) {
		Utilities.waitForElementToBeClickableAndClick(scoreType);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + str + "')]")).click();
		log.info("Selected score type for academics qualification");
	}

	public void enterScoreForAcademic(String str) {
		Utilities.type(score, str);
		log.info("Entered score for academics");
	}

	public void enterStartDateForAcademic(String str) {
		Utilities.type(startDate, str);
		log.info("Entered start date for academics");
	}

	public void enterEndDateForAcademic(String str) {
		Utilities.type(endDate, str);
		log.info("Entered end date for academics");
	}

	public void clickOnDoneButtonToSaveAcademicDetails() {
		Utilities.waitForElementToBeClickableAndClick(saveBtnForAcademic);
		log.info("Clicked on done button to save academics details");
	}

	public void clickOnThreeDotsOfAcademics() {
		Utilities.waitForElementToBeClickableAndClick(threeDotsOfAcademics);
		log.info("Clicked on three dots to upload academic documents");
	}

	public void clickOnDocumentOptionOfAcademics() {
		Utilities.waitForElementToBeClickableAndClick(documentOptOfAcademics);
		log.info("Clicked on documents option to upload academic documents");
	}

	public void uploadAcademicDoc() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		clickOnThreeDotsOfAcademics();
		clickOnDocumentOptionOfAcademics();
		Thread.sleep(2000);
		
		WebElement marksheetDoc = driver
				.findElement(By.xpath("(//button[@role='button'][normalize-space()='Upload'])[3]"));
		String academicFilePath = "C:\\Users\\vikas.verma\\Downloads\\Invoice--AGENT--1.pdf";
		Utilities.uploadFile(academicFilePath, marksheetDoc);
		log.info("Academic doc uploaded successfully");
	}

	public void clickOnUploadAcademicDocDoneBtn() {
		Utilities.waitForElementToBeClickableAndClick(doneBtnOfAcademicsDoc);
		log.info("Clicked on done button after upload Academic docs");
	}

	public void enterDataInAcademicForm(ArrayList<String> list) throws InterruptedException {
		selectFamMemForAcademic(list.get(0));
		selectCountryForAcademic(list.get(1));
		selectStateForAcademic(list.get(2));
		enterCityForAcademic(list.get(3));
		enterqualificationForAcademic(list.get(4));
		enterStudyAtForAcademic(list.get(5));
		enterAwardingBodyForAcademic(list.get(6));
		selectScoreType(list.get(7));
		enterScoreForAcademic(list.get(8));
		enterStartDateForAcademic(list.get(9));
		enterEndDateForAcademic(list.get(10));
	}

	// Functions for English Ability

	public void clickOnEnglishAbilityTab() {
		Utilities.scrollIntoView(englishAbilityTab);
		Utilities.waitForElementToBeClickableAndClick(englishAbilityTab);
		log.info("Clicked on English Ability tab");
	}

	public void clickOnEnglishAbilityTestDropdwn() throws InterruptedException {
		Utilities.scrollIntoView(englishAbilitytestBtn);
		Utilities.waitForElementToBeClickableAndClick(englishAbilitytestBtn);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Add English language - DUOLINGO']")).click();
		log.info("Clicked on English ability test dropdown button and select duolingo option");
	}

	public void selectFamMemForDuo(String str) {
		Utilities.waitForElementToBeClickableAndClick(famMemForDuo);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + str + "')]")).click();
		log.info("Selected family member for duolingo");
	}

	public void enterTestDateforDuo(String str) {
		Utilities.type(testDateForDuo, str);
		log.info("Entered Test date for duolingo");
	}

	public void enterTestNumberforDuo(String str) {
		Utilities.type(testNumberForDuo, str);
		log.info("Entered test number for duo");
	}

	public void enterSpeakingScoreforDuo(String str) {
		Utilities.type(duoSpeaking, str);
		log.info("Entered speaking score for duo");
	}

	public void enterWritingScoreforDuo(String str) {
		Utilities.type(duoWriting, str);
		log.info("Entered writing score for duo");
	}

	public void enterReadingScoreforDuo(String str) {
		Utilities.type(duoReading, str);
		log.info("Entered reading score for duo");
	}

	public void enterListeningScoreforDuo(String str) {
		Utilities.type(duoListening, str);
		log.info("Entered listening score for duo");
	}

	public void enterProdScoreforDuo(String str) {
		Utilities.type(duoProd, str);
		log.info("Entered production score for duo");
	}

	public void enterLiteracyScoreforDuo(String str) {
		Utilities.type(duoLiteracy, str);
		log.info("Entered Literacy score for duo");
	}

	public void enterComprehensionScoreforDuo(String str) {
		Utilities.type(duoCompre, str);
		log.info("Entered Comprehension score for duo");
	}

	public void enterConversationScoreforDuo(String str) {
		Utilities.type(duoCoversation, str);
		log.info("Entered Conversation score for duo");
	}

	public void enterOverallScoreforDuo(String str) {
		Utilities.type(duoOverall, str);
		log.info("Entered overall score for duo");
	}

	public void clickOnDoneButtonForDuo() {
		Utilities.waitForElementToBeClickableAndClick(saveBtnForDuo);
		log.info("Clicked on done button to save duolingo details");
	}

	public void enterDataInDuolingoform(ArrayList<String> list) {
		selectFamMemForDuo(list.get(0));
		enterTestDateforDuo(list.get(1));
		enterTestNumberforDuo(list.get(2));
		enterSpeakingScoreforDuo(list.get(3));
		enterWritingScoreforDuo(list.get(4));
		enterReadingScoreforDuo(list.get(5));
		enterListeningScoreforDuo(list.get(6));
		enterProdScoreforDuo(list.get(7));
		enterLiteracyScoreforDuo(list.get(8));
		enterComprehensionScoreforDuo(list.get(9));
		enterConversationScoreforDuo(list.get(10));
		enterOverallScoreforDuo(list.get(11));
	}

	// Functions of Finance tab

	public void clickOnFinanceTab() {
		Utilities.scrollIntoView(financeTab);
		Utilities.javascriptClick(financeTab);
		log.info("Clicked on finance tab");
	}

	public void clickOnAddSponsorBtn() {
		Utilities.scrollIntoView(addSponsorBtn);
		Utilities.javascriptClick(addSponsorBtn);
		log.info("Clicked on add sponsor button");
	}

	public void selectTitleOfSponsor(String str) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(sponsorTitle);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Title selected for add sponsor");
	}

	public void enterFirstNameofSponsor(String str) {
		Utilities.type(sponsorFirstName, str);
		log.info("Entered Fisrt name for add sponsor");
	}

	public void enterMidNameofSponsor(String str) {
		Utilities.type(sponsorMidName, str);
		log.info("Entered Middle name for add sponsor");
	}

	public void enterLastNameofSponsor(String str) {
		Utilities.type(sponsorLastName, str);
		log.info("Entered Last name for add sponsor");
	}

	public void selectSponsorRelation(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(sponsorRelationShip);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Sponsor relationship with main applicant selected for add sponsor");
	}

	public void selectNationalityForSponsor(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(sponsorNationality);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Sponsor relationship with main applicant selected for add sponsor");
	}

	public void selectCYCurrency(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(CY_Currency);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Current Year Currency selected for add sponsor");
	}

	public void enterCYIncomeOfSponsor(String str) {
		Utilities.type(CY_Income, str);
		log.info("Current Year Income entered for add sponsor");
	}

	public void selectLYCurrency(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(LY_Currency);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Last Year Currency selected for add sponsor");
	}

	public void enterLYIncomeOfSponsor(String str) {
		Utilities.type(LY_Income, str);
		log.info("Last Year Income entered for add sponsor");
	}

	public void clickOnDoneButtonToSaveFinanceSponsorDetails() {
		Utilities.scrollIntoView(doneBtnForAddSponsor);
		Utilities.javascriptClick(doneBtnForAddSponsor);
		log.info("Clicked on done button to save finance sponsor details");
	}

	public void enterDataInAddSponsorForm(ArrayList<String> list) throws InterruptedException {
		selectTitleOfSponsor(list.get(0));
		enterFirstNameofSponsor(list.get(1));
		enterMidNameofSponsor(list.get(2));
		enterLastNameofSponsor(list.get(3));
		selectSponsorRelation(list.get(4));
		selectNationalityForSponsor(list.get(5));
		selectCYCurrency(list.get(6));
		enterCYIncomeOfSponsor(list.get(7));
		selectLYCurrency(list.get(6));
		enterLYIncomeOfSponsor(list.get(8));
	}

	// Functions of OSHC tab

	public void clickOnOSHCTab() {
		Utilities.waitForElementToBeClickableAndClick(OSHCTab);
		log.info("clicked on OSHC tab");
	}

	public void clickOnOSHCToggleBtn1() throws InterruptedException {
		Utilities.scrollIntoView(OSHCToggleBtn1);
		Thread.sleep(2000);
		Utilities.javascriptClick(OSHCToggleBtn1);
		log.info("clicked on OSHC toggle button 1");
	}

	public void clickOnOSHCToggleBtn2() {
		Utilities.scrollIntoView(OSHCToggleBtn2);
		Utilities.javascriptClick(OSHCToggleBtn2);
		log.info("clicked on OSHC toggle button 2");
	}

	public void enterOSHCProvider(String str) {
		Utilities.type(OSHCProvider, str);
		log.info("Entered OSHC provider");
	}

	public void enterOSHCMembershipNo(String str) {
		Utilities.type(OSHCMembershipNo, str);
		log.info("Entered OSHC membership number");
	}

	public void enterOSHCExpiryDate(String str) {
		Utilities.type(OSHCExpiryDate, str);
		log.info("Entered OSHC expiry date");
	}

	public void uploadOSHCPolicy() throws InterruptedException, AWTException {
		Utilities.waitForElementToBeClickableAndClick(uploadOSHCPolicyBtn);
		WebElement uploadElement = driver.findElement(By.id("btn_doc_Additional_oshc"));
		String OSHCPolicyFilePath = "C:\\Users\\vikas.verma\\Downloads\\Invoice--AGENT--1.pdf";
		Utilities.uploadFile(OSHCPolicyFilePath, uploadElement);
		log.info("OSHC policy doc uploaded successfully");
	}

	public void clickOnOSHCSaveBtn() {
		Utilities.javascriptClick(OSHCSaveBtn);
		log.info("clicked on save button to save OSHC details");
	}

	public void enterDataForOSHC(ArrayList<String> list) throws InterruptedException, AWTException {
		clickOnOSHCToggleBtn1();
		clickOnOSHCToggleBtn2();
		enterOSHCProvider(list.get(0));
		enterOSHCMembershipNo(list.get(1));
		enterOSHCExpiryDate(list.get(2));
		uploadOSHCPolicy();
	}

	// Functions of Employment Tab

	public void clickOnEmploymentTab() {
		Utilities.waitForElementToBeClickableAndClick(employmentTab);
		log.info("clicked on employment tab");
	}

	public void clickOnAddEmploymentBtn() {
		Utilities.scrollIntoView(addEmploymentBtn);
		Utilities.waitForElementToBeClickableAndClick(addEmploymentBtn);
		log.info("clicked on add employment button");
	}

	public void selectFamMemForEmployment(String str) throws InterruptedException {
		Utilities.waitForElementToBeClickableAndClick(famMemForAddEmp);
		driver.findElement(By.xpath("//span/ul/li[contains(text(),'" + str + "')]")).click();
		log.info("Selected family member for add employment");
	}

	public void selectCountryForEmployment(String str) {
		Utilities.waitForElementToBeClickableAndClick(countryForAddEmp);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("Country selected for add employment");
	}

	public void selectStateForEmployment(String str) throws InterruptedException {
		Thread.sleep(3000);
		Utilities.waitForElementToBeClickableAndClick(stateForAddEmp);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='" + str + "']")).click();
		log.info("State selected for add employment");
	}

	public void enterCityForEmployment(String str) {
		Utilities.type(cityForAddEmp, str);
		log.info("Entered city for add employment");
	}

	public void enterBuisnessNameForEmployment(String str) {
		Utilities.type(buisnessNameForAddEmp, str);
		log.info("Entered buisness name for add employment");
	}

	public void enterPositionForEmployment(String str) {
		Utilities.type(positionForAddEmp, str);
		log.info("Entered position for add employment");
	}

	public void enterStartDateForEmployment(String str) {
		Utilities.type(startDtForAddEmp, str);
		log.info("Entered start date for add employment");
	}

	public void clickOnEmploymentSaveBtn() {
		Utilities.javascriptClick(doneBtnForAddEmp);
		log.info("clicked on save button to save employment details");
	}

	public void enterDataInAddEmploymentForm(ArrayList<String> list) throws InterruptedException {
		selectFamMemForEmployment(list.get(0));
		selectCountryForEmployment(list.get(1));
		selectStateForEmployment(list.get(2));
		enterCityForEmployment(list.get(3));
		enterBuisnessNameForEmployment(list.get(4));
		enterPositionForEmployment(list.get(5));
		enterStartDateForEmployment(list.get(6));
	}

}
