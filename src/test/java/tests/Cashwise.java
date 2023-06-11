package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cashwise {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.get("https://cashwise.us");
        driver.manage().window().fullscreen();
        driver.getTitle();

        String expectedCashWiseTitle = "Cashwise is best!";
        if(driver.getTitle().equals(expectedCashWiseTitle)){
            System.out.println("Title test is passed");
        }else{
            System.out.println("Title test is failed");
        }

        driver.getCurrentUrl();
        String expectedUrl = "https://cashwise.us/home";
        if(driver.getCurrentUrl().equals(expectedUrl)){
            System.out.println("URL test is passed");
        } else {
            System.out.println("URL test is failed");
        }

        System.out.println(driver.getPageSource());

        driver.close();









    }
}
