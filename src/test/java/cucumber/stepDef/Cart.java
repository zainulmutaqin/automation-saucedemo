package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cart {
    WebDriver driver;

    String url = "https://saucedemo.com";
    
    @Given("user is on product page")
    public void userIsOnProductPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user Add Sauce Labs Backpack to Cart")
    public void userAddSauceLabsBackpackToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("user see Sauce Labs Backpack on cart")
    public void userSeeSauceLabsBackpackOnCart() {
        String title = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(title, "Sauce Labs Backpack");
        driver.close();
    }
}
