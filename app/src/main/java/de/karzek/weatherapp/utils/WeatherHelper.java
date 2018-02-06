package de.karzek.weatherapp.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MarjanaKarzek on 10.12.2017.
 */
public class WeatherHelper {
    private static final String TAG = "WeatherHelper";
    private static final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String OPEN_WEATHER_MAP_API_KEY = "4f9bae5ce9145c88b9f34f68f3e4db45";

    private static WeatherHelper self = new WeatherHelper();

    private WeatherHelper(){ }

    public static WeatherHelper getInstance(){
        return self;
    }

    public static JSONObject getWeatherData(String longitude, String latitude){
        try{
            String call = OPEN_WEATHER_MAP_API + "lat=" + latitude + "&lon=" + longitude;
            URL url = new URL(call);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("x-api-key", OPEN_WEATHER_MAP_API_KEY);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null){
                json.append(tmp).append("\n");
            }
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            if(data.getInt("cod") != 200){
                return null;
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
