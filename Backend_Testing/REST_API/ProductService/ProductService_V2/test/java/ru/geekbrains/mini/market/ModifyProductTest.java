package ru.geekbrains.mini.market;

import ProductService_V2.db.model.Products;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ModifyProductTest extends AbstractProductTest {

    @SneakyThrows
    @Test
    void modifyProductPositiveTest() {
        Products products = getProductsMapper().selectByPrimaryKey(1L);
        products.setTitle("Water");
        products.setPrice(555);
        getProductsMapper().updateByPrimaryKeySelective(products);

        assertThat(getProductsMapper().selectByPrimaryKey(1L).getTitle(), is("Water"));
        assertThat(getProductsMapper().selectByPrimaryKey(1L).getPrice(), is(555));
    }
}
