package hanhtest.Testcases;

import hanhtest.Commons.BaseSetUp;
import hanhtest.Commons.ValidateHelper;
import hanhtest.Commons.ValidateHelpers;
import hanhtest.Pages.OptionHangPage;
import hanhtest.Pages.SignInPage;
import hanhtest.Pages.TiViPage;
import hanhtest.Pages.TrangChuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class tiViTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    @BeforeClass
    public void setupBrowser() {
        driver = new BaseSetUp().setupDriver("edge");
        validateHelper = new ValidateHelper(driver);
    }

    @Test
    public void loginPage(){
        driver.get("https://mediamart.vn/");
        driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
    }
    @AfterClass
    public void closeBrowser(){

        driver.close();
    }

}
