package homeworkFour;

import org.testng.annotations.Test;

public class homeworkTest extends ParentClass{

    @Test
    public void lesson() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }
}
