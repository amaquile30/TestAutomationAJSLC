package pruebassimples;// Generated by Selenium IDE

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class InvalidLoginTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  public void invalidLogin() {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.id("user-name")).click();
    driver.findElement(By.id("user-name")).sendKeys("asdasdaxz");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("asdasddas");
    driver.findElement(By.id("login-button")).click();
    Assert.assertEquals("No se mostro el error esperado","Epic sadface: Username and password do not match any user in this service", driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText());
  }

  @Test
  public void validLogin() {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.id("user-name")).click();
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    Assert.assertEquals("No se ingreso a la página principal","https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
