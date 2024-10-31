package coverFoxBaseMaven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverFoxUtility.Utility;

//import coverFoxUtility.Utility;

public class Base {
	//driver
	//URL
	//launch Browser
	//close browser
	
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException {
		ChromeOptions option =  new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromPropertyFile("url"));
		Reporter.log("launching Browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		Reporter.log("Waitingg...", true);
		
	}
	
	public void closeBrowser() {
		Reporter.log("Closing Browser", true);
		driver.quit();
	}
}
