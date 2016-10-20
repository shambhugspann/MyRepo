package com.project.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class makeMyTripTest {
	@Test
	public void testMakeMyTrip() throws InterruptedException{
		
	//FirefoxDriver driver=new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	//Open the URL
	driver.get("https://www.makemytrip.com/");
	//System.out.println(driver.getCurrentUrl());
	//Click on drop-down button
	driver.findElement(By.xpath("//a[@class='all_menuitem alC']")).click();
	//Clicked on domestic holiday
	//System.out.println("clicked on Domestic holiday");
	driver.findElement(By.xpath("//span[text()='Domestic Holidays']")).click();
	//Switching the child window
	String prntWindow=driver.getWindowHandle();
	Set<String>allWindow=driver.getWindowHandles();
	for(String s:allWindow){
		if(prntWindow.equals(s)==false){
			driver.switchTo().window(s);
		break;
		}
	}
	
	//System.out.println("Window switched");
	//System.out.println(driver.getCurrentUrl());
	//close the top popup
	driver.findElement(By.id("dwnApp_save_closeIcon")).click();
	//click on drop-down
	driver.findElement(By.xpath("(//span[@class='twitter-typeahead'])[1]")).click();
	//System.out.println("drop down clicked");
	
	//select the jaipur state
	List<WebElement> states=driver.findElements(By.xpath("//div[@class='tt-suggestion']/p"));
	int state_size=states.size();
	for(int i=0;i<state_size-1;i++){
		String weStates=states.get(i).getText();
		System.out.println(i);
		if(weStates.equals("Jabalpur")==true)
		{
			//Thread.sleep(10000);
			System.out.println("inside loop "+states.get(i).getText());
			states.get(i).click();
			
		break;
		}
		
	}
//	for(WebElement st:states){
//		String desired_state=st.getText();
//		//System.out.println(desired_state);
//		
//		if(desired_state.equals("Jabalpur")==true)
//		{
//			//Thread.sleep(10000);
//			st.click();
//		break;
//		}
//		
//	}
	//click on search button
	driver.findElement(By.xpath("//a[@id='submit-btn-holiday']")).click();
	
	//System.out.println("search button clicked");
	//click on explore button
	driver.findElement(By.xpath("(//a[text()='Explore'])[1]")).click();
	//System.out.println("Explore clicked");
	//Click on view details button
	driver.findElement(By.xpath("(//a[text()='View Details'])[2]")).click();
	//System.out.println("view details clicked");
	//switching the new child window
	String prntchildWindow=driver.getWindowHandle();
	Set<String>allchildWindows=driver.getWindowHandles();
	String cuurentWindow="https://holidayz.makemytrip.com/holidays/india/package?id=24812&depCityId=3769&intid=inspire_Packageview";
	for(String schild:allchildWindows){
		String desiredURL=driver.switchTo().window(schild).getCurrentUrl();
		
		if(desiredURL.equals(cuurentWindow)==true){	
		break;
		}
	}
	//System.out.println("window switched again");
	//Click on online booking button
	driver.findElement(By.xpath("//p[@class='append_bottomHalf']")).click();
	//System.out.println("booking online button clicked");
	//close the calendar pop-up
	driver.findElement(By.xpath("//a[@class='close_button rateDate_overlay']")).click();
	//System.out.println("pop up closed");
	//close the current window
	driver.close();
	//switch to second child window
	//System.out.println("child window closed");
	driver.switchTo().window(prntchildWindow);
	//window close
	driver.close();
	//System.out.println("prntChild window closed");
	//switch to main window
	driver.switchTo().window(prntWindow);
	driver.findElement(By.xpath("//a[@id='cls_btn']")).click();
	
	System.out.println("Current Url: "+driver.getCurrentUrl());
	
	
	Actions act=new Actions(driver);
	act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).keyDown(Keys.DECIMAL).keyUp(Keys.DELETE).keyUp(Keys.SHIFT).keyUp(Keys.DELETE).build().perform();
	
	
		
	
}
}
