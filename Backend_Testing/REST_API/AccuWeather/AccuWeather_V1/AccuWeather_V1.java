package AccuWeather_V1;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AccuWeather {
    public static void main(String[] args) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("474212_PC")
                .addQueryParameter("apikey", "AdGheWVuLR7VyznD7xT37Hobuxu2Xlhq")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url);

        Request requestHttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        System.out.println(jsonResponse);
    }
}
