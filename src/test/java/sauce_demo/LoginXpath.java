package sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginXpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://saucedemo.com");


        WebElement username = driver.findElement(By.xpath("//*[@id='user-name']"));
        username.sendKeys("problem_user");
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("secret_sauce");


        driver.findElement(By.xpath("//input[@id='login-button']")).click();


        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[.='Add to cart']"));
        System.out.println(addToCartButtons.size());
        for(int i = 0; i < addToCartButtons.size(); i++){
            addToCartButtons.get(i).click();

        }
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();

        WebElement cartNumber = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
        String itemQuantity = cartNumber.getText();

        int quantityInt = Integer.parseInt(itemQuantity);
        System.out.println(quantityInt);
        if(quantityInt == addToCartButtons.size()){
            System.out.println("All items were added successfully");
        } else {
            System.out.println("Not all items were added successfully");
        }






    }
}
