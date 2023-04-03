package org.example;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationTest extends AbstractTest {

    @Test
    void positiveAuthorizationTest() {
        Response response = given().spec(getRequestSpecification())
                .contentType("multipart/form-data")
                .multiPart("username", "GB202301271f419")
                .multiPart("password", "f83466a568")
                .when()
                .post(getBaseUrl()+"gateway/login")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("id"), is(3198));
        assertThat(response.jsonPath().get("token"), is(properties.getProperty("X-Auth-Token")));
    }

    @Test
    void negativeAuthorizationTest() {
        given().spec(getRequestSpecification())
                .contentType("multipart/form-data")
                .multiPart("username", "GB")
                .multiPart("password", "f83466a568")
                .when()
                .post(getBaseUrl()+"gateway/login")
                .then()
                .statusCode(401)
                .extract().response();
    }
}
