package org.example.PageFactoryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObject {
    private WebDriver driver;
    private final String filter = "фильтры";

    @FindBy(xpath = ".//input[@id='search_input']")
    private WebElement webElement1;

    @FindBy(className = "find-button")
    private WebElement webElement2;

    @FindBy(xpath = ".//h1[@class='h1_prodcard']")
    private WebElement result;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPageObject sendKeysWebElement1() {
        webElement1.sendKeys(filter);
        return this;
    }

    public SearchPageObject clickWebElement2() {
        webElement2.click();
        return this;
    }

    public String getResult() {
        return result.getText();
    }
}
