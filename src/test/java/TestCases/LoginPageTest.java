package TestCases;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.verifyLoginPageTitle();
        Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
        System.out.println("The title is as : " + title);
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateImage();
        Assert.assertEquals(flag, true);
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData("D:\\testdata.xlsx", "Sheet1");
        return data;
    }

    @Test(priority = 3, dataProvider = "getTestData")
    public void loginTest(String username, String password) throws InterruptedException {
       // loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.login(username,password);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
