package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	//screenshot
			//scrolling
			//execleDataReading
			//wait

			public static void takesScreenShot(WebDriver driver, String filename) throws IOException {
				TakesScreenshot src = ((TakesScreenshot)driver);
				File source = src.getScreenshotAs(OutputType.FILE);
				String timespam = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				File Dest = new File(System.getProperty("user.dir")+"\\ScreenShotMaven\\"+filename+"__"+timespam+".png");
				FileHandler.copy(source, Dest);
				}
			
			public static String readDataFromExcel(String excelPath,String sheetname, int RowNum, int CellNum) throws EncryptedDocumentException, IOException {
				FileInputStream myFile = new FileInputStream(excelPath);
				String value = WorkbookFactory.create(myFile).getSheet(sheetname).getRow(RowNum).getCell(CellNum).getStringCellValue();
				return value;
			}

			public static String readDataFromPropertyFile(String key) throws IOException {
				Properties properties = new Properties();
				FileInputStream myFile = new FileInputStream(System.getProperty("user.dir") + "\\configA.properties");
				properties.load(myFile);
				String value = properties.getProperty(key);
				return value;

			}
}
