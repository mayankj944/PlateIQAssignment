package com.plateIQ.plateIQAssignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

public class roundTripBooking extends BaseScript{


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
		//	boolean b = super.launchURL(driver,"https://www.makemytrip.com/");
		//	System.out.println("hit MMT url");
		mmt_HomePage = new MMT_HomePage(driver);
		mmt_login_Page = new MMT_Login_Page(driver);
		mmt_verifyMobileNumber = new MMT_VerifyMobileNumber(driver);

	}

	@BeforeTest
	public void testSetup()
	{
		boolean b = super.launchURL(driver,"https://www.makemytrip.com/");

	}

	@Test
	public void roundTripBooking()
	{
		mmt_HomePage.selectRoundTripOption();
		mmt_HomePage.selectFromCity();
		mmt_HomePage.selectToCity();
		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		// get a date to represent "today"
		System.out.println("today:    " + date);
		calendar.setTime(date);

		// add 2 days to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 2);

		Date startDate = calendar.getTime();
		
		// add 1 more day to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date returnDate = calendar.getTime();


		String s1[] = startDate.toString().split(" ");

		for(String str : s1)
		{
			System.out.println(str);
		}
		
		String startdate = s1[2];
		String startmonth = s1[1];


		String s2[] = returnDate.toString().split(" ");
		String endtdate = s2[2];
		String endtmonth = s2[1];

		for(String str : s2)
		{
			System.out.println(str);
		}
		mmt_HomePage.SelectStartDate(startdate, startmonth);
		mmt_HomePage.SelectReturnDate(endtdate, endtmonth);
		mmt_HomePage.SelectTravellers("1", "1", null);
		mmt_HomePage.clickOnSearchflight();
		mmt_HomePage.SelectDepartureFlight(2);
		mmt_HomePage.SelectReturnFlight(2);

	}
	@AfterSuite
	public void afterClass()
	{
		driver.close();
		driver.quit();
		extent.flush();
	}


}
