package de.karzek.weatherapp.application;

import android.app.Application;

import app.de.karzek.weatherapp.ConfigurationManager;

/**
 * Created by MarjanaKarzek on 10.12.2017.
 *
 * @author Marjana Karzek
 * @version 1.1
 * @date 04.03.2018
 */
public class WeatherAppApplication extends Application {

    private static ConfigurationManager configurationManager;

    @Override
    public void onCreate(){
        super.onCreate();

        configurationManager = new ConfigurationManager(this);
    }
}
