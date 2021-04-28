package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultPage extends BasePage{
	
	By first_result_url = By.xpath("(//div[@id='search']/descendant::div[@class='g'])[1]/descendant::a[1]");
	
	public GoogleSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public void click_on_first_result() {
		this.driver.findElement(first_result_url).click();
	}
	
	
}
