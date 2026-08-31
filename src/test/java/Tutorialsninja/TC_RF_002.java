package Tutorialsninja;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_002 {

	@Test
	
	public void verifyRegisteringAcctWithoutFillFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text() ='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
								
		String expectProperFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectProperLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),expectProperFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),expectProperLastNameWarning);		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),expectEmailWarning);
	    Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectTelephoneWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectPasswordWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@Class='alert alert-danger alert-dismissible']")).getText(),expectPrivacyPolicyWarning);
	    
		driver.quit();
	
	}
}