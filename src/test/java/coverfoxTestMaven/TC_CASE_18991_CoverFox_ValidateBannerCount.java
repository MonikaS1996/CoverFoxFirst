package coverfoxTestMaven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBaseMaven.Base;
import coverFoxUtility.Utility;
import coverfpoxPOMMaven.CoverFoxAddressDetailsPage;
import coverfpoxPOMMaven.CoverFoxHealthPlan;
import coverfpoxPOMMaven.CoverFoxHomePage;
import coverfpoxPOMMaven.CoverFoxMemberDetailaPage;
import coverfpoxPOMMaven.CoverFoxResultPage;



public class TC_CASE_18991_CoverFox_ValidateBannerCount extends Base {
	public static Logger logger;
	
	CoverFoxHomePage homePage;
	CoverFoxHealthPlan healthPlan;
	CoverFoxMemberDetailaPage memberDetails;
	CoverFoxAddressDetailsPage addressDetails;
	CoverFoxResultPage resultPage;

	String excelPath = System.getProperty("user.dir") + "\\DataSheets\\ExcelSheet1.xlsx";
	String sheetName = "Sheet5";

	// open an application
	@BeforeClass
	public void openAppl() throws IOException {
		launchBrowser();
		logger = Logger.getLogger("CoverFoxLoggerName");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("opening application");
	}

	// gender , next click, age selection, pincode, mobile, next click,
	@BeforeMethod
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException  {
		homePage = new CoverFoxHomePage(driver);
		healthPlan = new CoverFoxHealthPlan(driver);
		memberDetails = new CoverFoxMemberDetailaPage(driver);
		addressDetails = new CoverFoxAddressDetailsPage(driver);
		resultPage = new CoverFoxResultPage(driver);

		homePage.clickOnGenderButton();
		logger.info("clicking on gender button");
		Thread.sleep(1000);

		healthPlan.clickOnNextButton();
		logger.info("clicking on next button");
		Thread.sleep(1000);
		
		memberDetails.clickOnnextButton();
		logger.info("Clicking on next button without selecting age...");
		Thread.sleep(1000);
		memberDetails.throwErrorMessage();
		logger.info("priniting error message");
		Thread.sleep(3000);
		
		memberDetails.handleAgeDropDown(Utility.readDataFromExcel(excelPath, sheetName, 0, 0));
		logger.info("handling age dropdown");
		memberDetails.clickOnnextButton();
		logger.info("clciking on next button");
		Thread.sleep(1000);
		
		
		logger.warn("Enter valid pincode number");
		addressDetails.enterPincode(Utility.readDataFromExcel(excelPath, sheetName, 0, 1));
		logger.info("entering pincode");
		logger.warn("Enter valid mobile number");
		addressDetails.enterMobileNumber(Utility.readDataFromExcel(excelPath, sheetName, 0, 2));
		logger.info("entering mobile number");
		addressDetails.clickOnContinueButton();
		logger.info("clicking on continue button");
		logger.error("please check details");
		Thread.sleep(3000);

	}

	@Test
	public void ValidatePolicyCount() {

		int textCount = resultPage.getResultCountFromText();
		int bannerCount = resultPage.getCountFromBanner();
		logger.info("validation result");
		//Assert.fail();
		Assert.assertEquals(textCount, bannerCount, "Text count ad Banner count are not equal, TC Failed");
		
	}

	@AfterClass
	public void closeApplicstion() {
		logger.info("Monika updated");
		logger.info("closing browser");
		closeBrowser();
	}
}
