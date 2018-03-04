package de.karzek.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.karzek.weatherapp.ui.home.HomeFragment;

/**
 * Created by MarjanaKarzek on 27.11.2017.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_main);

        setupFragments();
        checkForSharedPreferences();
    }

    private void setupFragments() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, homeFragment);
        fragmentTransaction.commit();
    }

    private void checkForSharedPreferences() {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        if(sharedPreferences.getInt("SettingsDaysOfWeatherForecast", -1) == -1){
            //no default preferences available
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("SettingsDaysOfWeatherForecast", 7);
            editor.putInt("SettingsTemperatureMetrics", 0);
            editor.putBoolean("SettingsDailyPushNotifications", false);
            editor.commit();
        }
    }
}
