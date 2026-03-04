package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.ApiHelper;

public class LoginTest extends BaseTest {

    @Test
    public void loginByApiAndVerifyDashboard() {

        String token = ApiHelper.loginAndGetToken(
                "hoangle8122003@gmail.com",
                "123456"
        );

        driver.get("https://demo5.cybersoft.edu.vn/");

        ((JavascriptExecutor) driver).executeScript(
                "window.localStorage.setItem('token', arguments[0]);",
                token
        );

        driver.navigate().refresh();

        boolean isLoggedIn = driver.findElement(By.xpath("//button[text()='Logout']")).isDisplayed();

        Assert.assertTrue(isLoggedIn, "Login failed!");
    }
}