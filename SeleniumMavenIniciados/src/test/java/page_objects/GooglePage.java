package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage{
	
	By search_bar = By.name("q");
	By accept_cookies_button = By.xpath("//div[text()='Acepto']/ancestor::button");
	
	public GooglePage(WebDriver driver) {
		super(driver);
	}
	
	public void search_for_something(String text_to_search) {
		WebElement search_bar_element = this.driver.findElement(search_bar);
		search_bar_element.sendKeys(text_to_search);
		search_bar_element.sendKeys(Keys.ENTER);
	}
	
	public void accept_cookies() {
		this.driver.findElement(accept_cookies_button).click();
	}
	
}
