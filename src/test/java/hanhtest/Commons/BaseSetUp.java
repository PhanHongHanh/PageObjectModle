package hanhtest.Commons;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseSetUp {
    private static WebDriver driver;
    private final int PageLoadTimeOut = 30;
    private final int ImplicitWaitTimeOut = 20;
//    private String url="https://mediamart.vn/";

    //static String driverPath ="resources\\drivers";
    public WebDriver getDriver() {
        return driver;

    }
//    public String getUrl(){
//        return url;
//    }

    public WebDriver setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase( //trim: xóa khoảng trắng hai đầu, toLowerCase: chuyển về chữ thường

        )) {
            case "chrome":

                driver = initChromeDriver();
                break;

            case "edge":

                driver = initEdgeDriver();
                break;

            default:

                System.out.println("Browser:" + browserType + "is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();

        }
        return driver;

    }


    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                driver.navigate().to(appURL);
                break;
            default:
                System.out.println("Browser:" + browserType + "is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }

    }

    private static WebDriver initChromeDriver() {
        System.out.println("khởi tạo trình duyệt chrome");
//        System.setProperty("webdriver,chrome.driver", driverPath + "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
    private static WebDriver initEdgeDriver() {
        System.out.println("khởi tạo trình duyệt edge");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        //driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }

    @Parameters({ "browserType","appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL){
        try {
            //khởi tạo driver và browser
            setDriver(browserType, appURL);

        }
        catch (Exception e){
            System.out.println("Lỗi..."+e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




}
