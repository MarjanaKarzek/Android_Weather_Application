package de.karzek.weatherapp.repositories;

import java.util.List;

import de.karzek.weatherapp.database.models.WeatherDay;

/**
 * Created by MarjanaKarzek on 03.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 03.03.2018
 */

public interface WeatherRepository {

    List<WeatherDay> getWeather();

}
