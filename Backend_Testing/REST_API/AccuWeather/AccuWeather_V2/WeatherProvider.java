package AccuWeather_V2;

import AccuWeather_V2.enums.Periods;
import java.io.IOException;

public interface WeatherProvider {

    public void getWeather(Periods period) throws IOException;
}
