package AccuWeather_V3;

import AccuWeather_V3.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherProvider {

    void getWeather(Periods period) throws IOException, SQLException;
}
