package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Red {
    public static void main(String[] args) throws IOException {

        Faker faker = new Faker();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/");

        String email = faker.internet().emailAddress();
        System.out.println(email);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email, Keys.ENTER);

        List<WebElement> info = driver.findElements(By.xpath("(//table)[2]//td[2]"));
        String userID = info.get(0).getText();
        String password = info.get(1).getText();

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/configurations.properties");
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("url"));

        properties.setProperty("username", userID);
        properties.setProperty("password", password);

        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));


    }
}
