package guru;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ApplicationFlow;

import java.time.Duration;
import java.util.List;

public class BankLogin {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://demo.guru99.com/");

        Faker faker = new Faker();

        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email, Keys.ENTER);

        List<WebElement> info = driver.findElements(By.xpath("(//table)[2]//td[2]"));
        String userID = info.get(0).getText();
        String password =  info.get(1).getText();

        driver.findElement(By.linkText("Bank Project")).click();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userID);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password, Keys.ENTER);

        String expectedURL = "https://demo.guru99.com/V1/html/Managerhomepage.php";

        ApplicationFlow.pause(1000);
        if(expectedURL.equals(driver.getCurrentUrl())){
            System.out.println("Bank login is PASSED");
        } else {
            System.out.println("Bank login is FAILED");
        }

    }
}
