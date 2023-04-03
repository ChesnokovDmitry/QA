package org.example.TestedClassesLesson4.MealPlan;

import org.example.Spoonacular_V2.RequestMealPlan;
import org.example.TestedClassesLesson4.AbstractMealPlanAndShoppingListTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class MealPlanTest extends AbstractMealPlanAndShoppingListTest {

    @Test
    void addDeleteFromMealPlanTest() {
        RequestMealPlan requestMealPlan = new RequestMealPlan();
        requestMealPlan.setDate(1589500800);
        requestMealPlan.setSlot(1);
        requestMealPlan.setPosition(0);
        requestMealPlan.setType("INGREDIENTS");
        RequestMealPlan.Value value = requestMealPlan.new Value();
        requestMealPlan.setValue(value);
        value.setIngredients(new ArrayList<>());
        RequestMealPlan.Ingredient ingredient = requestMealPlan.new Ingredient();
        ingredient.setName("1 banana");
        requestMealPlan.getValue().getIngredients().add(ingredient);

        String id = given().spec(getRequestSpecification()).body(requestMealPlan)
                .when()
                .post(getBaseUrl()+"mealplanner/{username}/items")
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response()
                .jsonPath()
                .get("id")
                .toString();

        given().spec(getRequestSpecification())
                .when()
                .delete(getBaseUrl()+"mealplanner/{username}/items/" + id)
                .then()
                .spec(getResponseSpecification());
    }
}
