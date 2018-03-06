package de.karzek.weatherapp.ui.home;

import java.util.List;

import de.karzek.weatherapp.database.models.WeatherDay;
import de.karzek.weatherapp.repositories.WeatherRepository;

/**
 * Created by MarjanaKarzek on 03.03.2018.
 */

public class HomeFragmentPresenter {

    private HomeFragmentView view;
    private WeatherRepository weatherRepository;

    public HomeFragmentPresenter(HomeFragmentView view, WeatherRepository weatherRepository){
        this.view = view;
        this.weatherRepository = weatherRepository;
    }

    public void loadWeather() {
        List<WeatherDay> weatherList = weatherRepository.getWeather();
        if(weatherList.isEmpty())
            view.displayNoWeatherFound();
        else
            view.displayWeather(weatherList);
    }
}
