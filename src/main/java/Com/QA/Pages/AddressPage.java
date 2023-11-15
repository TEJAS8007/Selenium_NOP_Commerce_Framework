package Com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

	WebDriver driver;
	
	By PageLogo=By.cssSelector("div[class='page-title']");
	
	By country=By.cssSelector("select#BillingNewAddress_CountryId");
	
	By state=By.cssSelector("select#BillingNewAddress_StateProvinceId");
	
	By city=By.id("BillingNewAddress_City");
	
	By Address1=By.id("BillingNewAddress_Address1");
	
	By Address2=By.id("BillingNewAddress_Address2");
	
	By Zip=By.id("BillingNewAddress_ZipPostalCode");
	
	By Phone=By.id("BillingNewAddress_PhoneNumber");
	
	By fax=By.id("BillingNewAddress_FaxNumber");
	
	By Continue=By.cssSelector("button[onclick='Billing.save()']");
	
	
	public AddressPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String Verify_Address_page_Title() {
		return driver.getTitle();
	}
	
	public String Verify_Address_Page_url() {
		return driver.getCurrentUrl();
	}
	
	public boolean Verify_Address_Page_Logo() {
		boolean found;
		
		if(driver.findElement(PageLogo).isEnabled()==true) {
			found=true;
			
			if(found==true) {
				System.out.println("Adddress Page Logo : "+driver.findElement(PageLogo).getText());
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public void Send_Address_Data(String ci,String ad1,String ad2,String zp,String ph,String fx) {
		Select select=new Select(driver.findElement(country));
		select.selectByIndex(23);
		
		Select states=new Select(driver.findElement(state));
		states.selectByIndex(0);
		
		driver.findElement(city).sendKeys(ci);
		driver.findElement(Address1).sendKeys(ad1);
		driver.findElement(Address2).sendKeys(ad2);
		driver.findElement(Zip).sendKeys(zp);
		driver.findElement(Phone).sendKeys(ph);
		driver.findElement(fax).sendKeys(fx);
		driver.findElement(Continue).click();
	}
}
