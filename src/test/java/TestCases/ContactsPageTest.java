package TestCases;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Utils.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactsPage=homePage.clickOnContacts();
    }


    @Test(priority = 1)
    public void verifycontactsPageLableTest() {
        homePage.clickOnContacts();
        contactsPage.verifyContactsLable();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
