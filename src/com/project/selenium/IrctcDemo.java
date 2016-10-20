package com.project.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class IrctcDemo {
	WebDriver driver=null;
	
	@Parameters({"browser1", "browser2"})
	@Test
	public void selectBrowser(String browser1, String browser2) throws InterruptedException{
		
		if(browser1.contains("firefox")){
			driver=new FirefoxDriver();
			
			IrctcTest();
		}
		
		if(browser2.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			IrctcTest();
		}
		
	}
	//
	//@Test
	public void IrctcTest() throws InterruptedException{
		//FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf/");
		driver.findElement(By.xpath("//a[text()='Flight Tickets']")).click(); 
		String prnt=driver.getWindowHandle();
		Set<String> allWindow=driver.getWindowHandles();
		for(String s:allWindow){
			if(prnt.equals(s)==false){
				driver.switchTo().window(s);
				break;
			}
		}
		Thread.sleep(5000);
		boolean status=driver.findElement(By.xpath("//input[@value='One way']")).isSelected();
		System.out.println(status);
		Assert.assertTrue(status);
		boolean status1=driver.findElement(By.xpath("//input[@value='Round trip']")).isSelected();
		Assert.assertTrue(!status1);
		driver.findElement(By.id("origin")).sendKeys("Delhi");
		Thread.sleep(1000);
		driver.findElement(By.id("origin")).sendKeys(Keys.TAB);
		driver.findElement(By.id("destination")).sendKeys("bombay");
		Thread.sleep(1000);
		driver.findElement(By.id("destination")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//td[@data-year='2016'  and @data-month='9']/a[text()='30']")).click();
		Select selAdult=new Select(driver.findElement(By.id("noOfAdult")));
		selAdult.selectByIndex(1);
		Select selChild=new Select(driver.findElement(By.id("noOfChild")));
		selChild.selectByIndex(1);
		driver.findElement(By.className("srchbtn")).click();
		WebDriverWait webWait=new WebDriverWait(driver, 10);
		webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='onewayflightinfo']")));
		List<WebElement> allflightList=driver.findElements(By.xpath("//div[@class='onewayflightinfo']"));
		int totalFlight=allflightList.size();
		System.out.println("total number of flights are: "+totalFlight);
		boolean flight=(totalFlight>0 && totalFlight<100);
		System.out.println(flight);
		Assert.assertTrue((totalFlight>0 && totalFlight<100));
		
		driver.close();
		
	}

}
