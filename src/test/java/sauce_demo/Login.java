package sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com");
        driver.manage().window().fullscreen();
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("asd");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("asd");
        password.submit();


        Thread.sleep(2000);


//        WebElement loginButton = driver.findElement(By.id("login-button"));
//        loginButton.click();
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        String message = errorMessage.getText();
        System.out.println(message);
        String expectedErrorMessage = "Wrong username or password. Try again!";
        if(expectedErrorMessage.equals(message)){
            System.out.println("Error message passed");
        } else {
            System.out.println("Error message failed");
        }
        driver.quit();

    }
}
