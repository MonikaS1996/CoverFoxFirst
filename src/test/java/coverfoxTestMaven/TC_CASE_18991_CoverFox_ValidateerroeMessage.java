package coverfoxTestMaven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

public class TC_CASE_18991_CoverFox_ValidateerroeMessage extends Base {
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

	}

	// gender , next click, age selection, pincode, mobile, next click,
	@BeforeMethod
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		launchBrowser();
		logger = Logger.getLogger("CoverFoxLoggerName");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("opening application");

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

		/*
		 * logger.warn("Enter valid pincode number");
		 * addressDetails.enterPincode(Utility.readDataFromExcel(excelPath, sheetName,0,
		 * 1)); logger.info("entering pincode");
		 * logger.warn("Enter valid mobile number");
		 * addressDetails.enterMobileNumber(Utility.readDataFromExcel(excelPath,
		 * sheetName, 0, 2)); logger.info("entering mobile number");
		 * addressDetails.clickOnContinueButton();
		 * logger.info("clicking on continue button");
		 * logger.error("please check details"); Thread.sleep(3000);
		 */
	}

	@Test(priority = -1)
	public void ValidatePincodeErrorMessage() throws EncryptedDocumentException, IOException, InterruptedException {

		logger.warn("Enter valid mobile number");
		addressDetails.enterMobileNumber(Utility.readDataFromExcel(excelPath, sheetName, 0, 2));
		logger.info("entering mobile number");
		addressDetails.clickOnContinueButton();
		logger.info("clicking on continue button");
		logger.error("please check details");
		Thread.sleep(1000);
		String actualMobResult = addressDetails.pinValidMessage();
		String expectedMobResult = Utility.readDataFromExcel(excelPath, sheetName, 0, 3);
		Assert.assertEquals(actualMobResult, expectedMobResult,
				"Actual result is not matching with expected result, Tc failed");
	}

	@Test(groups = {"MobileNumber"})
	public void ValidateMobileErrorMessage() throws EncryptedDocumentException, IOException, InterruptedException {

		logger.warn("Enter valid pincode number");
		addressDetails.enterPincode(Utility.readDataFromExcel(excelPath, sheetName, 0, 1));
		logger.info("entering pincode");
		addressDetails.clickOnContinueButton();
		logger.info("clicking on continue button");
		logger.error("please check details");
		Thread.sleep(1000);
		String actualPinResult = addressDetails.mobValidMessage();
		String expectedPinResult = Utility.readDataFromExcel(excelPath, sheetName, 1, 3);
		Assert.assertEquals(actualPinResult, expectedPinResult,
				"Actual result is not matching with expected result, Tc failed");
	}

	@AfterMethod
	public void closeApplicstion() {
		logger.info("closing browser");
		
		closeBrowser();
	}
}
