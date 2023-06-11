package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;




public class PaymentGatewayProject {
    public static void main(String[] args) {

        Driver.getDriver().get(Config.getValue("guruURL"));
        Driver.getDriver().findElement(By.linkText("Generate Card Number")).click();

        ApplicationFlow.switchToSecondWindow();

        WebElement creditCard = Driver.getDriver().findElement(By.xpath("//h4[1]"));
        WebElement cvv = Driver.getDriver().findElement(By.xpath("//h4[2]"));
        WebElement limit = Driver.getDriver().findElement(By.xpath("//h4[4]"));

        String ccString = creditCard.getText().substring(14);


        if(ccString.length() == 16){
            System.out.println("Credit Card validation PASSED");
        } else {
            System.out.println("Credit Card validation FAILED");
        }

        String cvvString = cvv.getText().substring(6);


        if(cvvString.length() == 3){
            System.out.println("CVV validation PASSED");
        } else {
            System.out.println("CVV validation FAILED");
        }

        String limitString = limit.getText().substring(14);
        double limitInt = Double.parseDouble(limitString);

        if(limitInt == 100.00){
            System.out.println("Limit validation PASSED");
        } else {
            System.out.println("Limit validation PASSED");
        }



    }
}
