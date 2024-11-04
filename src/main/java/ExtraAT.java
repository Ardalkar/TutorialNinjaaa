/*
 * CartTest.java
package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.OrderProductPage;

public class CartTest extends BaseClass{

	public WebDriver driver;
	OrderProductPage orderproductpage;
	public CartTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browsernm"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	 @Test(dependsOnMethods = { "VerifyOrderProduct" })
		public void VerifyProductOnCart()
		{
		 
		 WebElement element1 = orderproductpage.ClickOnCheckout();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView()", element1);
		  
		
		 orderproductpage.ClickOnCheckout();
			 		 
		}
}
//
 * 
 * 
 * 
 * 
 * Here's an example of how to maintain products in a list with product ID and product name, and use any one product randomly at runtime using product ID in Java TestNG:


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import (link unavailable);
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProductTest {

    // List of products with ID and name
    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(new Product("40", "Apple Cinema 30"));
        PRODUCTS.add(new Product("41", "Canon EOS 5D"));
        PRODUCTS.add(new Product("42", "HP LP3065"));
        PRODUCTS.add(new Product("43", "HTC Touch HD"));
        PRODUCTS.add(new Product("44", "iPhone"));
        PRODUCTS.add(new Product("45", "MacBook"));
        PRODUCTS.add(new Product("46", "MacBook Air"));
        PRODUCTS.add(new Product("47", "Nintendo Wii"));
        PRODUCTS.add(new Product("48", "Nintendo GameBoy Micro"));
        PRODUCTS.add(new Product("49", "Palm Treo Pro"));
        PRODUCTS.add(new Product("50", "Samsung Galaxy Tab"));
        PRODUCTS.add(new Product("51", "Samsung SyncMaster 941BW"));
        PRODUCTS.add(new Product("52", "Sony Ericsson T610"));
        PRODUCTS.add(new Product("53", "Sony VAIO L Series"));
        PRODUCTS.add(new Product("54", "ThinkPad X41 Tablet"));
    }

    @Test
    public void verifyProduct() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to product category page
        driver.get("(link unavailable)");

        // Select random product
        Product randomProduct = selectRandomProduct();

        // Navigate to product page
        WebElement productLink = driver.findElement(By.xpath("//a[@href='(link unavailable)" + randomProduct.getId() + "']"));
        productLink.click();

        // Perform test actions
        System.out.println("Product ID: " + randomProduct.getId());
        System.out.println("Product Name: " + randomProduct.getName());
        System.out.println("Product Title: " + driver.getTitle());

        // Close WebDriver
        driver.quit();
    }

    private Product selectRandomProduct() {
        Random random = new Random();
        int randomIndex = random.nextInt(PRODUCTS.size());
        return PRODUCTS.get(randomIndex);
    }

    private static class Product {
        private String id;
        private String name;

        public Product(String id, String name) {
            (link unavailable) = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}


In this example:

- We define a list (PRODUCTS) containing products with ID and name.
- In the verifyProduct test method, we navigate to the product category page.
- We select a random product using the selectRandomProduct method.
- We navigate to the product page using the randomly selected product ID.
- We perform test actions.

Note:

- Replace "/path/to/chromedriver" with the actual path to the ChromeDriver executable.
- Ensure you have the necessary TestNG and Selenium dependencies in your project.
*/


