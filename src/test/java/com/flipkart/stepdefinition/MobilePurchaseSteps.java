package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps {
	static WebDriver driver;
	
	@Given("User launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("User login into flipkart")
	public void user_login_into_flipkart() {
		WebElement closeIcon = driver.findElement(By.xpath("//button[text()='✕']"));
		closeIcon.click();
	   
	}

	@When("User search mobile")
	public void user_search_mobile() throws InterruptedException {
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("realme");
		Thread.sleep(1000);
		WebElement searchIcon = driver.findElement(By.xpath("//button[@type='submit']"));
		searchIcon.click();
		WebElement realme = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[1]"));
		realme.click();
		Thread.sleep(1000);
		WebElement newTab = driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
		System.out.println(newTab.getText());
		Thread.sleep(1000);
	}

	@When("User choose the mobile and doing payments")
	public void user_choose_the_mobile_and_doing_payments() throws InterruptedException {
		String parentURL = driver.getWindowHandle();
		Set<String> allURL = driver.getWindowHandles();
		for (String url : allURL) {
			if(!url.equals(parentURL));
			driver.switchTo().window(url);
			Thread.sleep(1000);
			System.out.println("window switched");
		}
	
	}
	@Then("User receive order confirmation message")
	public void user_receive_order_confirmation_message() throws Exception {
		Thread.sleep(1000);
		System.out.println("drop down & screenshot");
	    WebElement buy = driver.findElement(By.xpath("//div[contains(text(),'Buy without Exchange')]"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", buy);
	    String text = buy.getText();
	    Assert.assertEquals("Buy without Exchange", text);
	    
	    driver.quit();
	}

	@When("User search mobile by using one dim list")
	public void user_search_mobile_by_using_one_dim_list(DataTable dataTable) throws Exception {
		
		Actions a = new Actions(driver);		
		List<String> asList = dataTable.asList();
	    WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys(asList.get(0),Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement move = driver.findElement(By.xpath("//img[@alt='Flipkart']"));
		a.moveToElement(move).build().perform();
		Thread.sleep(1000);
		
		WebElement MobileName = driver.findElement(By.xpath("(//div[contains(text(),'"+asList.get(0)+"')])[2]"));
		String fn = MobileName.getText();
		MobileName.click();
		
		}
	
	@When("User search mobile by using one dim map")
	public void user_search_mobile_by_using_one_dim_map(io.cucumber.datatable.DataTable dataTable) throws Exception {
		
		Actions a = new Actions(driver);
	    Map<String, String> asMap = dataTable.asMap(String.class, String.class);
	    WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys(asMap.get("phone1"),Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement move = driver.findElement(By.xpath("//img[@alt='Flipkart']"));
		a.moveToElement(move).build().perform();
		Thread.sleep(1000);
		
		WebElement MobileName = driver.findElement(By.xpath("(//div[contains(text(),'"+asMap.get("phone1")+"')])[2]"));
		String fn = MobileName.getText();
		MobileName.click();
	}
	
	@When("User search mobile {string}")
	public void user_search_mobile(String names) throws Exception {
		
		Actions a = new Actions(driver);
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys(names,Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement move = driver.findElement(By.xpath("//img[@alt='Flipkart']"));
		a.moveToElement(move).build().perform();
		Thread.sleep(1000);
			
		WebElement MobileName = driver.findElement(By.xpath("(//div[contains(text(),'"+names+"')])[2]"));
		String fn = MobileName.getText();
		MobileName.click();
	}
	
}