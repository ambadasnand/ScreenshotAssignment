package com.WiproScreenShots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.Helper;
import utility.Reusability;

public class ScreenshotAssignment {
	
WebDriver driver;
	
	@Test
	public void testscreeshot() throws InterruptedException
	{
		driver = Helper.startBrowser("chrome");
		driver.get("https://www.hollandandbarrett.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"data-cs-mask-account\"]/button/div/img")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("username")).sendKeys("raghu.astepahead@gmail.com");
		driver.findElement(By.id("password")).sendKeys("raghuBN@123");
		
		
		driver.findElement(By.xpath("/html/body/main/section/div/div/div/form/div[3]/button")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"data-cs-mask-rewards\"]/a/div/img")).click();
		Assert.assertEquals("asn", "asnm");
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			Reusability.capturedScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
