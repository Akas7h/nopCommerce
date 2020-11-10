package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		this.ldriver  = rdriver;
		
		PageFactory.initElements(ldriver,this);
		
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement emailz ;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement password ;
	
	@FindBy(xpath="//*[@value = 'Log in']")
	@CacheLookup
	WebElement logIn ;
	
	@FindBy(linkText ="Logout")
	@CacheLookup
	WebElement logOut ;
	
	public void setEmail(String email) {
		
		emailz.clear();
		emailz.sendKeys(email);	
		
	}
	
public void setPassword(String pasword) {
		
		password.clear();
		password.sendKeys(pasword);	
		
	}

public void clickLogin() {

  logIn.click();
}

public void clickLogOut() {

	  logOut.click();
	}


	
}
