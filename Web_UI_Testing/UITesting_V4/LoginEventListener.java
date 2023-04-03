package org.example.AllureTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginEventListener extends AllureAbstractTest {

    @Test
    @Description("Авторизация пользователя")
    public void basketTest() {
        LoginPageObject loginPageObject = new LoginPageObject(getWebDriver())
                .clickWebElement1()
                .clickWebElement2()
                .sendKeysWebElement2()
                .clickWebElement3()
                .sendKeysWebElement3()
                .clickWebElement4();
        Assertions.assertEquals("https://www.aqua-shop.ru/account.php",
                loginPageObject.getResult());
    }
}
