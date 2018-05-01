package TestCases;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String title = homePage.verifyHomePage();
        Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        testUtil.switchToFrame();
        String title = homePage.verifyUsername();
        Assert.assertEquals(title, "  User: M N", "Username not matched");
    }

    @Test(priority = 3)
    public void verifyContactsTest() {
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContacts();
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
