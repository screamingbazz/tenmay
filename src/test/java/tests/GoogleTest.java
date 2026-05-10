//package tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.apache.logging.log4j.Logger;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import pages.GooglePage;
//import utils.ExtentManager;
//import utils.Log;
//
//public class GoogleTest {
//
//    WebDriver driver;
//
//    ExtentReports extent;
//    ExtentTest test;
//
//    private static final Logger log =
//            Log.getLogger(GoogleTest.class);
//
//    @BeforeTest
//    public void setup() {
//
//        log.info("Launching Chrome browser");
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        extent = ExtentManager.getExtent();
//
//        log.info("Extent report initialized");
//    }
//
//    @Test
//    public void googleSearchTest() {
//
//        test = extent.createTest("Google Search Test");
//
//        log.info("Test started");
//
//        GooglePage google = new GooglePage(driver);
//
//        log.info("Opening Google");
//        google.openGoogle();
//
//        log.info("Searching text: Selenium WebDriver");
//        google.search("Selenium WebDriver");
//
//        log.info("Test completed successfully");
//
//        test.pass("Google search executed successfully");
//    }
//
//    @AfterTest
//    public void tearDown() {
//
//        log.info("Closing browser");
//
//        if (driver != null) {
//            driver.quit();
//        }
//
//        extent.flush();
//
//        log.info("Extent report flushed");
//    }
//}



package tests;

import base.BaseTest;

import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.GooglePage;
import utils.ExtentManager;
import utils.Log;

public class GoogleTest extends BaseTest {

    ExtentReports extent;
    ExtentTest test;

    private static final Logger log =
            Log.getLogger(GoogleTest.class);

    @Test
    public void googleSearchTest() {

        // Initialize report
        extent = ExtentManager.getExtent();
        test = extent.createTest("Google Search Test");

        log.info("Test started");

        // IMPORTANT: driver comes from BaseTest (not ChromeDriver)
        driver.get("https://www.google.com");

        GooglePage google = new GooglePage(driver);

        log.info("Searching Selenium WebDriver");
        google.search("Selenium WebDriver");

        log.info("Test completed successfully");

        test.pass("Google search executed successfully");

        extent.flush();
    }
}