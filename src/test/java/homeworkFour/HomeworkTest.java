package homeworkFour;

import org.testng.annotations.Test;
import pages.LoginPageForHomeWorkFour;
import parentPackages.ParentClassForHomeWorkFour;

public class HomeworkTest extends ParentClassForHomeWorkFour {

    @Test
    public void lesson() {
        LoginPageForHomeWorkFour loginPage = new LoginPageForHomeWorkFour(driver);
        loginPage.login();
    }
}
