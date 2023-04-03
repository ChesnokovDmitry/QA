package ru.geekbrains.mini.market.ProductService_V1Test;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.mini.market.ProductService_V1.dto.Product;
import ru.geekbrains.mini.market.ProductService_V1.service.ProductService;
import ru.geekbrains.mini.market.ProductService_V1.util.RetrofitUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateDeleteProductTest {
    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils
                .getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withPrice((int) (Math.random() * 10000))
                .withCategoryTitle("Food");
    }

    @Test
    @SneakyThrows
    void createProductInFoodCategoryTest() {
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), CoreMatchers.is(201));
        assertThat(response.headers().get("content-type"), CoreMatchers.is("application/json"));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<ResponseBody> response = productService
                .deleteProduct(id)
                .execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}
