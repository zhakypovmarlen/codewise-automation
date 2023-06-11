package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class validate {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

        WebElement first = driver.findElement(By.xpath("//select[@id='first']"));
        Select select = new Select(first);
        if(select.getOptions().size() == 4){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        select.selectByVisibleText("Yahoo");

        WebElement second = driver.findElement(By.id("animals"));
        Select select1 = new Select(second);
        if(select.getOptions().size() == 4){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        select1.selectByValue("cat");

        WebElement third = driver.findElement(By.xpath("//select[@id='second']"));
        Select select2 = new Select(third);
        List<WebElement> elements = select2.getOptions();
        if(select2.getOptions().size() == 4){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }



        for(WebElement s : elements){
            s.click();
            System.out.println(s.getText());

        }
    }
}
