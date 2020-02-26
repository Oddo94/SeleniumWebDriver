import java.util.ArrayList;

import org.junit.Test;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MadisonHomePageTest {
	 @Test
	public void HomePageTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://qa3.dev.evozon.com/");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		System.out.println(title);
		WebElement logo = driver.findElement(By.cssSelector("#header > div > a"));
		logo.click();

		driver.get("http://qa3.dev.evozon.com/men/shirts.html");
		driver.get("http://qa3.dev.evozon.com/");

		driver.navigate().refresh();
		driver.quit();

	}
	 @Test
	public void AccountTest() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://qa3.dev.evozon.com/");

		WebElement account = driver
				.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));

		WebElement myAccount = driver.findElement(By.cssSelector("#header-account > div > ul > li.first"));

		account.click();
		myAccount.click();
		driver.quit();

	}
	
    @Test
	public void LanguagesTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://qa3.dev.evozon.com/");
		
		WebElement languageDropDown = driver.findElement(By.cssSelector("#select-language"));
		Select selectObject = new Select(languageDropDown);
	
		selectObject.selectByIndex(1);
		
		driver.quit();
	}
    
    @Test
    public void SearchTest() {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");
    	
    	WebDriver driver = new ChromeDriver();
		driver.get("http://qa3.dev.evozon.com/");

    	
    	WebElement searchBox = driver.findElement(By.cssSelector("#search"));
    	searchBox.clear();
    	searchBox.sendKeys("woman");
    	
    	WebElement searchButton = driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
    	
    	searchButton.click();
    	driver.quit();
    		
    }
	
    @Test
    public void ProductsListTest() {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");
    	
    	WebDriver driver = new ChromeDriver();
		driver.get("http://qa2.dev.evozon.com/");
    	
		/*WebElement menSection = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.active.parent > a"));
		
		 menSection.click();*/
		
		
		
		List<WebElement> newArrivals = driver.findElements(By.cssSelector(".item.last"));
		
		Iterator<WebElement> iter =  newArrivals.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next().getText() + "\n" + "\n");
		}
		
		driver.quit();
			
    }
	
    @Test
    public void MenuList() {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");
    	
    	WebDriver driver = new ChromeDriver();
		driver.get("http://qa2.dev.evozon.com/");
		
		List<WebElement> menuList = driver.findElements(By.cssSelector(".level0.parent"));
		
		Iterator<WebElement> iter = menuList.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next().getText() + "\n");	
		}
		
		/*for(WebElement element : menuList) {
			System.out.println(element.getText() + "\n");
			
		}*/
		
		driver.quit();
    	
    }
	
}
