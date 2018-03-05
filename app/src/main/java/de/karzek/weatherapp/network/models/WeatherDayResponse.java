package de.karzek.weatherapp.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Value;

/**
 * Created by MarjanaKarzek on 05.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 05.03.2018
 */
@Value
public class WeatherDayResponse {

    @SerializedName("location")
    @Expose
    private LocationResponse location;

    @SerializedName("forecast")
    @Expose
    private ForecastResponse forecast;

}
