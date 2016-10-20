package com.project.selenium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
@Test
public class GoogleDemo {
	public void GoogleTest() throws IOException, InterruptedException{
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("pakistan");
		driver.findElement(By.xpath("//div[@id='sblsbb']")).click();
		Thread.sleep(5000);
		//Git
		//Random rndmNumber=new Random(); 
		//int num=rndmNumber.nextInt();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date=new Date();
		String num=dateFormat.format(date);
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//System.out.println("abc"+num);
		FileUtils.copyFile(file, new File("F:\\abc_"+num+ ".png"));
		
		System.out.println("screenshot taken");
	}

}
