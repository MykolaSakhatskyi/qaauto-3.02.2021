package parentPackages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class ParentClass {

    protected WebDriver driver;

    Logger log = Logger.getLogger(this.getClass());

    protected ParentClass(WebDriver driver) {
        PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
