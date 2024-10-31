package coverfpoxPOMMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlan {

	//Variable declaration
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	//constructor -> variable initialization
	public CoverFoxHealthPlan(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNextButton() {
		Reporter.log("Click on next button", true);
		nextButton.click();
	}
}
