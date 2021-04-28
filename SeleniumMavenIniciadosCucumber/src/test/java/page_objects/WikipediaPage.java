package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage extends BasePage{

	By articulo_bueno = By.xpath("//div[@id='Artículo_bueno']/following-sibling::h2/descendant::a");
	
	public WikipediaPage(WebDriver driver) {
		super(driver);
	}
	
	public String getArticuloBuenoTitle() {
		return this.driver.findElement(articulo_bueno).getAttribute("title");
	}
	
	
}
