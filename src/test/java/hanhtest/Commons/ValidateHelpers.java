package hanhtest.Commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidateHelpers {
    private WebDriver driver;
    private WebDriverWait wait;

    public ValidateHelpers( WebDriver driver){//hàm xây dưng truyền driver từ bên ngoài vào driver trong hàm

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    public void setText(By element, String value){


        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);

    }
    public void clickElement(By element){

        driver.findElement(element).click();

    }
    public boolean verifyElementText(By element, String textValue){ //hển thị đoạn text
        return driver.findElement(element).getText().equals(textValue);
    }
    public boolean verifyUrl(String url){
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return  driver.getCurrentUrl().contains(url); //kiểm tra url có hay không tra về true/false, lấy url hiện tại ss chứa và truyền url
    }

}
