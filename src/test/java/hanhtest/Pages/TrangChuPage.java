package hanhtest.Pages;

import hanhtest.Commons.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TrangChuPage {
    private ValidateHelpers validateHelpers;
    private WebDriver driver;
    private SignInPage signInPage;
    public TrangChuPage(WebDriver driver) {
        this.driver =driver;
        validateHelpers = new ValidateHelpers(driver);
    }
    private By tiViMenu = By.xpath("//a[@title='Tivi']//span[contains(text(),'Tivi')]");
    private By elementPageText= By.xpath("//span[contains(text(),'Tư vấn bán hàng')]");
    public TiViPage openTiViPage(){
        Assert.assertTrue(validateHelpers.verifyElementText(elementPageText,"Tư vấn bán hàng"),"không phải trang chủ");
        validateHelpers.clickElement(tiViMenu);
        return new TiViPage(driver);
    }
}
