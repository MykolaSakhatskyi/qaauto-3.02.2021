package parentPackages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshoter {

    @Attachment(value = "Screenshot: {0}",type = "image/png")
    static byte[] screenshot(String name) {
        return ((TakesScreenshot) BeforeAfterMethods.treadLocalWebDriver.get()).getScreenshotAs(OutputType.BYTES);
    }
}
