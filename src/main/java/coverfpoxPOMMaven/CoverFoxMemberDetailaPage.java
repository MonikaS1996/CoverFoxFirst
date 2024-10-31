package coverfpoxPOMMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailaPage {

	
	@FindBy(id = "Age-You") private WebElement ageDropDown;
	@FindBy(xpath = "//div[text()='Next']") private WebElement nextButton;
	@FindBy(xpath = "//div[@class='error-ui']") private WebElement errorMessage;
	public CoverFoxMemberDetailaPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void handleAgeDropDown(String age) {
		Reporter.log("handling age dropdown", true);
		Select s = new Select(ageDropDown);
		s.selectByValue(age+"y");
	}
	
	public void clickOnnextButton() {
		Reporter.log("Clicking on next button", true);
		nextButton.click();
	}
	public void throwErrorMessage() {
		Reporter.log("throwing error message", true);
		String text = errorMessage.getText();
		System.out.println(text);
	}
}
