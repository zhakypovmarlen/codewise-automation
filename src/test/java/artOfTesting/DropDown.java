package artOfTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");


        WebElement dropDown = driver.findElement(By.id("testingDropdown"));
        Select options = new Select(dropDown);

        String actualDefaultOption = options.getFirstSelectedOption().getText();
        String expectedDefaultOption = "Automation Testing";

        if(expectedDefaultOption.equals(actualDefaultOption)){
            System.out.println("Default option passed\n");
        } else {
            System.out.println("Default option failed\n");
        }

        List<WebElement> allOptions = options.getOptions();

        for(WebElement option : allOptions){
            System.out.println(option.getText());
        }

        options.selectByVisibleText("Manual Testing");


    }
}
