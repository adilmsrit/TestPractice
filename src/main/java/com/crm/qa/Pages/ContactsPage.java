package com.crm.qa.Pages;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
        TestUtil testUtil;
    public ContactsPage() {
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLable;

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement checkBox;

    public boolean verifyContactsLable(){
        testUtil = new TestUtil();
        return contactsLable.isDisplayed();
    }

}
