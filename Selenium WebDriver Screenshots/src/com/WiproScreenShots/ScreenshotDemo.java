package com.WiproScreenShots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import utility.Helper;
import zmq.ZError.IOException;

public class ScreenshotDemo {
	
	@Test
	public void testScreenshot() throws InterruptedException, java.io.IOException {
	
	WebDriver  driver = Helper.startBrowser("GC");
	//driver.get("https://www.easycalculation.com/index.php");
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./Screenshots/S1.png");
	
	try
	{
		FileHandler.copy(src, dest);
	} catch (IOException e)
	{
		System.out.println("Something went wrong while copying file " + e.getMessage());
	}
	driver.close();
	
	}
	

}
