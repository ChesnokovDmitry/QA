package AccuWeather_V3;

public class WeatherData {

    private String city;
    private String localDate;
    private Float minTemperature;
    private Float maxTemperature;

    public WeatherData() {
    }

    public WeatherData(String city, String localDate, Float minTemperature, Float maxTemperature) {
        this.city = city;
        this.localDate = localDate;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getCity() {
        return city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public Float getMinTemperature() {
        return minTemperature;
    }

    public Float getMaxTemperature() {
        return maxTemperature;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}
