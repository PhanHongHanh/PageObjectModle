package hanhtest.Commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class ValidateHelper {
    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Select select;
    private final int timeoutWait = 10;
    private final int timeoutWaitForPageLoaded = 20;

    public  ValidateHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);

    }

    public String getPageTitle(){//lấy ra chuỗi title
       waitForPageLoaded();
       String title = driver.getTitle();
       System.out.println("page title:" + driver.getTitle()); //hiển thi ra title hiện tại đúng
       return title;
    }
    public boolean verifyPageTitle(String pageTile ){
        waitForPageLoaded();
        return getPageTitle().equals(pageTile);// ss bằng một đoạn text truyền vào

    }
    public boolean verifyPageUrl(String pageUrl){
        System.out.println("Current URL:"+ driver.getCurrentUrl()); //hiển thị ra url hiện tại đúng
        return driver.getCurrentUrl().contains(pageUrl); // trả về true/false contains(pageUrl): có chứa url "/login"
    }

    public void setText(By element, String value){
        waitForPageLoaded();
        //senKeys một giá trị là value cho element chuyển vào
        //wait.until(ExpectedConditions.elementToBeClickable(element));//chờ đợi clickElement
//        driver.findElement(element).click();
//        driver.findElement(element).clear();
//        driver.findElement(element).sendKeys(value);

// cách 2
        WebElement elementWaited = wait.until(ExpectedConditions.elementToBeClickable(element));// chờ đợi trang load xong
        elementWaited.click();
        elementWaited.clear();
        elementWaited.sendKeys(value);

    }
    public void clickElement (By element){
        waitForPageLoaded();
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        //driver.findElement(element).click();
        // click của js
        //js.executeScript("arguments[0].click();",driver.findElement(element));

        WebElement clickElementWaited = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickElementWaited.click();
    }
    public void clickElementWithJs(By element){
        waitForPageLoaded();
        //đợi đến khi element tồn tại
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        //Scroll đến element với js để click
        js.executeScript("arguments[0].click;",driver.findElement(element));
        //click với js
        js.executeScript("arguments[1].click()",driver.findElement(element));
    }

    public void rightClickElement(By by){ //click chuột phải
        wait.until(ExpectedConditions.elementToBeClickable(by));
        action.contextClick().build().perform();

    }

    public void selectOptionByText(By by, String Text){
        select = new Select(driver.findElement(by)); //khởi tạo trực tiếp với element
        select.selectByVisibleText(Text);

    }

    public void selectByOptionByValue(By by, String value){
        select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByOptionByIndex(By by, int Index){
        select = new Select(driver.findElement(by));
        select.selectByIndex(Index);

    }

    public void verifyOptionTotal(By element, int total){ //ktra dropdown có bao nhiêu giá trị
        select = new Select(driver.findElement(element));
        Assert.assertEquals(total,select.getOptions().size());

    }
    //Đợi cho trang load xong
    public void waitForPageLoaded(){
        try {
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver){

                    return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("Hoàn thành");
                }
            });
        }
        catch (Throwable error){
            Assert.fail("Hết thời gian chờ yêu cầu tải trang");
        }
    }
}
