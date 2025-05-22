package com.ascentone.qa.pages.AgentPortal;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ascentone.qa.base.TestBase;

import common.util.Utilities;

public class CreateNewApplication extends TestBase {
	
	//Locators of navigate on created student profile page
	
	@FindBy(xpath ="//div[@id='grdStudent_filter']//input[@placeholder='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath ="//table[@id='grdStudent']//tr/td/a/i[@class='fas fa-chevron-right fs-lg']")
	private WebElement arrowBtn;
	
	@FindBy(id ="Applications-tab")
	private WebElement applicationTab;
	
	@FindBy(id ="btnNewApp")
	private WebElement newApplicationBtn;
	
	//Locators of select courses tab
	
	@FindBy(id ="select2-ddlProviderApp-container")
	private WebElement educationProvider;
	
	@FindBy(xpath ="//div[@class='action']//button[@role='button'][normalize-space()='Add']")
	private WebElement addCourseBtn;
	
	@FindBy(id ="select2-ddlSearchType-container")
	private WebElement searchCoursePackage;
	
	@FindBy(xpath ="//button[@onclick='SearchCourseForClient();']")
	private WebElement searchCourseName;
	
	@FindBy(xpath ="//td/div[contains(text(),'Advanced Diploma of Building Surveying')]//parent::td//preceding-sibling::td/div/input[@type='checkbox']")
	private WebElement selectCourseChckBox;
	
	@FindBy(id ="select2-ddlClnIntake_98459-container")
	private WebElement intakeDate;
	
	@FindBy(id ="select2-ddlClnCampus_98459-container")
	private WebElement campus;
	
	@FindBy(xpath ="//button[@onclick='SaveSelectedCourses();']")
	private WebElement courseDoneBtn;
	
	//Locators of GS Assessment tab
	
	@FindBy(xpath ="//button[@onclick='NextFromApp();']")
	private WebElement nextBtnOnSelectCoursePage;
	
	@FindBy(id ="txtArea_Q_153")
	private WebElement GSQues1;
	
	@FindBy(id ="txtArea_Q_154")
	private WebElement GSQues2;
	
	@FindBy(id ="txtArea_Q_155")
	private WebElement GSQues3;
	
	@FindBy(id ="txtArea_Q_156")
	private WebElement GSQues4;
	
	@FindBy(id ="txtArea_Q_157")
	private WebElement GSQues5;
	
	@FindBy(id ="select2-ddl_Q_159-container")
	private WebElement GSQues6;
	
	@FindBy(id ="select2-ddl_Q_330-container")
	private WebElement GSQues7;
	
	@FindBy(id ="btnNextQbldr")
	private WebElement nextBtnOnGSPage;
	
	
	//Locators of Missing documents tab
	
	@FindBy(xpath = "//div[@id='dv_doclist']//following-sibling::div/div//button[@onclick='LoadTermsAndConditionsContent();']")
	private WebElement nextBtnOnMissingDocPage;
	
	//Locators of Declaration tab
	
	@FindBy(id ="chkTermCondiition")
	private WebElement termConditionChckBox;
	
	@FindBy(id ="btnNextToReview")
	private WebElement nextBtnOnDeclarationPage;
	
	//Locators of Review tab
	
	@FindBy(id ="btnSubmitApplication")
	private WebElement submitBtn;
	
	
	// Constructor to initialize WebElement
			public CreateNewApplication(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			
	//Functions to navigate on created student profile page
			
	public void searchCreatedStudent(String str) {
		Utilities.type(searchBox, str);
		log.info("entered student mail id to search created student");
	}
	
	public void clickOnArrowBtn() {
		Utilities.scrollDown();
		Utilities.javascriptClick(arrowBtn);
		log.info("Clicked on arrow button to navigate student profile details page");
	}
	
	//Functions of create new application
	
	public void clickOnApplicationTab() {
		Utilities.waitForElementToBeClickableAndClick(applicationTab);
		log.info("Clicked on application tab");
	}
	
	public void clickOnNewApplicationBtn() {
		Utilities.waitForElementToBeClickableAndClick(newApplicationBtn);
		log.info("Clicked on new application button");
	}
	
	public void selectEducationProvider(String str) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.scrollDown();
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(educationProvider);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("Education provider selected");
	}
	
	public void clickOnAddBtnToSelectCourse() {
		Utilities.waitForElementToBeClickableAndClick(addCourseBtn);
		log.info("Clicked on add button to select course");
	}
	
	public void selectCoursePackage(String str) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(searchCoursePackage);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("Course package selected");
	}
	
	public void clickOnSearchButton() {
		Utilities.waitForElementToBeClickableAndClick(searchCourseName);
		log.info("Clicked on search button to select course");
	}
	
	public void clickOnCheckBoxToSelectCourse() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.javascriptClick(selectCourseChckBox);
		log.info("Clicked on checkbox to select course");
	}
	
	public void selectIntakeDate(String str) {
		Utilities.waitForElementToBeClickableAndClick(intakeDate);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("Intake date selected");
	}
	
	public void selectCampus(String str) {
		Utilities.waitForElementToBeClickableAndClick(campus);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("Campus selected");
	}
	
	public void clickOnDoneBtnTOSaveCourse() {
		Utilities.scrollDown();
		Utilities.waitForElementToBeClickableAndClick(courseDoneBtn);
		log.info("Clicked on done button to save course");
	}
	
	public void selectCourse(ArrayList<String> list) throws InterruptedException {
		selectEducationProvider(list.get(0));
		clickOnAddBtnToSelectCourse();
		selectCoursePackage(list.get(1));
		clickOnSearchButton();
		clickOnCheckBoxToSelectCourse();
		selectIntakeDate(list.get(2));
		selectCampus(list.get(3));
		clickOnDoneBtnTOSaveCourse();
		
	}
	
	//Functions of GS Assessment tab
	
	public void clickOnNextBtnToNavigateOnGSAssessmentTab() {
		Utilities.scrollDown();
		Utilities.waitForElementToBeClickableAndClick(nextBtnOnSelectCoursePage);
		log.info("Clicked on next button to navigate on GS Assessment tab");
	}
	
	public void enterTextInGSQues1(String str) {
		Utilities.type(GSQues1, str);
		log.info("Entered text in GS Question 1");
	}
	
	public void enterTextInGSQues2(String str) {
		Utilities.type(GSQues2, str);
		log.info("Entered text in GS Question 2");
	}
	
	public void enterTextInGSQues3(String str) {
		Utilities.type(GSQues3, str);
		log.info("Entered text in GS Question 3");
	}
	
	public void enterTextInGSQues4(String str) {
		Utilities.type(GSQues4, str);
		log.info("Entered text in GS Question 4");
	}
	
	public void enterTextInGSQues5(String str) {
		Utilities.type(GSQues5, str);
		log.info("Entered text in GS Question 5");
	}
	
	public void selectOptionInGSQues6(String str) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(GSQues6);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("selected option in GS Question 6");
	}
	
	public void selectOptionInGSQues7(String str) throws InterruptedException {
		Thread.sleep(2000);
		Utilities.waitForElementToBeClickableAndClick(GSQues7);
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(str);
		driver.findElement(By.xpath("//span/ul/li[text()='"+ str +"']")).click();
		log.info("selected option in GS Question 7");
	}
	
	public void enterDataInGSAssessmentForm(ArrayList<String> list) {
		enterTextInGSQues1(list.get(0));
		enterTextInGSQues2(list.get(1));
		enterTextInGSQues3(list.get(2));
		enterTextInGSQues4(list.get(3));
		enterTextInGSQues5(list.get(4));
 	}
	
	public void clickOnNextBtnToNavigateOnMissingDocTab() {
		Utilities.scrollDown();
		Utilities.javascriptClick(nextBtnOnGSPage);
		log.info("Clicked on next button to navigate on Missing Document tab");
	}
	
	public void clickOnArrowIconOnApplicationPage() {
		WebElement arrowIconOnAppPage = driver.findElement(By.xpath("//table[@id='grdStudentApps']//tr/td/div//a/i[@class='fas fa-chevron-right fs-lg']"));
		Utilities.scrollDown();
		Utilities.javascriptClick(arrowIconOnAppPage);
		log.info("Clicked on arrow icon on application page");
	}
	
	
	//Function of Missing documents page
	
	public void clickOnNextBtnOnMissingDocPageToNavigateDeclarationPage() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.scrollDown();
		Utilities.javascriptClick(nextBtnOnMissingDocPage);
		log.info("Clicked on next button to navigate on declaration tab");
	}
	
	
	//Functions of Declaration page
	
	public void clickOnTermAndConditionCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.scrollDown();
		Utilities.javascriptClick(termConditionChckBox);
		log.info("Clicked on Term and Condition Check Box");
	}
	
	public void clickOnNextBtnOnDeclarationPageToNavigateReviewPage() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.scrollDown();
		Utilities.javascriptClick(nextBtnOnDeclarationPage);
		log.info("Clicked on next button to navigate on review page");
	}
	
	//Functions of Review page
	
	public void clickOnSubmitBtnOfApplication() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.scrollDown();
		Utilities.javascriptClick(submitBtn);
		Thread.sleep(4000);
		log.info("Clicked on submit button to submit the application");
	}

}
