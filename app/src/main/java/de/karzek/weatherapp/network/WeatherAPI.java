package de.karzek.weatherapp.network;

import de.karzek.weatherapp.network.models.WeatherDayResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by MarjanaKarzek on 05.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 05.03.2018
 */

public interface WeatherAPI {

    String BASE_URL = "http://api.wunderground.com/api/";

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<WeatherDayResponse> getWeatherDayData();
}
