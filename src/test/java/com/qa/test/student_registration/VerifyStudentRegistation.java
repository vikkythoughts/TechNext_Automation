package com.qa.test.student_registration;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ascentone.qa.base.TestBase;
import com.ascentone.qa.pages.register_student.StudentRegistration;

import common.util.ReadUtils;
import io.qameta.allure.Description;

public class VerifyStudentRegistation extends TestBase {

	@BeforeClass
	public void PreRequisite() throws Exception {
		openBrowser();
		enterBaseURL();

	}

	@Description("Verify the new Student Registration functionality.")
	@Test(priority = 1, enabled = true)
	public void TC_001_verifyStudentRegistration() throws InterruptedException {
		StudentRegistration sr = new StudentRegistration(driver);
		try {
			sr.clickOnRegistorButton();
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i <= 16; i++) {

				list.add(ReadUtils.getData("Student_Registration", i, 2));
			}
			sr.enterDataInRegistrationForm(list);
			log.info("Student Register successgully");

		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify the new Student email verification using verification code.")
	@Test(priority = 2, enabled = true)
	public void TC_002_verifyStudentEmail() throws InterruptedException {
		StudentRegistration sr = new StudentRegistration(driver);

		try {
			String yopMailUrl = ReadUtils.getData("Student_Registration", 20, 2);
			String stuEmail = ReadUtils.getData("Student_Registration", 10, 2);
			sr.getVerificationCodeAndVerify(yopMailUrl, stuEmail);
			log.info("Student email successfully verified");

		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify Login functionality after verify the email of new register student")
	@Test(priority = 3, enabled = true)
	public void TC_003_loginByRegisterStudent() throws InterruptedException {
		StudentRegistration sr = new StudentRegistration(driver);

		try {
			sr.enterPasswordForLogin(ReadUtils.getData("Student_Registration", 15, 2));
			sr.clickOnLoginButton();
			log.info("Registered student login successfully");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Description("Verify Registered student name after login on student profile page")
	@Test(priority = 4, enabled = true)
	public void TC_004_verifyStudentNameAfterLogin() {
		StudentRegistration sr = new StudentRegistration(driver);

		try {

			String actualStuName = sr.verifyStudentName();
			String ExpStuName = ReadUtils.getData("Student_Registration", 1, 2) + " "
					+ ReadUtils.getData("Student_Registration", 2, 2);
			Assert.assertEquals(actualStuName, ExpStuName);
			log.info("Student Name is displayed on student profile page");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
