package coverfpoxPOMMaven;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
	// Variable declartion
	@FindBy(xpath = "(//input[@type = 'number'])[1]")
	private WebElement pincode;

	@FindBy(xpath = "(//input[@type = 'number'])[2]")
	private WebElement mobNumber;

	@FindBy(className = "next-btn")
	private WebElement continueButton;

	@FindBy(xpath = "//div[text()=' Please enter a valid mobile no. '] ")
	private WebElement mobValidMessage;

	@FindBy(xpath = "//div[text()=' Please enter a valid pincode '] ")
	private WebElement pinValidMessage;

	// Constructor to initialize data member
	public CoverFoxAddressDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void enterPincode(String pin) {
		Reporter.log("enter the pincode", true);
		pincode.sendKeys(pin);
	}

	public void enterMobileNumber(String monNumber) {
		Reporter.log("entering mobile number", true);
		mobNumber.sendKeys(monNumber);
	}

	public void clickOnContinueButton() {
		Reporter.log("Clicking on continue button", true);
		continueButton.click();
	}

	public String mobValidMessage() {

		String actualText = mobValidMessage.getText();
		return actualText;

	}

	public String pinValidMessage() {

		String actualText = pinValidMessage.getText();
		return actualText;

	}
}
