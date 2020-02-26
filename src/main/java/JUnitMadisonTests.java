import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

public class JUnitMadisonTests {
	WebDriver driver;
	
	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\razvanodenie\\eclipse-workspace\\SeleniumWebdriverProj\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://qa2.dev.evozon.com/");

		
	}
	
	@Ignore
	public void  titleTest() {
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String actualTitle = driver.getTitle();
		String expectedTitle ="Madison Island"; 
		//System.out.println(title);
	    Assert.assertTrue(actualTitle.equals(expectedTitle));
		
		
		
		/*WebElement logo = driver.findElement(By.cssSelector("#header > div > a"));
		logo.click();

		driver.get("http://qa3.dev.evozon.com/men/shirts.html");
		driver.get("http://qa3.dev.evozon.com/");

		driver.navigate().refresh();*/
		

	}
	
	@Ignore
	public void urlTest() {
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "http://qa2.dev.evozon.com/";
		
		Assert.assertTrue(actualURL.equals(expectedURL));
	}
	
	@Ignore
	public void checkHomePage() {
		WebElement uniqueHomePageElement = driver.findElement(By.cssSelector(".widget-title>h2"));
		boolean visible = uniqueHomePageElement.isDisplayed();
		Assert.assertTrue(visible);
			
	}
	
	
	@Ignore
	public void checkDropDownMenu() {
		String accountSection = "#header > div > div.skip-links > div > a > span.label";
		WebElement account = driver.findElement(By.cssSelector(accountSection));
		account.click();
		
		String dropDownMenuList = "#header-account > div > ul";
		WebElement dropDownMenu = driver.findElement(By.cssSelector(dropDownMenuList));
		boolean visibleList = dropDownMenu.isDisplayed();
		Assert.assertTrue(visibleList);
	}
	
	@Ignore
	public void checkAccountText() {
		String accountText = "#header > div > div.skip-links > div > a > span.label";
		WebElement account = driver.findElement(By.cssSelector(accountText));
		account.click();
		
		String accountSection = "#header-account li";
		
		List<WebElement> accountMenuOptions = driver.findElements(By.cssSelector(accountSection));
		String expectedResult = "My Account";
	
		boolean wasFound = false;
		
		for(WebElement option : accountMenuOptions) {
			if(option.getText().contentEquals(expectedResult)){  
				wasFound = true;
				break;
				
			}
			
		}
		
	   
		Assert.assertEquals(wasFound, true);
			
	}
	
	
	
	@Ignore
	public void checkNumberOfLanguageOptions() {
	    Select languageOption = new Select(driver.findElement(By.cssSelector("#select-language")));

        List<WebElement> elementCount = languageOption.getOptions();
		int actualLanguages = elementCount.size();
		int expectedLanguages = 3;
		
      
		Assert.assertTrue(actualLanguages == expectedLanguages);	
	}
	
	@Ignore
	public void checkSelectNextLanguageOption() {
	    Select languageOption = new Select(driver.findElement(By.cssSelector("#select-language")));

        List<WebElement> elementCount = languageOption.getOptions();
	
        boolean isSelected = false;
		for(int i = 0; i < elementCount.size(); i++) {
			if(elementCount.get(i).isSelected()) {
				isSelected = true;
			}
			
			if(isSelected) {
				i++;
				elementCount.get(i).click();
				break;	
			}
			
		}
     	
	}
	
	
	
    @Ignore
	public void checkSearchResultTitle() {
    	String searchTerm = "woman";
		WebElement searchBox = driver.findElement(By.cssSelector("#search"));
    	searchBox.clear();
    	searchBox.sendKeys(searchTerm);
    	
    	WebElement searchButton = driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
    	searchButton.click();
    	
    	String searchResultText = ".page-title>h1";
        WebElement searchMessage = driver.findElement(By.cssSelector(searchResultText));
        
        
        Assert.assertTrue(searchMessage.getText().toLowerCase().contains(searchTerm));
       	
	}
    
    @Ignore
    public void checkWebsiteNavigation() {
    	String searchedMenuItem = "Sale";
    	List<WebElement> menuList = driver.findElements(By.cssSelector(".level0.parent"));
    	
    	for(WebElement menuItem : menuList) {
    		if(menuItem.getText().equalsIgnoreCase(searchedMenuItem)) {
    			menuItem.click();
    			break;
    		}
    	}
    	String actualURL = driver.getCurrentUrl(); 
    	String expectedURL = "http://qa2.dev.evozon.com/sale.html";
    	
    	Assert.assertTrue(actualURL.equals(expectedURL));
    }
    
    @Before
    public void addingProductsToCart() {
    	String menCategory = "#nav > ol > li.level0.nav-2.parent";
    	String shirtSubCategory = "img[alt=\"Shirts\"]";
    
    	
    	WebElement menSection = driver.findElement(By.cssSelector(menCategory));
    	menSection.click();
    	
    	WebElement shirtSection = driver.findElement(By.cssSelector(shirtSubCategory));
    	shirtSection.click();
    	
    	String chosenProduct = ".product-info>h2>a[title=\"Plaid Cotton Shirt\"]";
    	
    	WebElement productAddedToCart = driver.findElement(By.cssSelector(chosenProduct));
    	productAddedToCart.click();
    	
    	String productColor = "#swatch17 > span.swatch-label > img";
    	WebElement colorOption = driver.findElement(By.cssSelector(productColor));
    	colorOption.click();
    	
    	String productSize = "#option81";
    	WebElement sizeOption = driver.findElement(By.cssSelector(productSize));
    	sizeOption.click();
    	
    	
    	String addToCartButton = "button[onclick=\"productAddToCartForm.submit(this)\"]>span>span";
    	WebElement cartButton = driver.findElement(By.cssSelector(addToCartButton));
    	cartButton.click();
    	
    	//checkoutProcess();
    	
    	//List<WebElement> menProductsMenu = driver.findElements(By.cssSelector(menCategory));
    	
    	//menProductsMenu.get(2).click();
    }
    @Test
    public void checkoutProcess() {
    	
    	String checkout = ".method-checkout-cart-methods-onepage-bottom>button";
    	WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector(checkout));
    	proceedToCheckoutButton.click();
    	
    	String continueButton = "#onepage-guest-register-button > span > span";
    	WebElement continueButtonElement = driver.findElement(By.cssSelector(continueButton));
    	
    	continueButtonElement.click();
    	
    	String firstName = "#billing\\:firstname";
    	String lastName = "#billing\\:lastname";
    	String email = "#billing\\:email";
    	String address = "#billing\\:street1";
    	String city = "#billing\\:city";
    	String countrydropDown = "select[name=\"billing[country_id]\"]";
    	String stateDropDown = "#billing\\:region_id";
    	String postalCode = "#billing\\:postcode";
    	String telephone = "#billing\\:telephone";
    	String radioButton = "#co-billing-form > div > ul > li:nth-child(3)";
    	String continueButton2 = "#billing-buttons-container > button";
    	
    	
    	WebElement firstNameField = driver.findElement(By.cssSelector(firstName));
    	firstNameField.clear();
    	firstNameField.sendKeys("abc");
    	
    	WebElement lastNameField = driver.findElement(By.cssSelector(lastName));
    	lastNameField .clear();
    	lastNameField .sendKeys("abc");
    	
    	WebElement emailField = driver.findElement(By.cssSelector(email));
    	emailField.clear();
    	emailField.sendKeys("abc@abc.com");
    	

    	WebElement addressField = driver.findElement(By.cssSelector(address));
    	addressField.clear();
    	addressField.sendKeys("abc@abc.com");
    	
    	WebElement cityField = driver.findElement(By.cssSelector("input[title =\"City\"]"));
    	cityField.clear();
    	cityField.sendKeys("Cluj-Napoca");
    	
    	WebElement countrydropDownField = driver.findElement(By.cssSelector(countrydropDown));
    	Select countrySelect = new Select(countrydropDownField);
    	countrySelect.selectByVisibleText("Romania");
    	
    	WebElement stateDropDownField = driver.findElement(By.cssSelector(stateDropDown));
    	Select stateSelect = new Select(stateDropDownField);
    	stateSelect.selectByVisibleText("Cluj");
    	
    	WebElement postalCodeField = driver.findElement(By.cssSelector(postalCode));
    	postalCodeField.clear();
    	postalCodeField.sendKeys("120560");
    	

    	WebElement telephoneField = driver.findElement(By.cssSelector(telephone));
    	telephoneField.clear();
    	telephoneField.sendKeys("0756122562");
    	
    	WebElement radioButtonElement = driver.findElement(By.cssSelector(continueButton2));
    	radioButtonElement.click();
    	
    	WebElement billingContinueButton = driver.findElement(By.cssSelector(continueButton2));
    	billingContinueButton.click();
    	
    	
    	String shippingInformation = "#opc-shipping > div.step-title > h2";
    	String shippingFirstName =".input-box>input[id=\"shipping:firstname\"]";
    	String shippingLastName = ".input-box>input[id=\"shipping:lastname\"]";
    	String shippingAddress =".input-box>input[id=\"shipping:street1\"]";
    	String shippingCity = ".input-box>input[id=\"shipping:city\"]";
    	String shippingCountry = "select[id=\"shipping:country_id\"]";
    	String shippingState ="select[id=\"shipping:region_id\"]";
    	String shippingPostCode= "input[id=\"shipping:postcode\"]";
    	String shippingTelephone = "input[id=\"shipping:telephone\"]";
    	String continueShippingButton = "button[onclick=\"shipping.save()\"]>span>span";
    	String shippingMethod = "#opc-shipping_method > div.step-title > h2";
    	
    	
    	//WebElement shippingInformationSection = driver.findElement(By.cssSelector(shippingInformation));
    	/*WebElement shippingInformationSection = (new WebDriverWait(driver,20 )).until(ExpectedConditions.presenceOfElementLocated(By.id(continueButton2)));
    	try {
			shippingInformationSection.wait(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	//shippingInformationSection.click();
    	

    	
    	WebElement shippingFirstNameField = driver.findElement(By.cssSelector(shippingFirstName)); 
    	shippingFirstNameField.clear();
    	shippingFirstNameField.sendKeys("abc");
    	
    	WebElement shippingLastNameField = driver.findElement(By.cssSelector(shippingLastName)); 
    	shippingLastNameField.clear();
    	shippingLastNameField.sendKeys("abc");
    	
    	WebElement shippingaddressField = driver.findElement(By.cssSelector(shippingAddress)); 
    	shippingaddressField.clear();
    	shippingaddressField.sendKeys("abc");
    	
    	WebElement shippingCityField = driver.findElement(By.cssSelector(shippingCity)); 
    	shippingCityField.clear();
    	shippingCityField .sendKeys("Cluj");

    	WebElement shippingCountryDropDown = driver.findElement(By.cssSelector(shippingCountry)); 
    	Select dropDown = new Select(shippingCountryDropDown);
    	dropDown.selectByVisibleText("Romania");
    	
    	WebElement shippingStateDropDown = driver.findElement(By.cssSelector(shippingState)); 
    	Select dropDown2 = new Select(shippingStateDropDown);
    	dropDown2.selectByVisibleText("Cluj");
    	
    	WebElement shippingPostCodeField = driver.findElement(By.cssSelector(shippingPostCode)); 
    	shippingPostCodeField.clear();
    	shippingPostCodeField.sendKeys("123678");
    
    	WebElement shippingTelephoneField = driver.findElement(By.cssSelector(shippingTelephone)); 
    	shippingTelephoneField.clear();
    	shippingTelephoneField.sendKeys("0737544100");
    	

    	WebElement continueShippingButton2 = driver.findElement(By.cssSelector(continueShippingButton)); 
    	continueShippingButton2.click();
    	 
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    	WebElement shippingInformationSection = driver.findElement(By.cssSelector(shippingInformation));
    	shippingInformationSection.click();


    	//WebElement shippingMethodSection = driver.findElement(By.cssSelector(shippingMethod)); 
    	//shippingMethodSection.click();
  	
    }
	
	
	
	
	
	@After
	public void afterMethods() {
		//driver.quit();
	}

	

	
	
	
	
	
	
	
	
	
	
}
