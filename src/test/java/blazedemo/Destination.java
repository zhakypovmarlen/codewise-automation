package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Destination {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com");

        WebElement destinationDropDown = driver.findElement(By.name("toPort"));

        Select options = new Select(destinationDropDown);
        String requiredSelectedOption = "Berlin";

        options.selectByVisibleText("Berlin");
        if(options.getFirstSelectedOption().getText().equals(requiredSelectedOption)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}
