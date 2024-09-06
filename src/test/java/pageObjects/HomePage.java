package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement LinkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement LinkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement LinkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;

	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;

		
	
	
	public void clickMyAccount() {
		LinkMyAccount.click();
		
	}
	
	public void clickRegister() {
		
		LinkRegister.click();
	}
	
    public void clickLogin() {
		
		LinkLogin.click();
    }
    

    public void enterProductName(String pName)   //For Search Product Test
    {
	   txtSearchbox.sendKeys(pName);
     }

     public void clickSearch()  //For Search Product Test
     {
	    btnSearch.click();
      }

}
