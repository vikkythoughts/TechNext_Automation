package com.ascentone.qa.pages.login;

import com.ascentone.qa.base.TestBase;

import common.util.ReadUtils;
import common.util.Utilities;
import io.qameta.allure.Step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends TestBase{
	
private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	@FindBy(id = "emailphone")
	private WebElement emailTxtBox;
	
	@FindBy(xpath = "//button[@onclick='LoadAuthData(this);']")
	private WebElement nextButton1;
	
	@FindBy(id = "txtPwdBasictAuth")
	private WebElement passwordTxtBox;
	
	@FindBy(xpath = "//button[@onclick='SignInByPassword(this)']")
	private WebElement nextButton2;
	
	@FindBy(id = "dvLegalLogoSide1")
	private WebElement AscentOneLogo;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@Step("Typing Email: {0} Step...")
	public void typeEmail(String email) {
		Utilities.type(emailTxtBox, email);
	}

	@Step("Typing Password: {0} Step...")
	public void typePassword(String password) {
		Utilities.type(passwordTxtBox, password);
	}
	
	@Step("Clicking on Login Button Step...")
	public void clickOnNextButton(WebElement nxtBtn) {
		Utilities.waitForElementToBeClickableAndClick(nxtBtn);
		log.info("Clicked on Login button");
	}
	
	@Step("Checking Presence of AscentOne logo")
	public boolean checkPresenceOfProductLogo() {
		return Utilities.getDisplayedStatus(AscentOneLogo);
	}
	
	
	@Step("Login Step with Email and Password...")
	public void loginToApp() throws InterruptedException {
		String email = ReadUtils.getData("Login", 2, 2);
		String password = ReadUtils.getData("Login", 2, 3);
		typeEmail(email);
		clickOnNextButton(nextButton1);
		typePassword(password);
		clickOnNextButton(nextButton2);
		Utilities.waitForPageLoad();
		Thread.sleep(20000);
//		Assert.assertTrue(checkPresenceOfProductLogo());
	}



}
