package parentPackages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

public class Screenshoter {

    @Attachment(value = "Screenshot: {0}",type = "image/png")
    static byte[] screenshot(String name) {
        //return ((TakesScreenshot) Object.requireNonNull(WebDriverRunner.getSelenideProxy())).getScreenshotAs(OutputType.BYTES); - еще вариант для скриншотов, комент для меня!
        return Selenide.screenshot(OutputType.BYTES);
    }
}
