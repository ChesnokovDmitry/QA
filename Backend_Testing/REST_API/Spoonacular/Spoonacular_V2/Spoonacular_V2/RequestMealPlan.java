package org.example.Spoonacular_V2;

import java.util.List;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonPropertyOrder({"date", "slot", "position", "type", "value"})
@JsonAutoDetect
@Data
public class RequestMealPlan {
    @JsonProperty("date")
    public Integer date;
    @JsonProperty("slot")
    public Integer slot;
    @JsonProperty("position")
    public Integer position;
    @JsonProperty("type")
    public String type;
    @JsonProperty("value")
    public Value value;

    @JsonPropertyOrder({"ingredients"})
    @Data
    public class Value {
        @JsonProperty("ingredients")
        public List<Ingredient> ingredients;
    }

    @JsonPropertyOrder({"name"})
    @Data
    public class Ingredient {
        @JsonProperty("name")
        public String name;
    }
}
