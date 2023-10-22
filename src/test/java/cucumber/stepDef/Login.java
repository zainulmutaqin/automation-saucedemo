package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

    WebDriver driver;

    String url = "https://saucedemo.com";

    @Given("user is on web sauce demo")
    public void userIsOnWebSauceDemo() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @When("user input username {string}")
    public void userInputUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click login")
    public void userClickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user redirect to product page")
    public void userRedirectToProductPage() {
        String title = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(title, "Products");
        driver.close();
    }

    @Then("user get an error message")
    public void userGetAnErrorMessage() {
        String title = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(title, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
