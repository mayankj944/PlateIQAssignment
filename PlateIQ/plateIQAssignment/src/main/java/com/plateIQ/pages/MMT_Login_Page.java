package com.plateIQ.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MMT_Login_Page {

	private static WebDriver driver = null;

	public MMT_Login_Page(WebDriver driver)
	{
		this.driver = driver;
	}


	/*
	 * method to enter username
	 * return true for successfull entring
	 */
	public boolean EnterUserName(String userName)
	{
		boolean status = false;
		try
		{
			WebElement UserNameTxtBox = driver.findElement(By.xpath("//input[@id='username']"));

			UserNameTxtBox.click();

			UserNameTxtBox.clear();

			UserNameTxtBox.sendKeys(userName);
			status  = true;
			System.out.println("username entered successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}


	/*
	 * method to enter password
	 * return true for successfull entring
	 */

	public boolean EnterPassword(String passWord)
	{
		boolean status = false;
		try
		{
			WebElement passWordTxtBox = driver.findElement(By.xpath("//input[@id='password']"));

			passWordTxtBox.click();

			passWordTxtBox.clear();

			passWordTxtBox.sendKeys(passWord);
			status  = true;
			System.out.println("password entered successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}


	/*
	 * method to select personal account
	 * return true for successfull selecting
	 */
	public boolean selectPersonalAccount()
	{
		boolean status = false;
		try
		{
			WebElement button = driver.findElement(By.xpath("//li[text()=' Personal Account ']"));

			button.click();
			status = true;
			System.out.println("successfully clicked on personal account");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		return status;
	}


	/*
	 * method to select remember me check box
	 * return true for success
	 */
	public boolean selectremamberme(boolean value)
	{
		boolean status = false;

		try
		{
			WebElement button = driver.findElement(By.xpath("//span[contains(@class,'rmCheckBox')]"));


			String checkboxval = button.getAttribute("Class");

			if(!checkboxval.contains("active") && value)
			{
				button.click();
				status = true;
				System.out.println("successfully enabled remember me check box");
			}
			else if(checkboxval.contains("active") && !value)
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", button);
				//button.click();
				status = true;
				System.out.println("successfully disabled remember me check box");
			}
			else if ((!checkboxval.contains("active") && !value) || (checkboxval.contains("active") && value))
			{
				status = true;
				System.out.println("remember me check box is alteady " + value);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return status;				
	}



	/*
	 * method to click on login button
	 * return true for success
	 */
	public boolean ClickOnLogInButton()
	{
		boolean status = false;
		try
		{
			WebElement button = driver.findElement(By.xpath("//button[@class='capText font16']//span[text()='Login']"));
			Thread.sleep(10000);
			button.click();
			status = true;
			System.out.println("successfully clicked on log in button");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		return status;
	}



	/*
	 * method to verify wrong username 
	 * return true for success
	 */
	public boolean verifyEmailErrorMsg()
	{
		boolean status = false;
		try
		{
			WebElement errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Please enter a valid Email Id or Mobile Number.')]"));
			if(errorMsg !=null)
			{
				status = true;
				System.out.println("Error message for email/mobile verified"); 
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		return status;
	}

	/*
	 * method to verify wrong password
	 * return true for success
	 */
	public boolean verifyPasswordErrorMsg()
	{
		boolean status = false;
		try
		{
			WebElement errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Please enter password.')]"));
			if(errorMsg !=null)
			{
				status = true;
				System.out.println("Error message for password verified"); 
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		return status;
	}

	/*
	 * method to verify wrong username/ password msg
	 * return true for success
	 */
	public boolean UserNameOrPasswordWrongErrorMsg()
	{
		boolean status = false;
		try
		{
			WebElement errorMsg = driver.findElement(By.xpath("//span[contains(text(),'Either Username or Password is incorrect.')]"));
			if(errorMsg !=null)
			{
				status = true;
				System.out.println("Error message for either usernamr or password incorrect verified"); 
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		return status;
	}


}
