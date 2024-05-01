package groupproject;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class TestCases {
	static WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("localhost:8080/groupproject");

		
	}
	
	@Test
	void testLogin() throws InterruptedException {
		WebElement user = driver.findElement(By.name("username"));
		WebElement pword = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.id("submitButton"));

		user.sendKeys("asdf");
		pword.sendKeys("word");
		submit.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		Assert.assertEquals(txt, "Bad login! Please try again.");
		alert.dismiss();
		Thread.sleep(1000);
		
		//driver.switchTo().defaultContent();
		user = driver.findElement(By.name("username"));
		pword = driver.findElement(By.name("password"));
		submit = driver.findElement(By.id("submitButton"));
		user.sendKeys("user1");
		pword.sendKeys("password");
		submit.click();
		String url = driver.getCurrentUrl();
		System.out.print(url);
		Assert.assertEquals(url, "http://localhost:8080/groupproject/displayTable.jsp?userid=8");
		driver.quit();
	}
	@Test
	void testRegister() throws InterruptedException {
		WebElement newUser = driver.findElement(By.id("newUser"));
		newUser.click();
		WebElement uname = driver.findElement(By.id("uname"));
		WebElement pword = driver.findElement(By.id("password"));
		WebElement cpword = driver.findElement(By.id("cpassword"));
		WebElement phone = driver.findElement(By.id("phone"));
		WebElement submit = driver.findElement(By.id("submitButton"));
		
		uname.sendKeys("bobby");
		pword.sendKeys("word55");
		cpword.sendKeys("word255");
		phone.sendKeys("8675309");
		submit.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		Assert.assertEquals(txt, "Passwords do not match");
		alert.dismiss();
		driver.quit();
		
		
	}
	@Test
	void testTable() throws InterruptedException{
		WebElement user = driver.findElement(By.id("username"));
		WebElement pword = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.id("submitButton"));
		user.sendKeys("user1");
		pword.sendKeys("password");
		submit.click();
		Thread.sleep(1000);
		WebElement table = driver.findElement(By.cssSelector("label[for='table1']"));
		WebElement day = driver.findElement(By.cssSelector("label[for='monday']"));
		WebElement hour = driver.findElement(By.cssSelector("label[for='0500']"));
		WebElement btn = driver.findElement(By.id("submitButton"));
		
		table.click();
		day.click();
		hour.click();
		btn.click();
		Thread.sleep(2000);
		
		String txt = driver.findElement(By.id("messageContainer")).getText();
		Assert.assertEquals(txt, "Reservation is already filled!");
		driver.quit();
		
	}

}
