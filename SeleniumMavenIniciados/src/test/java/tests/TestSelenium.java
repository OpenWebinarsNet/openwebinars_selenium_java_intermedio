package tests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page_objects.*;

public class TestSelenium {

	WebDriver driver;
	
	@BeforeEach
	public void beforeScenario() {
		//declarar el driver y navegar a la página
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//ir a google
		driver.get("https://www.google.com");
	}
	
	
	@Test
	public void testA() {
		//ejecutar las acciones
		GooglePage google_page = new GooglePage(driver);
		//aceptar cookies
		google_page.accept_cookies();
		//buscar un texto = wikipedia
		google_page.search_for_something("wikipedia");				
		//verificaremos que estamos en la página de resultados
		assertEquals("wikipedia - Buscar con Google", driver.getTitle());
		//recuperar la página de resultados
		GoogleSearchResultPage search_page = new GoogleSearchResultPage(driver); 
		//ir al primer resultado de búsqueda
		search_page.click_on_first_result();
		//comprobar el título del "artículo bueno" de wikipedia
		WikipediaPage wikipedia_page = new WikipediaPage(driver);
		
		String articulo_bueno_title = wikipedia_page.getArticuloBuenoTitle();
		
		assertEquals("Aquí irá el título del artículo bueno del día", articulo_bueno_title);
		
	}
	
	@AfterEach
	public void afterScenario() {
		//eliminar el driver
		driver.quit();
	}
	
	
		
}
