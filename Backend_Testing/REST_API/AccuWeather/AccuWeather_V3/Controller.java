package AccuWeather_V3;

import AccuWeather_V3.database.DatabaseRepository;
import AccuWeather_V3.database.DatabaseRepositorySQLiteImpl;
import AccuWeather_V3.enums.Functionality;
import AccuWeather_V3.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    DatabaseRepository repository = new DatabaseRepositorySQLiteImpl();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_DATA_BASE);
        variantResult.put(4, Functionality.EXIT);
    }

    public void onUserInput(String input) throws IOException, SQLException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_DATA_BASE:
                getWeatherFromDB();
                break;
            case EXIT:
                exitApp();
                break;
        }
    }

    public void getCurrentWeather() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }

    public void getWeatherFromDB() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.BASE);
    }

    public void exitApp() {
        System.out.println("Завершаю работу");
        repository.closeConnection();
        System.exit(4);
    }
}