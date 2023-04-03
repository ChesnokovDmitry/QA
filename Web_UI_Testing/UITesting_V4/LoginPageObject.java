package org.example.AllureTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
    private WebDriver driver;
    private final String email = "dmitrijchesy@ya.ru";
    private final String password = "qwertyuiop";

    @FindBy(className = "_account")
    private WebElement webElement1;

    @FindBy(id = "email_address")
    private WebElement webElement2;

    @FindBy(id = "password")
    private WebElement webElement3;

    @FindBy(xpath = ".//input[@value='Войти']")
    private WebElement webElement4;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageObject clickWebElement1() {
        webElement1.click();
        return this;
    }

    public LoginPageObject clickWebElement2() {
        webElement2.click();
        return this;
    }

    public LoginPageObject sendKeysWebElement2() {
        webElement2.sendKeys(email);
        return this;
    }

    public LoginPageObject clickWebElement3() {
        webElement3.click();
        return this;
    }

    public LoginPageObject sendKeysWebElement3() {
        webElement3.sendKeys(password);
        return this;
    }

    public LoginPageObject clickWebElement4() {
        webElement4.click();
        return this;
    }

    public String getResult() {
        return driver.getCurrentUrl();
    }
}
