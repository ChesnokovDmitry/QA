package AccuWeather_V2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherResponse {
    private final ObjectMapper objectMapper;
    private final String response;

    public WeatherResponse(ObjectMapper objectMapper, String response) {
        this.objectMapper = objectMapper;
        this.response = response;
    }

    public void weatherText() throws JsonProcessingException {
        JsonNode weatherText = objectMapper.readTree(getResponse());
        float min = (Float.parseFloat(weatherText.get(0).at("/Temperature/Metric/Value").asText()) - 32) * 5 / 9;
        float max = (Float.parseFloat(weatherText.get(0).at("/Temperature/Imperial/Value").asText()) - 32) * 5 / 9;

        System.out.println(weatherText.get(0).at("/WeatherText") + ", Температура от " + Math.round(min) + " до " + Math.round(max));
    }

    public void dailyForecasts() throws JsonProcessingException {
        JsonNode dailyForecasts = objectMapper.readTree(getResponse()).at("/DailyForecasts");

        for (int i = 0; i < 5; i++) {
            String date = dailyForecasts.get(i).at("/Date").asText();
            String phrase = dailyForecasts.get(i).at("/Day/IconPhrase").asText();
            float min = (Float.parseFloat(dailyForecasts.get(i).at("/Temperature/Minimum/Value").asText()) - 32) * 5 / 9;
            float max = (Float.parseFloat(dailyForecasts.get(i).at("/Temperature/Maximum/Value").asText()) - 32) * 5 / 9;

            System.out.println(" на " + date + " ожидается " + phrase + ", Температура от " + Math.round(min) + " до " + Math.round(max));
        }
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public String getResponse() {
        return response;
    }
}