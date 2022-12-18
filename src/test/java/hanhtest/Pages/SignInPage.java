package hanhtest.Pages;

import hanhtest.Commons.BaseSetUp;
import hanhtest.Commons.ValidateHelper;
import hanhtest.Commons.ValidateHelpers;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class SignInPage extends BaseSetUp {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private ValidateHelper validateHelper;
    WebDriverWait wait;

    private String pageTitle= "Đăng nhập";
    private String Url = "/login";
    private By LoginBtn = By.xpath("//a[contains(text(),'Đăng nhập')]");
    private By accountInput= By.id("Email");
    private By passwordInput= By.id("Password");
    private By dangNhapBtb= By.xpath("//button[contains(text(),'Đăng nhập')]");
    private By headerPageText1= By.xpath("//h2[contains(text(),'Đăng nhập')]");
    private By headerPageText2= By.xpath("//h4[contains(text(),'Sử dụng tài khoản của bạn để đăng nhập')]");
    private By dangKyMoi= By.xpath("//a[contains(text(),'Đăng ký người dùng mới')]");
    private By quenMK= By.xpath("//a[contains(text(),'Quên mật khẩu')]");
    private By errorMsgText= By.xpath("//div[@class='text-danger validation-summary-errors']//ul");


    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong
    // class này đọc
    public SignInPage(WebDriver driver) { //tạo ra hàm xây dựng kế thừa và sau đó có thể truyền dữ liệu vào

        this.driver = driver; //this chính trong class này ko phải bên ngoài truyền vào

        validateHelpers = new ValidateHelpers(driver); //lấy giá trị driver từ bên ngoài còn this.driver lấy tại class
        validateHelper = new ValidateHelper(driver);

        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public TrangChuPage signin(String account, String password) throws InterruptedException {

        Assert.assertTrue(validateHelpers.verifyElementText(dangNhapBtb,"Đăng nhập"));

        //validateHelpers.clickElement(LoginBtn);
        validateHelpers.setText(accountInput, account);
        validateHelpers.setText(passwordInput,password);
        validateHelpers.clickElement(dangNhapBtb);

        //Assert.assertTrue(validateHelper.verifyPageTitle(dangNhapBtb, "Đăng nhập"));
        //validateHelper.clickElement(LoginBtn);
        //validateHelper.setText(accountInput, account);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(dangNhapBtb);
//        Assert.assertTrue(validateHelper.verifyPageTitle(pageTitle), "Tiêu đề trang đăng nhập chưa đúng");
//        Assert.assertTrue(validateHelper.verifyPageUrl(Url),"Url trang đăng nhập không đúng");

        Thread.sleep(1000);

        return new TrangChuPage(driver);
    }


}
