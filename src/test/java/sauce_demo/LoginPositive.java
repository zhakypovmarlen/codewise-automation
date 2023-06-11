package sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPositive {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(1000);

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        if(driver.getCurrentUrl().equals(expectedURL)){
            System.out.println("Successfully logged in");
        } else {
            System.out.println("Failed to log in!");
        }
        WebElement sauceLabsBackpack = driver.findElement(By.id("item_4_title_link"));
        sauceLabsBackpack.click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.id("item_0_title_link")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.id("item_1_title_link")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.id("item_5_title_link")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.id("item_2_title_link")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        driver.quit();
    }
}
