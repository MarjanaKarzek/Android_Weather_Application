package de.karzek.weatherapp.utils;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import de.karzek.weatherapp.database.models.WeatherDay;
import timber.log.Timber;

/**
 * Created by MarjanaKarzek on 10.12.2017.
 *
 * @author Marjana Karzek
 * @version 1.1
 * @date 04.03.2018
 *
 */
public class WeatherHelper {
    private static final String WUNDERGROUND_API = "http://api.wunderground.com/api/";
    private static final String WUNDERGROUND_API_KEY = "a3edc522039a106f";

    private static final String WUNDERGROUND_FORECAST = "/forecast";
    private static final String WUNDERGROUND_FORECAST_TEN = "/forecast10day";
    private static final String WUNDERGROUND_FORECAST_HOURLY = "/hourly";
    private static final String WUNDERGROUND_GEOLOOKUP = "/geolookup";
    private static final String WUNDERGROUND_EXTRA = "/q";

    private static WeatherHelper self = new WeatherHelper();

    private WeatherHelper(){ }

    public static WeatherHelper getInstance(){
        return self;
    }

    public static WeatherDay getWeatherDataOfToday(String latitude, String longitude){
        try{
            String call = WUNDERGROUND_API + WUNDERGROUND_API_KEY + WUNDERGROUND_FORECAST + WUNDERGROUND_GEOLOOKUP + WUNDERGROUND_EXTRA + latitude + "," + longitude + ".json";
            URL url = new URL(call);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null){
                json.append(tmp).append("\n");
            }
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            int successCode = connection.getResponseCode();
            if(successCode != 200){
                Timber.d("Weather retrieval failed with error code %i", successCode);
                return null;
            } else {
                WeatherDay currentWeather = new WeatherDay();

                currentWeather.setLatitude(latitude);
                currentWeather.setLongitude(longitude);
                currentWeather.setLocationName("bla");

                return currentWeather;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Timber.d("Unexpected error");
        }
    }
}
