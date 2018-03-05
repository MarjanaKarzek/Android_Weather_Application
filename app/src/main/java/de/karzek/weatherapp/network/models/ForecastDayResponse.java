package de.karzek.weatherapp.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Value;

/**
 * Created by MarjanaKarzek on 05.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 05.03.2018
 */

@Value
public class ForecastDayResponse {

    @SerializedName("high")
    @Expose
    private HighResponse temperatureMax;

    @SerializedName("low")
    @Expose
    private LowResponse temperatureMin;

    @SerializedName("conditions")
    @Expose
    private String condition;

    @SerializedName("avewind")
    @Expose
    private AVEWindResponse wind;

    @SerializedName("avehumidity")
    @Expose
    private int humidity;

}
