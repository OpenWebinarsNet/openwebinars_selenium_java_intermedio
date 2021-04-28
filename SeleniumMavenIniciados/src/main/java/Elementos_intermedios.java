import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementos_intermedios {

	
	private ChromeDriver driver;
	
	public Elementos_intermedios() {}
	
	
	public void iframe_changing() {
		
		 By iframe_section = By.linkText("iFrames");
		 By iframe_button = By.id("iframebutton");
		
		 
		 //nos dirigimos a la sección de iFrames
		 driver.findElement(iframe_section).click();
		
		 String iframe1 = "inception_1";
		 String iframe2 = "inception_2";
		
		 //Cambiamos al primer iframe y pulsamos el boton
		 driver.switchTo().frame(iframe1);
		 driver.findElement(iframe_button).click();
		 esperar(2000);
		 
		 /*
		 Cambiamos al segundo frame y pulsamos el boton
		 podemos utilizar el mismo localizador, pues no varía
		 solo dependerá de en que contexto (iframe) nos encontremos
		 */
		 driver.switchTo().frame(iframe2);
		 driver.findElement(iframe_button).click();
		 esperar(2000);
		 
		 
		 /*
		 Volvemos al contenido por defecto (top) de la página
	     y tratamos de volver a buscarlo capturando el error: 
	     NoSuchElementException
	     */
		 driver.switchTo().defaultContent();
		 
		 try {
			 WebElement boton = driver.findElement(iframe_button);
			 boton.click();
		 }catch(NoSuchElementException nsee) {
			 nsee.printStackTrace();
			 System.out.println("El botón no existe.");
		 }
		  
		
	}
	
	
	public void javascript_execution() {
		
		By xpaths_section = By.linkText("XPaths");
		
		//nos dirigimos a la sección de XPaths
		driver.findElement(xpaths_section).click();
		
		/*
		Boton Cancelar -> Contenedor Principal - Opción 116
	    EL XPATH SETEADO PUEDE SER MUCHO MÁS ÓPTIMO, PERO
	    ESTÁ SETEADO ASÍ POR MOTIVOS DIDÁCTICOS. ESTUDIAD
	    LO QUE ESTÁ HACIENDO.
	    */
	    By cancelar116Principal = By.xpath("(//button[text()='Cancelar' and ../preceding-sibling::div[p[contains(text(),'Principal') and contains(text(),'116')]]])[1]");
	    
		WebElement cancelar116Principal_element = driver.findElement(cancelar116Principal);
	    
		
		// EJECUTAMOS EL SCRIPT
		// window.scrollTo -> Lleva el scroll hacia la posición donde se le indica.
		// window.scrollBy -> Desliza el scroll las cantidades que se le indiquen en la función.
		esperar(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, arguments[0])", cancelar116Principal_element.getLocation().getY());
		
		esperar(2000);
		
		// EJECUTAMOS UN ALERT
		String mensaje = "envío este mensaje desde Java!";
		
		jse.executeScript("alert(arguments[0]);", mensaje);
		
		esperar(2000);
		driver.switchTo().alert().accept();
		esperar(2000);
		
		
	}
	
	
	
	public void shadowdom_action() {
		
		By shadowdom_section = By.linkText("ShadowDOM");
		
		//nos dirigimos a la sección de ShadoWDOM
		driver.findElement(shadowdom_section).click();
		
		By shadowhost_location = By.id("nodoShadowHost");
				
		/*
		POR MOTIVOS DE CARGA DE LA PÁGINA, AGREGAMOS UN MECANISMO DE ESPERA EXPLICITA
		QUE AGUARDE A QUE EL ELEMENTO SEA VISIBLE
		*/
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(shadowhost_location));
				
		//CAPTURAMOS EL NODO SHADOWHOST		
		WebElement nodoShadowHost = driver.findElement(shadowhost_location);
    
		/*
	    A PARTIR DEL ELEMENTO SHADOWHOST, NOS AYUDAMOS DE JAVASCRIPT
	    PARA RECUPERAR EL NODO DE SHADOWROOT
	    */		
		JavascriptExecutor jse = (JavascriptExecutor) driver;		
		WebElement nodoShadowRoot = (WebElement) jse.executeScript("return arguments[0].shadowRoot;", nodoShadowHost);		
    		
		/*
		Pulsamos el botón DENTRO del shadowDOM, y posteriormente
    	pulsaremos el del top llamando al driver.
    	*/
		esperar(2000);
		nodoShadowRoot.findElement(By.id("boton2")).click();
		 
		esperar(2000);
		driver.findElement(By.id("boton1")).click();
		esperar(2000);
		
	}
	
	
	
	
	public void iniciar_navegador() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.get("http://localhost:3000");
		
	}
	
	public void cerrar_navegador() {
		this.driver.quit();
	}
	
	public void esperar(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Elementos_intermedios objeto = new Elementos_intermedios();
		
		objeto.iniciar_navegador();
		
		objeto.shadowdom_action();
		
		objeto.cerrar_navegador();
	}
}
