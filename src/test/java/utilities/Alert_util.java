package utilities;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Alert_util {
      public static WebDriver adriver ;
      
      
	public static boolean isAlertPresent(WebDriver driver) {
		try {
			adriver = driver ;
	    adriver.switchTo().alert();
	    return true;
	    
	    }catch (NoAlertPresentException ex) {
			return false;
		}
		
	    }   
		
	
}
