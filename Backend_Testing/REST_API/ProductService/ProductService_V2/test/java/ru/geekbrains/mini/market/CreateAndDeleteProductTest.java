package ru.geekbrains.mini.market;

import ProductService_V2.db.model.Products;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateAndDeleteProductTest extends AbstractProductTest {
    private Products products;

    @SneakyThrows
    @Test
    void createProductPositiveTest() {
        products = new Products();
        products.setTitle("Phone2");
        products.setPrice(99);
        products.setCategory_id(2L);
        getProductsMapper().insert(products);

        getProductsExample().createCriteria().andTitleEqualTo("Phone2")
                .andPriceEqualTo(99)
                .andCategory_idEqualTo(2L);

        assertThat(getProductsMapper().selectByExample(getProductsExample()).get(0).getTitle(), is("Phone2"));
        assertThat(getProductsMapper().selectByExample(getProductsExample()).get(0).getPrice(), is(99));
        assertThat(getProductsMapper().selectByExample(getProductsExample()).get(0).getCategory_id(), is(2L));
    }

    @AfterEach
    void delete() {
        getProductsMapper().deleteByPrimaryKey(products.getId());
    }
}
