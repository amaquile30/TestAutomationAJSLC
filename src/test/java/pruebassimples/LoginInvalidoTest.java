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
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LoginInvalidoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void loginInvalido() {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.id("user-name")).click();
    driver.findElement(By.id("user-name")).sendKeys("jnfsjds");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("5262+6");
    driver.findElement(By.id("login-button")).click();
    Assert.assertEquals("No se mostro el error esperado","Epic sadface: Username and password do not match any user in this service",driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText());
    //assertThat(driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText(), is("Epic sadface: Username and password do not match any user in this service"));
    //driver.close();
  }
  @Test
  public void loginValido() {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.id("user-name")).click();
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    Assert.assertEquals("No se ingreso a la página principal","https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
    //assertThat(driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText(), is("Epic sadface: Username and password do not match any user in this service"));
    //driver.close();
  }
}
