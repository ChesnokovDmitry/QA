package org.example.PageFactoryTest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SearchPageObjectTest extends AbstractPageObjectTest {

    @Test
    public void basketTest() {
        SearchPageObject searchPageObject = new SearchPageObject(getDriver())
                .sendKeysWebElement1()
                .clickWebElement2();
        Assertions.assertEquals("Результаты поиска по запросу \"фильтры\"", searchPageObject.getResult());
    }
}
