package org.test.parabank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseParaBank {
	static WebDriver driver;
	
	public static  void getDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prabhu Logesh\\eclipse-workspace\\Banks\\Drive\\geckodriver.exe");
		driver = new FirefoxDriver();	
	}
	public static  void launchUrl(String url) {
		driver.get(url);
	}
	public static  void inserttype(WebElement ele , String value) {
		ele.sendKeys(value);
	}
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}
	public static  void click(WebElement ele) {
		ele.click();
	}
	public static String  getTitle() {
		return driver.getTitle();
	}
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public static String getAttribute(WebElement ele, String s) {
		return ele.getAttribute(s);
	}
	public static  void selectbyvalue(WebElement ele, int value) {
		Select s = new Select(ele);
		s.selectByIndex(value);	
	}
	public static void waitTime(long mills) throws InterruptedException {
		Thread.sleep(mills);
	}
	public static void write(FileOutputStream fo) {
		write(fo);	
	}
	public static void quitBrowser() {
	driver.quit();
	}
	public static  void closeBrowser() {
		driver.close();
	}
	public static  void switchToFrameUsingIdorName(String value) {
		driver.switchTo().frame(value);
	}
	public static  void SwitchToParentWindow() {
		driver.switchTo().defaultContent();
	}
	
	public static String getData(int row,int cell) throws IOException {
		File loc = new File("C:\\Users\\Prabhu Logesh\\eclipse-workspace\\ParaBank\\input\\Parabank.xlsx");
		FileInputStream fi = new FileInputStream(loc);
		FileOutputStream fo = new FileOutputStream(loc);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String stringCellValue = c.getStringCellValue();
		System.out.println(stringCellValue);
		int CellType = c.getCellType();
		String value = null;
		if (CellType==1) {
			c.getStringCellValue();
			System.out.println(value);
		}
		else if (CellType==0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
				value = sim.format(dateCellValue);
			}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
		}
		return null;			
	}
}
