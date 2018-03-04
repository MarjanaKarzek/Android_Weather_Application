package de.karzek.weatherapp.application;

import android.app.Application;

import app.de.karzek.weatherapp.ConfigurationManager;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by MarjanaKarzek on 10.12.2017.
 */

public class WeatherAppApplication extends Application {

    private static ConfigurationManager configurationManager;

    @Override
    public void onCreate(){
        super.onCreate();

        configurationManager = new ConfigurationManager();

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
