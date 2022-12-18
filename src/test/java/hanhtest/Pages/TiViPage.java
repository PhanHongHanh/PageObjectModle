package hanhtest.Pages;

import hanhtest.Commons.ValidateHelper;
import hanhtest.Commons.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TiViPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private ValidateHelper validateHelper;
    public TiViPage(WebDriver driver){
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        validateHelper = new ValidateHelper(driver);

    }
    private String pageText= "Tivi";
    private String url= "/tivi";
    private By HangDropdown = By.xpath("");
    private By headerPageText = By.xpath("//h1[Text=\"Tivi\"]");
    private By DropDowHang = By.xpath("//a[@href='#pl-filterBrand-tab']");


    public OptionHangPage optionHang(){
        Assert.assertTrue(validateHelpers.verifyUrl(url), "không phải trang Tivi.");

        validateHelpers.clickElement(DropDowHang);
        validateHelpers.verifyElementText(headerPageText,pageText);

        validateHelper.verifyOptionTotal(HangDropdown,8);
        return new OptionHangPage(driver);
    }
}
