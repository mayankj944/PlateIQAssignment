package com.plateIQ.plateIQAssignment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.plateIQ.pages.MMT_HomePage;
import com.plateIQ.pages.MMT_Login_Page;
import com.plateIQ.pages.MMT_VerifyMobileNumber;
import com.plateIQ.utilities.BaseScript;

public class LoginTestCase extends BaseScript {

	static WebDriver driver = null;
	static MMT_HomePage mmt_HomePage = new MMT_HomePage(driver);
	static MMT_Login_Page mmt_login_Page = new MMT_Login_Page(driver);
	static MMT_VerifyMobileNumber mmt_verifyMobileNumber = new MMT_VerifyMobileNumber(driver);
	ExtentTest test;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	@BeforeSuite
	public void beforeClass()
	{
		driver = super.InitializeChromeDriver();
		reporter = new ExtentHtmlReporter("report.html");
		extent = new ExtentReports();

		extent.attachReporter(reporter);

		test = extent.createTest("Login test","Sample discription");
		System.out.println("browser launched successfully");
		mmt_HomePage = new MMT_HomePage(driver);
		mmt_login_Page = new MMT_Login_Page(driver);
		mmt_verifyMobileNumber = new MMT_VerifyMobileNumber(driver);

	}

	@BeforeTest
	public void testSetup()
	{
		boolean b = super.launchURL(driver,"https://www.makemytrip.com/");
		mmt_HomePage.clickOnLoginOrCreateAccount();
		test.log(Status.INFO, "Clicked on login");
		System.out.println("Clicked on login button successfully");
		mmt_login_Page.selectPersonalAccount();
	}

	@Test
	public void WorngEmail()
	{



		mmt_login_Page.EnterUserName("test@plateiq");

		// step3 : enter password
		mmt_login_Page.EnterPassword("test@123");

		boolean status = mmt_login_Page.verifyEmailErrorMsg();

		if(status)
		{
			test.pass("verifyEmailErrorMsg successfully");
		}
		else
		{
			test.fail("verifyEmailErrorMsg failed");
		}

	}

	@Test (dependsOnMethods={"WorngEmail"})
	public void correctMobileNo()
	{

		// Step 2 : enter username

		mmt_login_Page.EnterUserName("1234567890");

		// step3 : enter password
		mmt_login_Page.EnterPassword("test@123");

		boolean status = mmt_login_Page.verifyEmailErrorMsg();

		if(status)
		{
			test.pass("verifyEmailErrorMsg successfully");
		}
		else
		{
			test.fail("verifyEmailErrorMsg failed");
		}

	}

	@Test (dependsOnMethods={"correctMobileNo"})
	public void BlankPassword()
	{

		mmt_login_Page.EnterUserName("test@plateiq");

		// step3 : enter password
		mmt_login_Page.EnterPassword("");
		mmt_login_Page.selectremamberme(false);

		mmt_login_Page.verifyEmailErrorMsg();
		boolean status = mmt_login_Page.verifyPasswordErrorMsg();
		if(status)
		{
			test.pass("verifyPasswordErrorMsg successfully");
		}
		else
		{
			test.fail("verifyPasswordErrorMsg failed");
		}
	}

	@Test (dependsOnMethods={"BlankPassword"})
	public void WrongPassword()
	{

		mmt_login_Page.EnterUserName("test@plateiq.com");

		// step3 : enter password
		mmt_login_Page.EnterPassword("jabsjjksbd");
		mmt_login_Page.selectremamberme(false);
		mmt_login_Page.ClickOnLogInButton();

		boolean status = mmt_login_Page.UserNameOrPasswordWrongErrorMsg();
		if(status)
		{
			test.pass("verifyPasswordErrorMsg successfully");
		}
		else
		{
			test.fail("verifyPasswordErrorMsg failed");
		}
	}


	@Test (dependsOnMethods={"WrongPassword"})
	public static void LoginTestCase()
	{

		mmt_login_Page.EnterUserName("test@plateiq.com");

		// step3 : enter password
		mmt_login_Page.EnterPassword("test@123");

		// Step 4 remember me

		mmt_login_Page.selectremamberme(false);

		mmt_login_Page.ClickOnLogInButton();

		// close mobile verification popup

		mmt_verifyMobileNumber.ClickOnCrossPopup();

		System.out.println("pop up closed");


	}

	@AfterSuite
	public void afterClass()
	{
		driver.close();
		driver.quit();
		extent.flush();
	}

}
