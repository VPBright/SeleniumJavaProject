package Tutorialsninja;

import java.util.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public void verifyRegisterWithMandatoryFields() {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text() ='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Raj");
		driver.findElement (By.id("input-lastname")).sendKeys("Koti");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567891");
		driver.findElement(By.id("input-password")).sendKeys("kot23");
		driver.findElement(By.id("input-confirm")).sendKeys("kot23");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
						
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!" ;
		String actualProperDetailsOne = "Congratualations!Your new account has been successfully created!";
		String actualProperDetailsTwo = " You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "contact us";
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='common-success']//h1")).getText(),expectedHeading);
				
		String expectedProper = driver.findElement(By.id("content")).getText();
		
		//driver.close();
	}

	public String generateNewEmail() {
	return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	}
	
}
