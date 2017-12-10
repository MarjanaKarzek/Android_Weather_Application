package de.karzek.weatherapp.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by MarjanaKarzek on 10.12.2017.
 */

public class WeatherAppApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        ActiveAndroid.initialize(this);
    }
}
