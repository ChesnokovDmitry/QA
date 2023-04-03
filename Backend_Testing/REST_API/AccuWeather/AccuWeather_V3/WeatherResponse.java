package AccuWeather_V3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import AccuWeather_V3.database.DatabaseRepository;
import AccuWeather_V3.database.DatabaseRepositorySQLiteImpl;

import java.sql.*;

public class WeatherResponse {
    private final ObjectMapper objectMapper;
    private final String response;
    /*private static Connection connection;
    private static Statement statement;*/

    private final DatabaseRepository repository = new DatabaseRepositorySQLiteImpl();

    public WeatherResponse(ObjectMapper objectMapper, String response) {
        this.objectMapper = objectMapper;
        this.response = response;
    }

    public void weatherText() throws JsonProcessingException, SQLException {
        JsonNode weatherText = objectMapper.readTree(getResponse());
        String date = weatherText.get(0).at("/LocalObservationDateTime").asText();
        float min = Math.round((Float.parseFloat(weatherText.get(0).at("/Temperature/Metric/Value").asText()) - 32) * 5 / 9);
        float max = Math.round((Float.parseFloat(weatherText.get(0).at("/Temperature/Imperial/Value").asText()) - 32) * 5 / 9);

        System.out.println("Сегодня " + date.substring(0, 10) + " " + weatherText.get(0).at("/WeatherText") +
                ", Температура от " + min + " до " + max);

        WeatherData weatherData = new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),
                date.substring(0,10), min,  max);

        repository.saveWeatherData(weatherData);

        /*connection = DriverManager.getConnection("jdbc:sqlite:application.db");
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " | " +
                            resultSet.getString(2) + " | " +
                            resultSet.getString(3) + " | " +
                            resultSet.getDouble(4) + " | " +
                            resultSet.getDouble(5) + " | ");
        }*/
    }

    public void dailyForecasts() throws JsonProcessingException, SQLException {
        JsonNode dailyForecasts = objectMapper.readTree(getResponse()).at("/DailyForecasts");

        for (int i = 0; i < 5; i++) {
            String date = dailyForecasts.get(i).at("/Date").asText();
            String phrase = dailyForecasts.get(i).at("/Day/IconPhrase").asText();
            float min = Math.round((Float.parseFloat(dailyForecasts.get(i).at("/Temperature/Minimum/Value").asText()) - 32) * 5 / 9);
            float max = Math.round((Float.parseFloat(dailyForecasts.get(i).at("/Temperature/Maximum/Value").asText()) - 32) * 5 / 9);

            System.out.println(" на " + date.substring(0, 10) + " ожидается " + phrase +
                    ", Температура от " + min + " до " + max);

            WeatherData weatherData = new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),
                    date.substring(0,10), min,  max);

            repository.saveWeatherData(weatherData);
        }
    }



    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public String getResponse() {
        return response;
    }
}