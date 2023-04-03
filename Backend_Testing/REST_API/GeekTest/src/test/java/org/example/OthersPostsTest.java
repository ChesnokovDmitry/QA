package org.example;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OthersPostsTest extends AbstractTest {

    @Test
    void getOthersPostsTest() {
        Response response = given().spec(getRequestSpecification())
                .header("X-Auth-Token", "deaa2e3e25fffa963267db85779d6bd6")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 9)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("data.length"), notNullValue());
    }

    @Test
    void getStatusCodeTest() {
        Response response = given().spec(getRequestSpecification())
                .header("X-Auth-Token", "deaa2e3e25fffa963267db85779d6bd6")
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", 9)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .statusCode(403)
                .extract().response();

        assertThat(response.jsonPath().get("error"), is("critical"));
    }
}
