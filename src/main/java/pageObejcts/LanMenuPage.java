package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanMenuPage {
	
	WebDriver driver;
	
	public LanMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private  By iniciarSesion = By.xpath("//*[text()='Iniciar sesión']");
	private  By riotNavBar = By.cssSelector("#riotbar-navbar");
	
	public WebElement getIniciarSesion() {
		return driver.findElement(iniciarSesion);
	}
	
	public WebElement getRiotBarNavBar() {
		return driver.findElement(riotNavBar);
	}
}
