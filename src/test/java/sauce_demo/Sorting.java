package sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Select dropDown = new Select(driver.findElement(By.className("product_sort_container")));
        dropDown.selectByVisibleText("Price (low to high)");

        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        boolean isPassed = false;



        for(int i = 0; i < prices.size(); i++){
            String tempPrice = prices.get(i).getText().replace("$","");
            double priceDouble = Double.parseDouble(tempPrice);
            for(int k = i+1; k < prices.size(); k++){
                String tempPrice1 = prices.get(k).getText().replace("$", "");
                double priceDouble1 = Double.parseDouble(tempPrice1);
                if(priceDouble <= priceDouble1){
                    isPassed = true;
                } else {
                    isPassed = false;
                }
                if(!isPassed){
                    break;
                }
            }

            if(isPassed){
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }


    }
}
