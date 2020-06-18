import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class TestWebsite {

	
	public static void main(String Args[])   {

		
		
		TestWebsite Tw = new TestWebsite();
		WebDriver Driver = Tw.LaunchBrowser();
		Tw.setTripDetails(Driver);
		Tw.setSourceLocation(Driver);
		Tw.setDestinationLocation(Driver);
		Tw.setTripDates(Driver);
		Tw.setPassengerDetails(Driver);
		Tw.Search(Driver);
		Tw.validateSearchResults(Driver);
		}
	
	
	



public WebDriver LaunchBrowser() {
	
	String URL = "https://www.phptravels.net/home";
	
System.setProperty("webdriver.opera.driver","C:\\Users\\JAGHRRIT ARORA\\Downloads\\operadriver_win64\\operadriver.exe");
	
	WebDriver Driver = new OperaDriver();
	
	Driver.get(URL);
	Driver.manage().window().maximize();
	return Driver;
}



public void setTripDetails(WebDriver Driver) {
	
	Driver.findElement(By.xpath("//a[contains(@class,'text-center flights')]")).click();
	Driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
	
	 Driver.findElement(By.linkText("Economy")).click();
	Driver.findElement(By.xpath("//li[contains(text(),'Business')]")).click();
	
}


public void setSourceLocation(WebDriver Driver) {
	
	WebElement From = Driver.findElement(By.id("s2id_location_from"));
	From.click();
	Driver.findElement(By.id("location_from")).sendKeys("LAS");
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Driver.findElement(By.xpath("//div[contains(text(),'Vegas (LAS)')]")).click();;
}

public void setDestinationLocation(WebDriver Driver) {
	
	WebElement To = Driver.findElement(By.id("s2id_location_to"));
	To.click();
  	Driver.findElement(By.id("location_to")).sendKeys("LAX");
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Driver.findElement(By.xpath("//div[contains(text(),'Los Angeles (')]")).click();
	
}

public void setTripDates(WebDriver Driver) {
	
	Driver.findElement(By.id("FlightsDateStart")).click();
	Driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	WebElement elementFrom = Driver.findElement(By.xpath("//div[8]//div[1]//div[1]//div[2]//div[26]"));
	 JavascriptExecutor executorFrom = (JavascriptExecutor)Driver;
	 executorFrom.executeScript("arguments[0].click()", elementFrom); 	
	 
	WebElement elementTo = Driver.findElement(By.xpath("//div[9]//nav[1]//div[3]"));
	JavascriptExecutor executorTo = (JavascriptExecutor)Driver;
	 executorTo.executeScript("arguments[0].click()", elementTo);
	elementTo = Driver.findElement(By.xpath("//div[9]//div[1]//div[1]//div[2]//div[7]"));
			executorTo = (JavascriptExecutor)Driver;
	executorTo.executeScript("arguments[0].click()", elementTo);	
	
}


public void setPassengerDetails(WebDriver Driver) {

	Driver.findElement(By.xpath("//div[contains(@class,'row no-gutters mb-15 row-reverse')]//div[contains(@class,'row no-gutters')]//div[1]//div[1]//div[2]//div[1]//span[1]//button[1]")).click();
	Driver.findElement(By.xpath("//div[@id='flights']//div[2]//div[1]//div[2]//div[1]//span[1]//button[1]")).click();
	Driver.findElement(By.xpath("//div[contains(@class,'col-md-4 col-xs-12')]//div[3]//div[1]//div[2]//div[1]//span[1]//button[1]")).click();
	
}

public void Search(WebDriver Driver) {


	Driver.findElement(By.xpath("//div[contains(@class,'row no-gutters mb-15 row-reverse')]//button[contains(@class,'btn-primary btn btn-block')][contains(text(),'Search')]")).click();
	
}

public void validateSearchResults(WebDriver Driver) {
	Driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	if(Driver.getTitle().contains("Flights Results")) {
		System.out.println("Search Results found");
	}
	}
	
}

