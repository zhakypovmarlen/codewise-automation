package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Config;
import utilities.Driver;


public class GuruBankLogin {
    public static void main(String[] args) {


        Driver.getDriver().get(Config.getValue("guruBankURL"));
        Driver.getDriver().findElement(By.name("uid")).sendKeys(Config.getValue("userID"));
        Driver.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(Config.getValue("password"), Keys.ENTER);


    }
}
