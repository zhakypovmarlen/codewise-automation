package sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();
        Thread.sleep(1500);

        WebElement removeFromCartBtn = driver.findElement(By.xpath("(//div[@class='pricebar'])[1]/button"));
        String text = removeFromCartBtn.getText();


        if(text.equals("Remove")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        if(driver.findElement(By.xpath("(//div[@class='pricebar'])[1]/button")).getText().equals("Add to cart")){
            System.out.println("Test failed");
        } else {
            System.out.println("Test passed");
        }

        String shoppingCartAmount = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        if(Integer.parseInt(shoppingCartAmount) == 1){
            System.out.println("Test passed ");
        } else {
            System.out.println("Test failed");
        }

        List<WebElement> dropDownButtons = driver.findElements(By.xpath("//select/option"));

        for(WebElement button : dropDownButtons){
            if(button.getText().equals("Price (low to high)")){
                button.click();
            }
        }

    }
}
