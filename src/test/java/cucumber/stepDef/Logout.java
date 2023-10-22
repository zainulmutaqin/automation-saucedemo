package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Logout {

    WebDriver driver;

    String url = "https://saucedemo.com";

    @Given("user is already login")
    public void userIsAlreadyLogin() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @And("user click sidebar icon")
    public void userClickSidebarIcon() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click logout")
    public void userClickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user is on login page")
    public void userIsOnLoginPage() {
        String title = driver.findElement(By.xpath("(//h4)[1]")).getText();
        Assert.assertEquals(title, "Accepted usernames are:");
        driver.close();
    }
}
