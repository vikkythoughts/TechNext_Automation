package com.qa.test.AgentPortal;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ascentone.qa.base.TestBase;
import com.ascentone.qa.pages.AgentPortal.CreateNewApplication;
import com.ascentone.qa.pages.AgentPortal.CreateNewStudent;
import com.ascentone.qa.pages.login.LoginPage;

import common.util.ReadUtils;
import io.qameta.allure.Description;

public class VerifyCreateNewApplication extends TestBase {

	@BeforeClass
	public void PreRequisite() throws Exception {
		openBrowser();
		enterBaseURL();
	}

	@Description("Verify navigation on Student profile details page from agent side")
	@Test(priority = 1)
	public void TC_001_navigateOnStudentProfileDetailsPage() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		CreateNewApplication obj = new CreateNewApplication(driver);
		LoginPage lp = new LoginPage(driver);
		try {
			lp.loginToApp();
			ob.navigateOnAdmissionPage();
			obj.searchCreatedStudent(ReadUtils.getData("New_Student", 11, 1));
			obj.clickOnArrowBtn();
			log.info("Navigated on created student details page successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify select course functionality to create new application from agent side")
	@Test(priority = 2)
	public void TC_002_selectCourse() {
		CreateNewApplication obj = new CreateNewApplication(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 4; i++) {
				list.add(ReadUtils.getData("Select_Course", i, 2));
			}
			obj.clickOnApplicationTab();
			obj.selectCourse(list);
			log.info("Course is selected successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add data in GS Assesment tab")
	@Test(priority = 3)
	public void TC_003_enterDataInGSAssessment() {
		CreateNewApplication obj = new CreateNewApplication(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 5; i++) {
				list.add(ReadUtils.getData("GS_Assessment", i, 2));
			}
			obj.clickOnNextBtnToNavigateOnGSAssessmentTab();
			obj.enterDataInGSAssessmentForm(list);
			obj.clickOnNextBtnToNavigateOnMissingDocTab();
			log.info("For GS Assessment data added successfully and navigated on next tab");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Description("Verify navigation on declaration page by clicking on next button")
	@Test(priority = 4)
	public void TC_004_clickOnNextBtnToNavigateDeclarationPage() {
		CreateNewApplication obj = new CreateNewApplication(driver);
		try {
			obj.clickOnNextBtnOnMissingDocPageToNavigateDeclarationPage();
			log.info("Navigated on declaration page from missing documents page");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Description("Verify check 'Term & Condition' checkbox functionality")
	@Test(priority = 5)
	public void TC_005_checkTermAndConditionCheckBoxAndNavigateNextTab() {
		CreateNewApplication obj = new CreateNewApplication(driver);
		try {
			obj.clickOnTermAndConditionCheckBox();
			obj.clickOnNextBtnOnDeclarationPageToNavigateReviewPage();
			log.info("Term & Condition checkbox is checked and navigated application review page");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Description("Verify submit button functionality to submit application")
	@Test(priority = 6)
	public void TC_006_submitApplication() {
		CreateNewApplication obj = new CreateNewApplication(driver);
		try {
			obj.clickOnSubmitBtnOfApplication();
			log.info("Application submitted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
