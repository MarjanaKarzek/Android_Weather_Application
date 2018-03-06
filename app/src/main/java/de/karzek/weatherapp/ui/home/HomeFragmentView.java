package de.karzek.weatherapp.ui.home;

import java.util.List;

import de.karzek.weatherapp.database.models.WeatherDay;

/**
 * Created by MarjanaKarzek on 03.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 03.03.2018
 */

public interface HomeFragmentView {

    void displayWeather(List<WeatherDay> weatherList);

    void displayNoWeatherFound();
}
