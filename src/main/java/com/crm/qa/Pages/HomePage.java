package com.crm.qa.Pages;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    TestUtil testUtil;
    public HomePage() {
        //initialization required for page factory.
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//td[contains(text(),'M N')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    public String verifyHomePage() {
        return driver.getTitle();
    }

    public String verifyUsername() {
        return userNameLabel.getText();
    }

    public ContactsPage clickOnContacts() {
        testUtil = new TestUtil();
        testUtil.switchToFrame();
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickondealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickonTaskLink() {
        tasksLink.click();
        return new TaskPage();
    }

}
