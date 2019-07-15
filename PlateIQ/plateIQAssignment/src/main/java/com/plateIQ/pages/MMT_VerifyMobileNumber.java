package com.plateIQ.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.plateIQ.utilities.BaseScript;

public class MMT_VerifyMobileNumber {




	private static WebDriver driver = null;

	public MMT_VerifyMobileNumber(WebDriver driver)
	{
		this.driver = driver;
	}


	/*
	 * method to close verify mobile popup
	 * return true for success
	 */
	public boolean ClickOnCrossPopup()
	{
		boolean status = false;
		try
		{

			WebElement button = driver.findElement(By.xpath("//span[@class='crossIcon popupSprite popupCrossIcon']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			executor.executeScript("arguments[0].click();", button);
			status = true;
			System.out.println("successfully closed verify popup");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return status;
	}

}
