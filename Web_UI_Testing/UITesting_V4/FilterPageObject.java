package org.example.AllureTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPageObject {
    private WebDriver driver;

    @FindBy(xpath = ".//ul[@id='catalogue-menu']/li[2]/a")
    private WebElement webElement1;

    @FindBy(linkText = "Аквариумы")
    private WebElement webElement2;

    @FindBy(xpath = ".//div[@class='checkbox_item']//label")
    private WebElement webElement3;

    @FindBy(xpath = "//div[@class='checkbox_item']//label[@for='do_10']")
    private WebElement webElement4;

    @FindBy(xpath = ".//div[@class='checkbox_item']//label[@for='morskie']")
    private WebElement webElement5;

    @FindBy(xpath = ".//input[@value='Показать выбранное']")
    private WebElement webElement6;

    public FilterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FilterPageObject clickWebElement1() {
        webElement1.click();
        return this;
    }

    public FilterPageObject clickWebElement2() {
        webElement2.click();
        return this;
    }

    public FilterPageObject clickWebElement3() {
        webElement3.click();
        return this;
    }

    public FilterPageObject clickWebElement4() {
        webElement4.click();
        return this;
    }

    public FilterPageObject clickWebElement5() {
        webElement5.click();
        return this;
    }

    public FilterPageObject clickWebElement6() {
        webElement6.click();
        return this;
    }

    public String getResult() {
        return driver.getCurrentUrl();
    }
}
