package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("test-output/AutomationReport.html");

            reporter.config().setReportName("UI Automation Report");
            reporter.config().setDocumentTitle("Selenium Framework Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Selenium POM");
            extent.setSystemInfo("QA", "Automation Team");
        }

        return extent;
    }
}