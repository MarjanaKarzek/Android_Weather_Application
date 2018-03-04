package de.karzek.weatherapp.database;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;

import de.karzek.weatherapp.database.models.Location;
import de.karzek.weatherapp.database.models.WeatherDay;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by MarjanaKarzek on 04.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 04.03.2018
 */
public class DatabaseHelper {

    private static DatabaseHelper instance;
    private final Realm realm;

    public DatabaseHelper(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static DatabaseHelper with(Fragment fragment) {
        if (instance == null) {
            instance = new DatabaseHelper(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static DatabaseHelper with(Activity activity) {
        if (instance == null) {
            instance = new DatabaseHelper(activity.getApplication());
        }
        return instance;
    }

    public static DatabaseHelper with(Application application) {
        if (instance == null) {
            instance = new DatabaseHelper(application);
        }
        return instance;
    }

    public static DatabaseHelper getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    /**
     * Refresh the realm instance
     */
    public void refresh() {
        realm.refresh();
    }

    //MARK: Location

    /**
     * Deletes all locations from Location.class
     */
    public void clearAllLocations() {
        realm.beginTransaction();
        realm.clear(Location.class);
        realm.commitTransaction();
    }

    /**
     * find all objects in the Location.class
     */
    public RealmResults<Location> getLocations() {
        return realm.where(Location.class).findAll();
    }

    /**
     * query a single item with the given id
     */
    public Location getLocation(String id) {
        return realm.where(Location.class).equalTo("id", id).findFirst();
    }

    /**
     * check if Location.class is empty
     */
    public boolean hasLocations() {
        return !realm.allObjects(Location.class).isEmpty();
    }

    //MARK: WeatherDay

    /**
     * Deletes all WeatherDays from WeatherDay.class
     */
    public void clearAllWeatherDays() {
        realm.beginTransaction();
        realm.clear(WeatherDay.class);
        realm.commitTransaction();
    }

    /**
     * find all objects in the WeatherDay.class
     */
    public RealmResults<WeatherDay> getWeatherDays() {
        return realm.where(WeatherDay.class).findAll();
    }

    /**
     * query a single item with the given id
     */
    public WeatherDay getWeatherDay(String id) {
        return realm.where(WeatherDay.class).equalTo("id", id).findFirst();
    }

    /**
     * check if WeatherDay.class is empty
     */
    public boolean hasWeatherDays() {
        return !realm.allObjects(WeatherDay.class).isEmpty();
    }

    //query example
    /*public RealmResults<WeatherDay> queryedLocations() {
        return realm.where(WeatherDay.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();
    }*/
}
