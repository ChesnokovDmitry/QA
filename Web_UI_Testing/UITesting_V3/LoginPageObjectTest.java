package org.example.PageFactoryTest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LoginPageObjectTest extends AbstractPageObjectTest {

    @Test
    public void basketTest() {
        LoginPageObject loginPageObject = new LoginPageObject(getDriver())
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
