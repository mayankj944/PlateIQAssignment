package com.plateIQ.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMT_HomePage {

	private static WebDriver driver = null;

	public MMT_HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	/*
	 * Method to click on Login Button
	 *  return true if click successfully
	 */
	public boolean clickOnLoginOrCreateAccount()
	{
		boolean status = false;
		try
		{
			WebElement login = driver.findElement(By.xpath("//p[text()=' Login or Create Account']"));
			login.click();
			status = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}


	/*
	 * Method to select round trip option
	 *  return true if click successfully
	 */
	public boolean selectRoundTripOption()
	{
		boolean status = false;
		try
		{
			WebElement tripOption = driver.findElement(By.xpath("//li[text()='Round Trip']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", tripOption);
			status = true;

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}

	/*
	 * Method to select start city
	 *  return true if click successfully
	 */
	public boolean selectFromCity()
	{
		boolean status = false;
		try
		{
			WebElement fromBox = driver.findElement(By.xpath("//label[@for='fromCity']"));
			fromBox.click();
			WebElement inputbox = driver.findElement(By.xpath("//label[@for='fromCity']//input"));
			inputbox.click();
			inputbox.clear();
			inputbox.sendKeys("goa");
			List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='react-autowhatever-1']//p")));
			for (WebElement element:myList)
			{
				if(element.getText().contains("Goa"));
				{
					element.click();
					status = true;
				}

			}

		}
		catch(Exception e)
		{

		}
		return status;	
	}

	/*
	 * Method to select destination city
	 *  return true if click successfully
	 */
	public boolean selectToCity()
	{
		boolean status = false;
		try
		{
			WebElement fromBox = driver.findElement(By.xpath("//label[@for='toCity']"));
			fromBox.click();
			WebElement inputbox = driver.findElement(By.xpath("//label[@for='toCity']//input"));
			inputbox.clear();
			inputbox.sendKeys("Mumbai");
			List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='react-autowhatever-1']//p")));
			for (WebElement element:myList)
			{
				if(element.getText().contains("Mumbai"));
				{
					element.click();
					status = true;
				}

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}

	/*
	 * Method to select Start date
	 * @params startdate : give date of month
	 * @params startmonth : give month in Mmm format
	 *  return true if click successfully
	 */
	public boolean SelectStartDate(String startdate, String startmonth)
	{
		boolean status = false;
		try
		{
			WebElement depart = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
			depart.click();
			WebElement selectmonthBox = driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']//div[contains(text(),'"+startmonth+"')]/../..//div[@class='dateInnerCell']//p[contains(text(),'"+startdate+"')]"));
			selectmonthBox.click();
			status = true;


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}

	/*
	 * Method to select return date
	 * @params enddate : give date of month
	 * @params endtmonth : give month in Mmm format
	 *  return true if click successfully
	 */
	public boolean SelectReturnDate(String enddate, String endmonth)
	{
		boolean status = false;
		try
		{
			WebElement depart = driver.findElement(By.xpath("//span[text()='RETURN']"));
			depart.click();
			WebElement selectmonthBox = driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']//div[contains(text(),'"+endmonth+"')]/../..//div[@class='dateInnerCell']//p[contains(text(),'"+enddate+"')]"));
			selectmonthBox.click();
			status = true;

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}


	/*
	 * Method to select travellers 
	 * @params adults : count of adults
	 * @params childs : count of childs
	 * @params infants : count of infants
	 *  return true if click successfully
	 */
	public boolean SelectTravellers(String adults, String childs , String infants)
	{
		boolean status = false;
		try
		{
			WebElement travel = driver.findElement(By.xpath("//label[@for='travellers']"));
			travel.click();
			WebElement selectadult = driver.findElement(By.xpath("//p[contains(text(),'ADULT')]/../ul//li[text()='"+adults+"']"));
			selectadult.click();
			WebElement selectchild = driver.findElement(By.xpath("//p[contains(text(),'CHILDREN')]/../ul//li[text()='"+childs+"']"));
			selectchild.click();

			WebElement apply = driver.findElement(By.xpath("//button[text()='APPLY']"));
			apply.click();
			status = true;

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	

	}

	/*
	 * Method to click on flight search button
	 *
	 *  return true if click successfully
	 */
	public boolean clickOnSearchflight()
	{
		boolean status = false;
		try
		{

			WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
			search.click();
			status = true;

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	

	}


	/*
	 * Method to select flight from departure list
	 * @params index : take number of  flight from list
	 *  return true if click successfully
	 */
	public boolean SelectDepartureFlight(int index)
	{

		boolean status = false;
		try
		{

			List <WebElement> departureFlights = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']"));

			departureFlights.get(index-1).click();
			status = true;

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}

	/*
	 * Method to select flight from return list
	 * @params index : take number of  flight from list
	 *  return true if click successfully
	 */
	public boolean SelectReturnFlight(int index)
	{

		boolean status = false;
		try
		{

			List <WebElement> departureFlights = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']"));

			departureFlights.get(index-1).click();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}

	/*
	 * Method to click on book now button
	 * 
	 *  return true if click successfully
	 */
	public boolean ClickOnBookNow()
	{
		boolean status = false;
		try
		{

			WebElement book = driver.findElement(By.xpath("//button[text()=' Book Now ']"));

			book.click();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;	
	}

}
