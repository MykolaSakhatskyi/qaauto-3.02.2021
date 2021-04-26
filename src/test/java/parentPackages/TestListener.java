package parentPackages;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    private Logger log = Logger.getLogger(this.getClass());
    private String format = "Test %s: %s with parameters %s";

    @Override
    public void onTestStart(ITestResult result) {
        log.info(String.format(format, "started", result.getName(), Arrays.toString(result.getParameters())));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(String.format(format, "passed", result.getName(), Arrays.toString(result.getParameters())));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(String.format(format, "failed", result.getName(), Arrays.toString(result.getParameters())));
        Screenshoter.screenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(String.format(format, "skipped", result.getName(), Arrays.toString(result.getParameters())));

    }

}
