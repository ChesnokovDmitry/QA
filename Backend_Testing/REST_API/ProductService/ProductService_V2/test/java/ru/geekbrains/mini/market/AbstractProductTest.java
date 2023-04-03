package ru.geekbrains.mini.market;

import ProductService_V2.db.dao.ProductsMapper;
import ProductService_V2.db.model.ProductsExample;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
public abstract class AbstractProductTest {
    private static SqlSession session = null;
    private static final String resource = "mybatis-config.xml";
    private static ProductsMapper productsMapper;
    private static ProductsExample productsExample;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        productsMapper = session.getMapper(ProductsMapper.class);
        productsExample = new ProductsExample();
    }

    @SneakyThrows
    @AfterAll
    static void afterAll() {
        session.commit();
        session.close();
    }

    public static ProductsMapper getProductsMapper() {
        return productsMapper;
    }

    public static ProductsExample getProductsExample() {
        return productsExample;
    }
}
