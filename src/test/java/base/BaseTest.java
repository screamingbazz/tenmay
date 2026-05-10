package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.Logger;
import utils.Log;

public class BaseTest {

    protected WebDriver driver;
    protected String browserName;

    private static final Logger log =
            Log.getLogger(BaseTest.class);

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) {

        this.browserName = browser;

        // ✅ LOG START BROWSER
        log.info("==================================");
        log.info("TEST STARTED ON BROWSER: " + browserName.toUpperCase());
        log.info("==================================");

        driver = DriverFactory.createDriver(browserName);
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        // ✅ LOG END BROWSER
        log.info("==================================");
        log.info("TEST FINISHED ON BROWSER: " + browserName.toUpperCase());
        log.info("==================================");
    }
}