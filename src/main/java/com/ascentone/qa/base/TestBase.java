package com.ascentone.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;   
import org.junit.AfterClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ascentone.qa.pages.home.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import common.util.ReadUtils;
import common.util.Utilities;


public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	protected static final Logger log = Logger.getLogger(TestBase.class);
	
	
	// This function is used to open the browser based on passing browser parameter name
	public void openBrowser() {
		selectBrowser("chrome");
		log.info("Browser opened successfully.");	
	}
	
	// This function is used to enter the base URL in browser based on mentioned URL
		// sheet in test data excel file
		public void enterBaseURL() throws Exception {
			String baseURL = HomePage.baseURL();
			enterUrl(baseURL);
		}

	// This function is used to print the operating system with browser name and its version
	public void getBrowserOS() {

		Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();

		String browserName = capabilities.getBrowserName();
		String browserVersion = capabilities.getBrowserVersion();
		String osName = System.getProperty("os.name").toLowerCase();
		
		log.info("Operaing System: " + osName + ", Browser Name and Version: " + browserName + " " + browserVersion);

	}

	public void selectBrowser(String browser) {

		if (System.getProperty("os.name").contains("Window")) {

			if (browser.equals("chrome")) {

				// This used to configure chrome's settings to disable the image loading during automated browser session
				// It can lead to faster page load times and improved test execution speed.

				HashMap<String, Object> images = new HashMap<String, Object>();
				images.put("images", 2);

				HashMap<String, Object> pref = new HashMap<String, Object>();
				pref.put("profile.default_content_setting_values", images);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

				options.addArguments("--disable-extensions");
				options.addArguments("incognito");
				options.addArguments("ignore-certificate-errors");
//				options.addArguments("--headless");

				driver = new ChromeDriver(options);

				getBrowserOS();

			} else if (browser.equals("firefox")) {

				driver = new FirefoxDriver();
			}

		}

		else if (System.getProperty("os.name").contains("Linux")) {

			if (browser.equals("chrome")) {

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.addArguments("--disable-extensions");
				options.addArguments("incognito");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("disable-infobars");
				options.addArguments("ignore-certificate-errors");
				options.addArguments("--headless");

				driver = new ChromeDriver(options);
			} else if (browser.equals("firefox")) {

				driver = new FirefoxDriver();
			}
		}
	}
	
	// This function used to load the both config.properties and log4j.properties
		// files
		public void propertiesFile() throws IOException {
			prop = new Properties();
			try {
				FileInputStream filePath = new FileInputStream(Utilities.dir() + ReadUtils.getData("Path", 1, 2));
				prop.load(filePath);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	// This function is used to enter the URL in browser
		public void enterUrl(String baseURL) {
			Dimension setBrowserSize = new Dimension(1366, 768);
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().setSize(setBrowserSize);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(baseURL);
			log.info("Entered URL: " + baseURL + "\n");

		}

		// This function is used to print the log into extent report file
		public static void logger(String data) {
			log.info(data);
			Reporter.log(data);
			test.log(Status.INFO, data);
		}

		// This function is used to delete all cookies
		public static void deleteAllCookies() {
			driver.manage().deleteAllCookies();
		}

		// This function is used run the allure result command
		public static void allureResultCommand() throws IOException, InterruptedException {
			String path = Utilities.dir() + "/allure-results";
			String[] cmd = { "allure", "serve", "" + path };
			Runtime.getRuntime().exec(cmd);
			Thread.sleep(10000);
		}

		// This function is used run the allureReort.bat file
		public static void runBatFile(String path) throws IOException {
			ProcessBuilder processBuilder = new ProcessBuilder(path).inheritIO();
			processBuilder.start();
		}
		
		// This function is used to generate the extent report
				@BeforeSuite
				public void startExtentReport() throws InterruptedException, IOException {

					// Delete folders before execute test scripts.
					Utilities.deleteFolder("allure-results");
					Utilities.deleteFolder("test-output");

					// Add html reporter to extent report
					 ExtentSparkReporter spark = new ExtentSparkReporter(Utilities.dir() + ReadUtils.getData("Path", 6, 2));
					extent = new ExtentReports();
					extent.attachReporter(spark);
					spark.config().setDocumentTitle(ReadUtils.getData("Report", 1, 2));
					spark.config().setReportName(ReadUtils.getData("Report", 2, 2));
					spark.config().setTheme(Theme.DARK);

					// Add system info in extent report
					extent.setSystemInfo("Application Name", ReadUtils.getData("Report", 3, 2));
					extent.setSystemInfo("Username", ReadUtils.getData("Report", 4, 2));
					extent.setSystemInfo("Envirnoment", ReadUtils.getData("Report", 5, 2));
					extent.setSystemInfo("Application URL", ReadUtils.getData("URL", 1, 2));

					// Set Properties files
					propertiesFile();
					
				}
				
				// This function used to print like starting the method name into both log and
				// extent report files
				@BeforeMethod
				public void beforeTestResult(Method method) {

					log.info("===== Starting " + method.getName() + "() Test =====");
					test = extent.createTest(method.getName());
					test.log(Status.INFO,
							MarkupHelper.createLabel(method.getName() + " - Test Script Started... ", ExtentColor.WHITE));

				}
		
		// This function used to print like ending the method name into both log and
		// extent report files with method test result
		@AfterMethod
		public void afterTestResult(ITestResult iTestResult) throws Exception {

			if (iTestResult.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(iTestResult.getName() + " - Test Failed... ", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(" - Exception... " + iTestResult.getThrowable(), ExtentColor.RED));

				String screenshot = Utilities.getScreenShot(iTestResult.getName());
				test.addScreenCaptureFromPath(screenshot);

			} else if (iTestResult.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP,
						MarkupHelper.createLabel(iTestResult.getName() + " - Test Skipped... ", ExtentColor.ORANGE));

			} else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS,
						MarkupHelper.createLabel(iTestResult.getName() + " - Test Passed... ", ExtentColor.GREEN));

			}
			test.log(Status.INFO,
					MarkupHelper.createLabel(iTestResult.getName() + " - Test Script Finished... ", ExtentColor.WHITE));

			log.info("===== Ending " + iTestResult.getName() + "() Test =====\n");
		}
		
		// This function used to close the browser
		@AfterClass
		public void closeBrowser() throws InterruptedException {

			if (driver != null) {
				driver.quit();
			}
			log.info("Browser closed successfully. \n");

		}

		// This function used to close the extent report
		@AfterSuite
		public void endExtentReport() throws InterruptedException, IOException {

			extent.flush();
			if (driver != null) {
				driver.quit();
			}
			gererateAllureReport();
		}

		// This function used to generate allure report if its run on window operating
		// system
		public void gererateAllureReport() throws IOException {

			if (System.getProperty("os.name").contains("Window")) {
				runBatFile(Utilities.dir() + ReadUtils.getData("Path", 7, 2));
			}
		}

}
