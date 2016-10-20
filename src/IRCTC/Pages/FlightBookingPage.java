package IRCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingPage {
	WebDriver driver;
	public FlightBookingPage(WebDriver driver){
		this.driver=driver;
	}
	private By radiobutton_Oneway=By.xpath("//input[@value='One way']");
	private By radiobutton_Roundtrip=By.xpath("//input[@value='Round trip']");
	private By source=By.id("origin");
	private By destination=By.id("destination");
	private By calenderclick=By.xpath("//img[@class='ui-datepicker-trigger']");
	private By selectdate=By.xpath("//td[@data-year='2016'  and @data-month='9']/a[text()='30']");
	private By adults=By.id("noOfAdult");
	private By child=By.id("noOfChild");
	private By serachbutton=By.className("srchbtn");
	private By flightcount=By.xpath("//div[@class='onewayflightinfo']");
	
	public boolean onewayRadioButtonStatus(){
		return(driver.findElement(radiobutton_Oneway).isSelected());
	}
	public boolean  rountripradioButtonStatus(){
		return(driver.findElement(radiobutton_Roundtrip).isSelected());
	}
	public void selectSource(String starting){
		driver.findElement(source).sendKeys(starting);
		driver.findElement(source).sendKeys(Keys.TAB);
	}
	public void selectDestination(String ending){
		driver.findElement(destination).sendKeys(ending);
		driver.findElement(source).sendKeys(Keys.TAB);
	}
	public void selectDate(){
		driver.findElement(calenderclick).click();
		driver.findElement(selectdate).click();
	}
	public void selectAdults(int adultCount){
		Select selAdult=new Select(driver.findElement(adults));
		selAdult.selectByIndex(adultCount);
	}
	public void selectChildren(int childCount){
		Select selChild=new Select(driver.findElement(child));
		selChild.selectByIndex(childCount);
	}
	public void clickSearch(){
		driver.findElement(serachbutton).click();
	}
	public int flightCount(){
		return(driver.findElements(flightcount).size());
	}

}
