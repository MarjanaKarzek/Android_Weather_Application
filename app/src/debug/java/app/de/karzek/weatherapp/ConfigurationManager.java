package app.de.karzek.weatherapp;

import timber.log.Timber;

/**
 * Created by MarjanaKarzek on 04.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 04.03.2018
 */

public class ConfigurationManager {

    public ConfigurationManager(){
        initTimber();
    }

    private static void initTimber(){
        Timber.plant(new Timber.DebugTree());
    }
}
