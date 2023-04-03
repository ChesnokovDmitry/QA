package ru.geekbrains.mini.market;

import ProductService_V2.db.dao.CategoriesMapper;
import ProductService_V2.db.model.Categories;
import ProductService_V2.db.model.CategoriesExample;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class GetCategoryTest {
	static SqlSession session = null;
	static String resource = "mybatis-config.xml";
	static SqlSessionFactory sqlSessionFactory;
	static CategoriesMapper categoriesMapper;
	static CategoriesExample example;

	@SneakyThrows
	@BeforeAll
	static void beforeAll() {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		categoriesMapper = session.getMapper(CategoriesMapper.class);
		example = new CategoriesExample();
	}

	@SneakyThrows
	@Test
	void getCategoryByCriterionPositiveTest() {
		example.createCriteria().andIdGreaterThanOrEqualTo(1L)
				.andTitleEqualTo("Electronic");
		List<Categories> list = categoriesMapper.selectByExample(example);

		assertThat(list.get(0).getId(), equalTo(2));
		assertThat(list.get(0).getTitle(), is("Electronic"));
	}

	@SneakyThrows
	@AfterAll
	@Test
	static void afterAll() {
		session.commit();
		session.close();
	}
}
