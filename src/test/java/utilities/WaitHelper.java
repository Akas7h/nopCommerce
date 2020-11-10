package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}  
	
	public void waitForElement(WebElement element,long timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	//wait.until(ExpectedConditions.textToBePresentInElement(element, "text"));
	public void waitForTextElement(WebElement element,long timeOutInSeconds,String text) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.textToBePresentInElement(element,text));		
		
	}
	


}
