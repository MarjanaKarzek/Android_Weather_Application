package de.karzek.weatherapp.repositories.implementations;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import de.karzek.weatherapp.database.DatabaseHelper;
import de.karzek.weatherapp.database.models.WeatherDay;
import de.karzek.weatherapp.network.WeatherAPI;
import de.karzek.weatherapp.network.models.ForecastResponse;
import de.karzek.weatherapp.network.models.LocationResponse;
import de.karzek.weatherapp.network.models.WeatherDayResponse;
import de.karzek.weatherapp.repositories.WeatherRepository;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by MarjanaKarzek on 06.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 06.03.2018
 */

public class WeatherRepositoryDatabaseImpl implements WeatherRepository{

    //private Retrofit retrofit;
    //private String BASE_URL = "http://api.wunderground.com/api/";

    public WeatherRepositoryDatabaseImpl() {
        /*retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        Call<WeatherDayResponse> call = weatherAPI.getWeatherDayData();

        call.enqueue(new Callback<WeatherDayResponse>() {
            @Override
            public void onResponse(Call<WeatherDayResponse> call, Response<WeatherDayResponse> response) {
                Timber.d("onResponse: Server Response " + response.toString());
                Timber.d("onResponse: received information " + response.body().toString());

                ForecastResponse forecast = response.body().getForecast();
                LocationResponse location = response.body().getLocation();
                location.getCity();
            }

            @Override
            public void onFailure(Call<WeatherDayResponse> call, Throwable t) {
                Timber.e("onFailure: Unknown error in network connection");
            }
        });*/
    }

    @Override
    public List<WeatherDay> getWeather() {
        return Arrays.asList(new WeatherDay(), new WeatherDay(), new WeatherDay()); //DatabaseHelper.getInstance().getWeatherDays();
    }
}
