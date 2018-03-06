package de.karzek.weatherapp.ui.home;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.karzek.weatherapp.database.models.WeatherDay;
import de.karzek.weatherapp.repositories.WeatherRepository;

/**
 * Created by MarjanaKarzek on 03.03.2018.
 *
 * @author Marjana Karzek
 * @version 2.0
 * @date 05.03.2018
 */
public class HomeFragmentPresenterTest {

    @Test
    public void shouldPassWeatherToView(){
        //given
        HomeFragmentView view = new MockView();
        WeatherRepository weatherRepository = new MockWeatherRepository(true);

        //when
        HomeFragmentPresenter presenter = new HomeFragmentPresenter(view, weatherRepository);
        presenter.loadWeather();

        //then
        Assert.assertEquals(true, ((MockView)view).passedDisplayWeather);
    }

    @Test
    public void shouldHandleNoWeatherFound(){
        HomeFragmentView view = new MockView();
        WeatherRepository weatherRepository = new MockWeatherRepository(false);

        HomeFragmentPresenter presenter = new HomeFragmentPresenter(view, weatherRepository);
        presenter.loadWeather();

        Assert.assertEquals(true, ((MockView)view).passedDisplayNoWeatherFound);
    }


    private class MockView implements HomeFragmentView {

        boolean passedDisplayWeather;
        boolean passedDisplayNoWeatherFound;

        @Override
        public void displayWeather(List<WeatherDay> weatherList) {
            if(weatherList.size() == 3)
                passedDisplayWeather = true;
        }

        @Override
        public void displayNoWeatherFound() {
            passedDisplayNoWeatherFound = true;
        }
    }

    private class MockWeatherRepository implements WeatherRepository {

        private boolean returnWeather;

        public MockWeatherRepository(boolean returnWeather){
            this.returnWeather = returnWeather;
        }

        @Override
        public List<WeatherDay> getWeather() {
            if(returnWeather) {
                return Arrays.asList(new WeatherDay(), new WeatherDay(), new WeatherDay());
            } else {
                return Collections.emptyList();
            }
        }
    }
}