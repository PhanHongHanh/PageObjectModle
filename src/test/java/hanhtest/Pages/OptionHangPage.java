package hanhtest.Pages;

import hanhtest.Commons.ValidateHelpers;
import org.openqa.selenium.WebDriver;

public class OptionHangPage {
    private WebDriver driver;
    public ValidateHelpers validateHelpers;

    public OptionHangPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);

    }
}
