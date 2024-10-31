package coverfpoxPOMMaven;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CoverFoxResultPage {

	@FindBy(xpath = "//div[contains(text(),'matching Health Insurance Plans')]") private WebElement resultText;
	@FindBy(css = "div#plans-list") private List<WebElement> planList;
	
	public CoverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getResultCountFromText() {
		Reporter.log("getting count of policy count", true);
		String resultInString = resultText.getText().substring(0,2);
		int countFromText = Integer.parseInt(resultInString);
		return countFromText;
	}
	public int getCountFromBanner() {
		Reporter.log("getting poly count from banner display", true);
		int countFromBanner = planList.size();
		return countFromBanner;
	}
	/*
	public void validateResult() {
		String resultInString = resultText.getText().substring(0,2);
		int resultInInteger = Integer.parseInt(resultInString);
		int planListNumber = planList.size();
		
		if(planListNumber==resultInInteger) {
			System.out.println("Test Case is Passed");
		}
		else {
			System.out.println("Test Case is Failed");
		}
	}*/
}
