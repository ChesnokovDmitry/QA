package org.example.AllureTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPageObject {
    private WebDriver driver;

    @FindBy(xpath = ".//div[@class='catalogue-menu-block']/ul/li[2]/a")
    private WebElement webElement1;

    @FindBy(css = ".category-menu-item__specification")
    private WebElement webElement2;

    @FindBy(xpath = ".//span[@pid='17873']")
    private WebElement webElement3;

    @FindBy(xpath = ".//a[@class='simple-button']")
    private WebElement webElement4;

    @FindBy(xpath = ".//span[@id='basket']")
    private WebElement result;

    public BasketPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasketPageObject clickWebElement1() {
        webElement1.click();
        return this;
    }

    public BasketPageObject clickWebElement2() {
        webElement2.click();
        return this;
    }

    public BasketPageObject clickWebElement3() {
        webElement3.click();
        return this;
    }

    public BasketPageObject clickWebElement4() {
        webElement4.click();
        return this;
    }

    public String getResult() {
        return result.getText();
    }
}
