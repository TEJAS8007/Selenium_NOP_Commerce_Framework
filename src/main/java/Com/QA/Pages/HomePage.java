package Com.QA.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	By footer=By.cssSelector("div.footer-upper");

	By Header=By.cssSelector("div.header-menu");

	By Home_products_Grid=By.cssSelector("div[class='product-grid home-page-product-grid'] div.item-grid .item-box");

	By Products_title=By.cssSelector("h2.product-title a");

	By logo=By.cssSelector(".header-logo");

	By Customer_Currency=By.cssSelector("select#customerCurrency option");

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public String Verify_HomePage_Title() {
		return driver.getTitle();
	}

	public String Verify_Home_Page_Url() {
		return driver.getCurrentUrl();
	}

	public boolean Verify_Home_Page_Logo() {
		boolean found;

		WebElement Logo= driver.findElement(logo);

		if(Logo.isDisplayed()==true) {
			found=true;

			if(found==true) {
				String text= Logo.getText();
				System.out.println(text);
			}
			else {
				System.out.println("Logo mismatch...");
			}
		}
		else {
			found=false;
		}
		return found;
	}

	public int Verify_Home_Page_Header_Links() {

		int count=0;

		WebElement Headers=driver.findElement(Header);

		List<WebElement> HeaderLinkList=Headers.findElements(By.tagName("a"));

		for(WebElement ele :HeaderLinkList) {
			System.out.println(ele.getText());
			count++;
		}
		return count;
	}

	public int Verify_Home_Page_Footer_Links() {

		int count=0;

		WebElement footers=driver.findElement(footer);

		List<WebElement> FooterLinkList= footers.findElements(By.tagName("a"));

		for(int a=0;a<FooterLinkList.size();a++) {
			String text = FooterLinkList.get(a).getText();
			System.out.println(text);
			count++;
		}
		return count;
	}

	public int Verify_Home_page_Products() {

		List<WebElement> ProductList= driver.findElements(Home_products_Grid);

		return ProductList.size();
	}

	public void Verify_Home_page_Products_Title() {

		List<WebElement> ProductTitleList= driver.findElements(Products_title);

		for(WebElement el :ProductTitleList) {
			System.out.println(el.getText());
		}
	}
	
	public int Verify_CustomerCurrency() {
		
		int count=0;
		
		List<WebElement> currencyList= driver.findElements(Customer_Currency);
	
		for(int a=0;a<currencyList.size();a++) {
			String text= currencyList.get(a).getText();
			System.out.println(text);
			count++;
		}
		return count;
	}
	
}
