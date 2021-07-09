package org.test.parabank;


import java.awt.Window;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainParaBank extends  BaseParaBank{
    @BeforeClass	
	private void beforeClass() {
		getDriver();
		launchUrl("https://parabank.parasoft.com/parabank/index.htm");
		maximizewindow();
		String title = getTitle();
		System.out.println(title);
		String currentUrl = getCurrentUrl();
		//Assert.assertTrue(currentUrl.contains("ParaBank"), "ParaBank URL is not Matched");
		System.out.println(currentUrl);
	}
	@AfterClass
	private void afterClass() {
		closeBrowser();
	}
	@Test
	private void test1() throws InterruptedException {
		WebElement btnRegisterClick = driver.findElement(By.xpath("//a[@href='register.htm']"));
		btnRegisterClick.click();waitTime(1000);
}
	@Test
	private void test2() throws IOException {
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='customer.firstName']"));
		inserttype(FirstName, getData(0, 0));
		WebElement LastName = driver.findElement(By.xpath("//input[@name='customer.lastName']"));
		inserttype(LastName, getData(1,0));
		WebElement CustomerAddress = driver.findElement(By.xpath("//input[@name='customer.address.street']"));
		inserttype(CustomerAddress,getData(2,0));
		WebElement CustomerCity = driver.findElement(By.xpath("//input[@name='customer.address.city']"));
		inserttype(CustomerCity, getData(3,0));
		WebElement CustomerState = driver.findElement(By.xpath("//input[@name='customer.address.state']"));
		inserttype(CustomerState,getData(4,0));
		WebElement CustomerZipcode = driver.findElement(By.xpath("//input[@name='customer.address.zipCode']"));
		inserttype(CustomerZipcode,getData(5,0));
		WebElement CustomerPhoneNO = driver.findElement(By.xpath("//input[@name='customer.phoneNumber']"));
		inserttype(CustomerPhoneNO, getData(6,0));
		WebElement CustomerSSN = driver.findElement(By.xpath("//input[@name='customer.ssn']"));
		inserttype(CustomerSSN, getData(7,0));
		WebElement cusUserName = driver.findElement(By.xpath("//input[@name='customer.username']"));
		inserttype(cusUserName, getData(0,1));
		WebElement cusPassword = driver.findElement(By.xpath("//input[@name='customer.password']"));
		inserttype(cusPassword, getData(1, 1));
		WebElement cusConformPass = driver.findElement(By.xpath("//input[@name='repeatedPassword']"));
		inserttype(cusConformPass, getData(1,1));
		WebElement btnRegister = driver.findElement(By.xpath("//input[@value='Register']"));
		btnRegister.click();
	}
	@Test
	private void test3() throws InterruptedException, IOException {
		WebElement UserNAme = driver.findElement(By.xpath("//input[@name='username']"));
		inserttype(new PomPara().getTxtUserNAme(), getData(0,1));waitTime(1000);
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		inserttype( new PomPara().getTxtPassword(),getData(1, 1));waitTime(1000);
		WebElement BntLogin = driver.findElement(By.xpath("//input[@value='Log In']"));
		click(new PomPara().getBtnLogin());
		
	}
	@Test
	private void test4() throws InterruptedException {
		WebElement typeOfAcc = driver.findElement(By.xpath("//select[@id='type']"));
		Select s = new Select(typeOfAcc);
		s.selectByIndex(2);waitTime(1000);
		WebElement AccountId = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		Select s1 = new Select(AccountId);
		s1.selectByIndex(1);waitTime(1000);	
	}
	@Test
	private void test5(String loc) throws FileNotFoundException {
		WebElement opened = driver.findElement(By.name("Congratulations, your account is now open."));
		getAttribute(opened, "Value1");
		System.out.println(opened);
		
		WebElement newAccId = driver.findElement(By.xpath("//a[@id='newAccountId']"));
		getAttribute(newAccId, "Value");
		System.out.println(newAccId);
		
		FileOutputStream fo = new FileOutputStream(loc);
		write(fo);
		
	}
	

}