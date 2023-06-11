package guru;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.List;

public class FakeData {
    public static void main(String[] args) {
        Faker faker = new Faker();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/");

        String email = faker.internet().emailAddress();
        System.out.println(email);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email, Keys.ENTER);

        List<WebElement> info = driver.findElements(By.xpath("(//table)[2]//td[2]"));
        System.out.println("user ID: " + info.get(0).getText());
        System.out.println("password: " + info.get(1).getText());



    }
}
