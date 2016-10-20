package com.project.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumDemoTest {

	@Test
	public void testGoogle() throws InterruptedException {
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.macys.com/");
		//Close the new open div
		driver.findElement(By.id("closeButton")).click();
		//Enter text in search box
		driver.findElement(By.id("globalSearchInputField")).sendKeys("jeans");
		//Click on serach button
		driver.findElement(By.id("subnavSearchSubmit")).submit();
		//fetching the data
		System.out.println("Title is: "+driver.getTitle());
		System.out.println("URL is: "+driver.getCurrentUrl());
		//click on first item
		driver.findElement(By.xpath("(//a[@name='p2787538'])[1]")).click();
		//click on item size
		driver.findElement(By.xpath("//li[@title='2']")).click();
		//click on add to beg button
		driver.findElement(By.id("addToBagButton2351352")).click();
		//Click on checkout button
		driver.findElement(By.id("btnCheckout")).click();
		//Click on remove button
		driver.findElement(By.xpath("//div[contains(@id,'remove_item_36299231')]")).click();
		//Fetching the text
		String removed=driver.findElement(By.xpath("//div[text()='Removed from bag']")).getText();
		System.out.println("removed text is: "+removed);
		//Select sel=new Select(driver.findElement(By.id("closeButton")));
		//sel.getFirstSelectedOption();
		//Close the driver
		driver.close();

	}

}
