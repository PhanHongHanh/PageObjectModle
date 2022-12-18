package hanhtest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPageFactory{

    private WebDriver driver;
    private WebDriverWait wait;

    //chờ đợi tìm kiếm tùng element
    @FindBy(xpath = "//div[@class='K1dDgL']")
    private WebElement headerPageText;
    @FindBy(xpath = "//div[@class='gCY-Ye']")
    private WebElement errorMsgText ;
    @FindBy(xpath = "//input[@placeholder='Email/Số điện thoại/Tên đăng nhập']")
    private WebElement accountInput;
    @FindBy(xpath = "//input[@placeholder='Mật khẩu']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Đăng nhập')]")
    private WebElement signInBtn;
    @FindBy(xpath = "//*[name()='path' and contains(@fill-rule,'evenodd')]")
    private WebElement qrCodeBnt;
    @FindBy(xpath = "//button[@class='SnLyxu']")
    private WebElement SnLyXuBnt;
    @FindBy(xpath = "//a[contains(text(),'Quên mật khẩu')]")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//a[contains(text(),'Đăng nhập với SMS')]")
    private WebElement loginWithSMSLink;

    public SignInPageFactory(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);
    }
    //WebDriverWait wait = new WebDriverWait(driver,5);

    // Sau khi thực hiện click Submit thì khởi tạo trang DashboardPage
    public TrangChuPage signin(String usename, String password) throws Exception {
        setText(accountInput, usename);//accountInput.sendKeys(account);
        setText(passwordInput,password);//passwordInput.sendKeys(password);
        clickElement(signInBtn);
        Thread.sleep(1000);
        return new TrangChuPage(driver);
    }

    private void setText(WebElement element, String valueText) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(valueText);
    }

    private void clickElement(WebElement element) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
