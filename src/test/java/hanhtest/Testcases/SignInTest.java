package hanhtest.Testcases;

import hanhtest.Commons.BaseSetUp;
import hanhtest.Commons.ValidateHelper;
import hanhtest.Commons.ValidateHelpers;
import hanhtest.Pages.OptionHangPage;
import hanhtest.Pages.TiViPage;
import hanhtest.Pages.TrangChuPage;
import hanhtest.Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest{
    private WebDriver driver;
    private SignInPage signInPage;
    private TrangChuPage trangChuPage;
    private TiViPage tiViPage;
    private OptionHangPage optionHangPage;
    private ValidateHelper validateHelper;

    @BeforeClass
    public void setupBrowser(){

        driver = new BaseSetUp().setupDriver("chrome");
        validateHelper = new ValidateHelper(driver);
    }

    @Test(priority = 0)
    public void signInPage() throws InterruptedException {
        signInPage = new SignInPage(driver);
        driver.get("https://mediamart.vn/login");

        trangChuPage = signInPage.signin("hanhruby2511@gmail.com", "m7EBhYrxTnUgJ@i");
        validateHelper.waitForPageLoaded();
    }
}


