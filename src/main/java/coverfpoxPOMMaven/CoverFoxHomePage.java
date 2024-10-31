
package coverfpoxPOMMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	//Variable declaration -> WebElement

	@FindBy(xpath = "//div[text()='Male']")	private WebElement gender;
	
	//constructor --> variable initialize
	public CoverFoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);//this for multiple web element
	}
	
	public void clickOnGenderButton() {
		Reporter.log("clicking on gender button", true);
		gender.click();
	}
}
