package tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Intro {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com");

        driver.findElement(By.xpath("//input")).click();
        System.out.println(driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText());

        List<WebElement> row = driver.findElements(By.xpath("//thead/tr/th"));
        List <WebElement> column = driver.findElements(By.xpath("//tbody/tr"));

        for(int i = 1; i < row.size(); i++){
            System.out.println(driver.findElement(By.xpath("//tr["+i+"]//td[6]")).getText().replace("$",""));
        }
    }
}
