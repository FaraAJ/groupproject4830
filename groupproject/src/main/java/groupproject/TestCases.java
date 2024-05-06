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
		driver.get("http://unoblob.ddns.net:8080/groupproject");

		
	}
	
	@Test
	void testBadLogin() throws InterruptedException {
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
		driver.quit();
	}
	@Test
	void testGoodLogin() throws InterruptedException{
		WebElement user = driver.findElement(By.name("username"));
		WebElement pword = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.id("submitButton"));
		user.sendKeys("user1");
		pword.sendKeys("password");
		submit.click();
		String url = driver.getCurrentUrl();
		//System.out.print(url);
		Assert.assertEquals(url, "http://unoblob.ddns.net:8080/groupproject/displayTable.jsp?userid=8");
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
		Thread.sleep(1000);
		
		uname = driver.findElement(By.id("uname"));
		pword = driver.findElement(By.id("password"));
		cpword = driver.findElement(By.id("cpassword"));
		phone = driver.findElement(By.id("phone"));
		submit = driver.findElement(By.id("submitButton"));
		
		uname.clear();
		pword.clear();
		cpword.clear();
		phone.clear();
		
		uname.sendKeys("bobby");
		pword.sendKeys("password");
		cpword.sendKeys("password");
		phone.sendKeys("5558675309");
		submit.click();
		Thread.sleep(1000);
		txt = alert.getText();
		Assert.assertEquals(txt, "Account successfully made, you may now log in.");
		alert.dismiss();
		Thread.sleep(1000);
		
		uname = driver.findElement(By.name("username"));
		pword = driver.findElement(By.name("password"));
		submit = driver.findElement(By.id("submitButton"));
		uname.sendKeys("bobby");
		pword.sendKeys("password");
		submit.click();
		Thread.sleep(1000);
		
		txt = driver.getCurrentUrl();
		txt = txt.split("\\?")[0];
		Assert.assertEquals(txt, "http://unoblob.ddns.net:8080/groupproject/displayTable.jsp");
		

		
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
	
	@Test
	void testAdmin() throws InterruptedException{
		WebElement user = driver.findElement(By.id("username"));
		WebElement pword = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.id("submitButton"));
		user.sendKeys("admin");
		pword.sendKeys("password");
		submit.click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://http://unoblob.ddns.net:8080/groupproject/Admin.jsp");
		
		WebElement table = driver.findElement(By.id("AdminTable"));
		table.click();
		Thread.sleep(1000);
		
		WebElement btn = driver.findElement(By.id("TableEdit0"));
		btn.click();
		Thread.sleep(1000);
		
		WebElement time = driver.findElement(By.id("four"));
		time.sendKeys("3");
		btn = driver.findElement(By.id("submitButton"));
		btn.click(); 
		
		
		driver.quit();
	}

}
