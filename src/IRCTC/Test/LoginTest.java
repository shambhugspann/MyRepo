package IRCTC.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import IRCTC.Pages.FlightBookingPage;
import IRCTC.Pages.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	@Test
	public void loginTest() throws InterruptedException{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf/");
		LoginPage login=new LoginPage(driver);
		FlightBookingPage flbooking=new FlightBookingPage(driver);
		login.clikFlightTab();
		login.windowHandeling();
		flbooking.selectSource("Delhi");
		flbooking.selectDestination("bombay");
		flbooking.selectDate();
		flbooking.selectAdults(1);
		flbooking.selectChildren(1);
		flbooking.clickSearch();
		Thread.sleep(10000);
		int count=flbooking.flightCount();
		System.out.println(count);
		
	}
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

}
