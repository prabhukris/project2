package org.test.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomPara extends BaseParaBank {
	public  PomPara() {
			PageFactory.initElements(driver,this);
	}
	@FindBy(name="username")
	private WebElement txtUserNAme;
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnLogin;

	public WebElement getTxtUserNAme() {
		return txtUserNAme;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
}





