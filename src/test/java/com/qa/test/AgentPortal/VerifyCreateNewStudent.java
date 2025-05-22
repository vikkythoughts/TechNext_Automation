package com.qa.test.AgentPortal;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ascentone.qa.base.TestBase;

import common.util.ReadUtils;
import io.qameta.allure.Description;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ascentone.qa.base.TestBase;
import com.ascentone.qa.pages.AgentPortal.CreateNewStudent;
import com.ascentone.qa.pages.login.LoginPage;

import common.util.ReadUtils;

public class VerifyCreateNewStudent extends TestBase {

	@BeforeClass
	public void PreRequisite() throws Exception {
		openBrowser();
		enterBaseURL();

	}

	@Description("Verify login functionality on WebApps (Agent portal)")
	@Test(priority = 1)
	public void TC_001_loginIntoWebApp() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify navigation on Admission Application page through URL")
	@Test(priority = 2)
	public void TC_002_goToAdmissionApplicationPage() throws InterruptedException {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ob.navigateOnAdmissionPage();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify create new student functionality from agent side")
	@Test(priority = 3)
	public void TC_003_createNewStudent() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 11; i++) {
				list.add(ReadUtils.getData("New_Student", i, 1));
			}
			ob.clickOnNewStudentButton();
			ob.enterDataInNewStudentForm(list);
			ob.clickOnSubmitButton();
			log.info("New Student created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Description("Validate created student name on its profile page")
	@Test(priority = 4)
	public void TC_004_verifyCreatedNewStudentName() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			String actualStuName = ob.getCreatedNewStudentName();
			String ExpStuName = ReadUtils.getData("New_Student", 2, 1) + " " + ReadUtils.getData("New_Student", 3, 1);
			Assert.assertEquals(actualStuName, ExpStuName);
			log.info("Student Name is displayed on student profile page");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add family member functionality")
	@Test(priority = 5)
	public void TC_005_addFamilyMember() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 9; i++) {
				list.add(ReadUtils.getData("Family_Member", i, 1));
			}
			ob.clickOnAddFamilyMemberButton();
			ob.enterDataInAddFamilyMemberForm(list);
			ob.clickOnDoneButtonForFamilymember();
			log.info("Family Member added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Description("Validate created family member name")
	@Test(priority = 6)
	public void TC_006_verifyCreatedFamMemberName() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			String ExpFamName = ReadUtils.getData("Family_Member", 2, 1) + " "
					+ ReadUtils.getData("Family_Member", 3, 1);
			String actualFamName = ob.getCreatedFamilyMember(ExpFamName);
			Assert.assertEquals(actualFamName, ExpFamName);
			log.info("Family Member Name is displayed in family member listing on student profile page");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add address functionality")
	@Test(priority = 7)
	public void TC_007_addAddress() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 5; i++) {
				list.add(ReadUtils.getData("Address", i, 2));
			}
			ob.clickOnAddressTab();
			ob.clickOnAddAddressBtn();
			ob.enterDataInAddAddressForm(list);
			ob.clickOnDoneButtonForAddress();
			log.info("Address added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Validate added address name")
	@Test(priority = 8)
	public void TC_008_verifyAddedAddressName() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		String address = ReadUtils.getData("Address", 4, 2);
		try {
			String ExpAddressName = ReadUtils.getData("Address", 7, 2);
			String actualAddressName = ob.getAddress(address);
			Assert.assertEquals(actualAddressName, ExpAddressName);
			log.info("Addes Address details is displayed");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add passport details functionality")
	@Test(priority = 9)
	public void TC_009_addPassportDetails() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 6; i++) {
				list.add(ReadUtils.getData("Passport", i, 2));
			}
			ob.clickOnPassportTab();
			ob.clickOnAddPassportBtn();
			ob.enterDataInPassportForm(list);
			ob.clickOnDoneButtonForPassport();
			log.info("Passport details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify upload passport documents functionality")
	@Test(priority = 10, dependsOnMethods = { "TC_009_addPassportDetails" })
	public void TC_010_uploadPassportDocuments() throws InterruptedException, AWTException {
		CreateNewStudent ob = new CreateNewStudent(driver);
		ob.uploadPassportDoc();
		ob.clickOnUploadPassDocDoneBtn();
		log.info("Passport docs uploaded successfully.");
	}

	@Description("Verify add visa history details functionality")
	@Test(priority = 11)
	public void TC_011_addVisaHistory() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 6; i++) {
				list.add(ReadUtils.getData("Visa History", i, 2));
			}
			ob.clickOnVisaHistoryTab();
			ob.clickOnAddApplicationBtnForVisa();
			ob.enterDataInVisaHistoryForm(list);
			ob.clickOnDoneButtonForVisa();
			log.info("Visa History details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Description("Verify upload visa document functionality")
	@Test(priority = 12, dependsOnMethods = { "TC_011_addVisaHistory" })
	public void TC_012_uploadVisaDocuments() throws InterruptedException, AWTException {
		CreateNewStudent ob = new CreateNewStudent(driver);
		ob.uploadVisaDoc();
		ob.clickOnUploadVisaDocDoneBtn();
		log.info("Passport docs uploaded successfully.");
	}

	@Description("Verify add qualiication details functionality")
	@Test(priority = 13)
	public void TC_013_addAcademicsQualification() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 11; i++) {
				list.add(ReadUtils.getData("Academics", i, 2));
			}
			ob.clickOnVisaHistoryTab();
			ob.clickOnNextBtnOnVisaHisPage();
			ob.clickOnAddQualificationBtn();
			ob.enterDataInAcademicForm(list);
			ob.clickOnDoneButtonToSaveAcademicDetails();
			log.info("Academics details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify upload academics document functionality")
	@Test(priority = 14, dependsOnMethods = { "TC_013_addAcademicsQualification" })
	public void TC_014_uploadAcademicDocuments() throws InterruptedException, AWTException {
		CreateNewStudent ob = new CreateNewStudent(driver);
		ob.clickOnVisaHistoryTab();
		ob.clickOnNextBtnOnVisaHisPage();
		ob.uploadAcademicDoc();
		ob.clickOnUploadAcademicDocDoneBtn();
		log.info("Academics docs uploaded successfully.");
	}

	@Description("Verify add english ability functionality")
	@Test(priority = 15)
	public void TC_015_addEnglishAbility() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 12; i++) {
				list.add(ReadUtils.getData("English Ability", i, 2));
			}
			ob.clickOnEnglishAbilityTab();
			ob.clickOnEnglishAbilityTestDropdwn();
			ob.enterDataInDuolingoform(list);
			ob.clickOnDoneButtonForDuo();
			log.info("Duolingo details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add finance details functionality")
	@Test(priority = 16)
	public void TC_016_addFinanceDetails() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 9; i++) {
				list.add(ReadUtils.getData("Finance", i, 2));
			}
			ob.clickOnFinanceTab();
			ob.clickOnAddSponsorBtn();
			ob.enterDataInAddSponsorForm(list);
			ob.clickOnDoneButtonToSaveFinanceSponsorDetails();
			log.info("Finance details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add OSHC details functionality")
	@Test(priority = 17)
	public void TC_017_addOSHCDetails() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 3; i++) {
				list.add(ReadUtils.getData("OSHC", i, 2));
			}
			ob.clickOnOSHCTab();
			ob.enterDataForOSHC(list);
			ob.clickOnOSHCSaveBtn();
			log.info("OSHC details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify add employment details functionality")
	@Test(priority = 18)
	public void TC_018_addEmploymentDetails() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 7; i++) {
				list.add(ReadUtils.getData("Employment", i, 2));
			}
			ob.clickOnEmploymentTab();
			ob.clickOnAddEmploymentBtn();
			ob.enterDataInAddEmploymentForm(list);
			ob.clickOnEmploymentSaveBtn();
			log.info("Employment details added successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
