package Com.QA.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	WebDriver driver;
	
	By product=By.cssSelector("a[title='Show details for Apple MacBook Pro 13-inch']");
	
	By productName=By.cssSelector("div.product-name");
	
	By productDescription=By.cssSelector("div.short-description");
	
	By productPrice=By.cssSelector("span#price-value-4");
	
	By productFullDescription=By.cssSelector("div.full-description");
	
	By productSpecification=By.cssSelector("table.data-table tr");
	
	By AddtocartButton=By.xpath("//button[@id='add-to-cart-button-4']");
	
	By cartButton=By.xpath("//a[@class='ico-cart']");//explicit wait 
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String Verify_Add_Cart_Page_Title() {
		return driver.getTitle();
	}
	
	public String Verify_Add_Cart_Page_Url() {
		return driver.getCurrentUrl();
	}
	
	public void click_On_Product() {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(20));
		wb.until(
				ExpectedConditions.
				elementToBeClickable(product)).click();
	}
	
	public String Add_Cart_Product_Name() {
		return driver.findElement(productName).getText();
	}
	
	public String Add_Cart_Product_Description() {
		return driver.findElement(productDescription).getText();
	}
	
	public boolean Add_Cart_Product_Price() {
		boolean found;
		
		if(driver.findElement(productPrice).isDisplayed()==true) {
			found=true;
			
			if(found==true) {
				System.out.println(driver.findElement(productPrice).getText());
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public boolean Add_Cart_Product_Full_descitpiton() {
		boolean found;
		
		if(driver.findElement(productFullDescription).isDisplayed()==true) {
			found=true;
			
			if(found==true) {
				System.out.println(driver.findElement(productFullDescription).getText());
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public boolean Add_Cart_Product_Specification() {
		boolean found;
		
		if(driver.findElement(productSpecification).isDisplayed()==true) {
			found=true;
			
			if(found==true) {
				System.out.println(driver.findElement(productSpecification).getText());
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public void click_On_CArt_Button() {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(20));
		wb.
		    until
		        (ExpectedConditions
		        		.elementToBeClickable(AddtocartButton))
		                    .click();
		
		wb.
		until
		(ExpectedConditions.
				 elementToBeClickable
				        (cartButton)).click();
	}
}
