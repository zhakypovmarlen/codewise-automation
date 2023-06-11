package tutorialsNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Login {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li"));
        System.out.println(elements.size());
        for(int i = 0; i < elements.size(); i++){
//            if(i == 3 || i == 4 || i == 5 || i == 6){
//                continue;
//            }
            if(!driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/")){
                driver.navigate().back();
            }
            elements.get(i).click();
            Thread.sleep(1500);
        }
        driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[8]//ul[2]/li/a")).click();



    }
}
