package org.example;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyPostsTest extends AbstractTest {

    @Test
    void getStatusCode200Test() {
        Response response = given().spec(getRequestSpecification())
                .header("X-Auth-Token", "deaa2e3e25fffa963267db85779d6bd6")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 1)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test
    void getStatusCode403Test() {
        Response response = given().spec(getRequestSpecification())
                .header("X-Auth-Token", "deaa2e3e25fffa963267db85779d6bd6")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 1)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .statusCode(403)
                .extract().response();

        assertThat(response.jsonPath().get("error"), is("critical"));
    }
}
