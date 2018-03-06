package de.karzek.weatherapp.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import de.karzek.weatherapp.MapFragment;
import de.karzek.weatherapp.R;
import de.karzek.weatherapp.SettingsFragment;
import de.karzek.weatherapp.database.models.WeatherDay;
import de.karzek.weatherapp.repositories.implementations.WeatherRepositoryDatabaseImpl;
import timber.log.Timber;

/**
 * Created by MarjanaKarzek on 27.11.2017.
 *
 * @author Marjana Karzek
 * @version 1.1
 * @date 04.03.2018
 */

public class HomeFragment extends Fragment implements HomeFragmentView {
    private static final String TAG = "HomeFragment";

    private View view;
    private HomeFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_home, container, false);

        presenter = new HomeFragmentPresenter(this, new WeatherRepositoryDatabaseImpl());
        presenter.loadWeather();

        setupMenuButtons();
        setupLocationButton();
        setupForecastList();

        return view;
    }

    private void setupForecastList() {
        RecyclerView dailyForecastList = view.findViewById(R.id.daily_forecast_list);
    }

    private void setupLocationButton() {
        //ToDo crop placeholder image
    }

    private void setupMenuButtons() {
        Button settingsButton = view.findViewById(R.id.settings_button);
        Button searchButton = view.findViewById(R.id.search_button);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                SettingsFragment settingsFragment = new SettingsFragment();
                fragmentTransaction.replace(R.id.fragmentContainer, settingsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                MapFragment mapFragment = new MapFragment();
                fragmentTransaction.replace(R.id.fragmentContainer, mapFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void displayWeather(List<WeatherDay> weatherList) {
        Timber.d("weather found: " + weatherList.toString());
    }

    @Override
    public void displayNoWeatherFound() {
        Timber.d("weather is empty");
    }
}
