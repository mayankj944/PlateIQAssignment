package com.plateIQ.utilities;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.*;

public class BaseScript {

	
	/*
	 * method to initialize chrome browser
	 */
	public static WebDriver InitializeChromeDriver() {
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 
		//WebDriver driver = new ChromeDriver(options);;

		String basepath = System.getProperty("user.dir");
		System.out.println(basepath);
		System.setProperty("webdriver.chrome.driver",basepath +"/BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();

		return driver; 
	}




	/*
	 * method to launch url
	 */

	public static boolean launchURL(WebDriver driver , String url)
	{
		boolean status = false;

		try {

			driver.get(url); 
			status = true; 
		} catch(Exception e)
		{
			System.out.println(e);
		}


		return status; 
	}





}
