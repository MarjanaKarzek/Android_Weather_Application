package app.de.karzek.weatherapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

/**
 * Created by MarjanaKarzek on 04.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 04.03.2018
 */

public class ConfigurationManager {

    public ConfigurationManager(Application application){
        initTimber();
        initRealm(application);
    }

    private static void initTimber(){
        Timber.plant(new Timber.DebugTree());
    }

    private static void initRealm(Application application) {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(application)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
