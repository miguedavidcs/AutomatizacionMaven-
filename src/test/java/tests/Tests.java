/**
 * 
 */
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Usuario Miguel Castaño
 *
 */
public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/text-box");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void pruebaUno() {
		driver.findElement(By.id("userName")).sendKeys("Miguel");
		driver.findElement(By.id("userEmail")).sendKeys("miguel17@correo.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Donde el Diablo dejo el trinche");
		driver.findElement(By.id("permanentAddress")).sendKeys("Casita de Dios");
		driver.findElement(By.id("submit")).click();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div")).getText().contains("Name:"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
