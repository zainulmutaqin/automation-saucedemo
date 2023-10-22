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

public class Order {

    WebDriver driver;

    String url = "https://saucedemo.com";

    @Given("user is already login in web")
    public void userIsAlreadyLoginInWeb() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user add item to cart")
    public void userAddItemToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }


    @And("user click Checkout")
    public void userClickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user input first name {string}")
    public void userInputFirstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    @And("user input last name {string}")
    public void userInputLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    @And("user input postal code {string}")
    public void userInputPostalCode(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    @And("user click Continue")
    public void userClickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user is on checkout overview page")
    public void userIsOnCheckoutOverviewPage() {
        String title = driver.findElement(By.xpath("//span[contains(text(),'Overview')]")).getText();
        Assert.assertEquals(title, "Checkout: Overview");
    }

    @And("user click Finish")
    public void userClickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user get info checkout complete")
    public void userGetInfoCheckoutComplete() {
        String title = driver.findElement(By.xpath("//span[contains(text(),'Complete')]")).getText();
        Assert.assertEquals(title, "Checkout: Complete!");
        driver.close();
    }


}
