package com.WiproScreenShots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.Helper;
import utility.Reusability;

public class ScreenshotDemo2 {
	
	WebDriver driver;
	
	@Test
	public void browser()
	{
		driver = Helper.startBrowser("chrome");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Gmail11')]")).click();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			Reusability.capturedScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
