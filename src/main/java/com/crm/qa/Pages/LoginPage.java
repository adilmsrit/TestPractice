package com.crm.qa.Pages;

import com.crm.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Initialization
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // Page Factory:
    //Below changes to username has been done to test the takescreen shot method.
    @FindBy(name = "username")
    @CacheLookup
    WebElement username;


    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    // com.Actions...


    public String verifyLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateImage() {
        return crmLogo.isDisplayed();
    }


    public HomePage login(String usr, String pwd) throws InterruptedException {
        username.sendKeys(usr);
        password.sendKeys(pwd);
        Thread.sleep(3000);
        loginBtn.submit();
        return new HomePage();
    }
}
