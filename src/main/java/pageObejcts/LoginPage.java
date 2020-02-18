package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
	}
	
	 private By username = By.cssSelector("[name='username']");
	 private By password = By.cssSelector("[name='password']");
	 private By iniciarBtn = By.cssSelector("[title*='Iniciar']");
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getIniciarBtn() {
		return driver.findElement(iniciarBtn);
	}
}
