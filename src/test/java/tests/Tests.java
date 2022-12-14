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

import helpers.helpers;

/**
 * @author Usuario Miguel Casta?o
 *
 */
public class Tests {
	private WebDriver driver;
	helpers helper= new helpers();
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/text-box");
		helper.sleepSeconds(5);
	}
	@Test
	public void pruebaUno() {
		driver.findElement(By.id("userName")).sendKeys("Miguel");
		driver.findElement(By.id("userEmail")).sendKeys("miguel17@correo.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Donde el Diablo dejo el trinche");
		driver.findElement(By.id("permanentAddress")).sendKeys("Casita de Dios");
		driver.findElement(By.id("submit")).click();
		
		helper.sleepSeconds(4);
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div")).getText().contains("Name:"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
