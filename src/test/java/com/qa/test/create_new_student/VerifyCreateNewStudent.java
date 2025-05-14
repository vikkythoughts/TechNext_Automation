package com.qa.test.create_new_student;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ascentone.qa.base.TestBase;

import common.util.ReadUtils;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ascentone.qa.base.TestBase;
import com.ascentone.qa.pages.create_new_student.CreateNewStudent;
import com.ascentone.qa.pages.login.LoginPage;

import common.util.ReadUtils;

public class VerifyCreateNewStudent extends TestBase {

	@BeforeClass
	public void PreRequisite() throws Exception {
		openBrowser();
		enterBaseURL();

	}

	@Test(priority = 1)
	public void loginIntoWebApp() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp();
//			driver.get("http://oca-azure-test:8401/AgentApps/ClientDetails_v2.aspx?rndm=0.9870985101436647&i=30&pn=Easy%20Application&j=1200&prn=Student%20Application&stdid=1255&isAction=0");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void goToAdmissionApplicationPage() throws InterruptedException {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ob.navigateOnAdmissionPage();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void createNewStudent() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 11; i++) {
				list.add(ReadUtils.getData("New_Student", i, 1));
			}
			ob.clickOnNewStudentButton();
			ob.enterDataInNewStudentForm(list);
			ob.clickOnSubmitButton();
			log.info("New Student created successgully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test(priority = 4)
	public void verifyCreatedNewStudentName() {
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

	@Test(priority = 5)
	public void verifyAddFamilyMember() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i <= 9; i++) {
				list.add(ReadUtils.getData("Family_Member", i, 1));
			}
			ob.clickOnAddFamilyMemberButton();
			ob.enterDataInAddFamilyMemberForm(list);
			ob.clickOnDoneButtonForFamilymember();
			log.info("Family Member added successgully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test(priority = 6)
	public void verifyCreatedFamMemberName() {
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

	@Test(priority = 7)
	public void verifyAddAddress() {
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
			log.info("Address added successgully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 8)
	public void verifyAddedAddressName() {
		CreateNewStudent ob = new CreateNewStudent(driver);
		try {
			String ExpAddressName = ReadUtils.getData("Address", 4, 2) +", "+ ReadUtils.getData("Address", 3, 2)
			+", "+ ReadUtils.getData("Address", 2, 2) + ReadUtils.getData("Address", 5, 2)+" - "+ReadUtils.getData("Address", 1, 2);
			String actualAddressName = ob.getAddress(ExpAddressName);
			Assert.assertEquals(actualAddressName, ExpAddressName);
			log.info("Addes Address details is displayed");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 9)
	public void addPassportDetails() {
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
			log.info("Passport details added successgully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
