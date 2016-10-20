package IRCTC.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	private By FlightTab=By.xpath("//a[text()='Flight Tickets']");
	
	public void clikFlightTab(){
		driver.findElement(FlightTab).click();
	}
	public void windowHandeling(){
		String prnt=driver.getWindowHandle();
		Set<String> allWindow=driver.getWindowHandles();
		for(String s:allWindow){
			if(prnt.equals(s)==false){
				driver.switchTo().window(s);
				break;
			}
		}
	}

}
