package de.karzek.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by MarjanaKarzek on 27.11.2017.
 */

public class SettingsFragment extends Fragment {
    private static final String TAG = "SettingsFragment";

    private Button setCurrentLocation;

    private Button lessForecast;
    private EditText forecastEditText;
    private Button moreForecast;

    private RadioButton celsiusOption;
    private RadioButton fahrenheitOption;

    private Switch pushNotifications;

    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_settings, container, false);

        setCurrentLocation = (Button) view.findViewById(R.id.settings_current_location);
        lessForecast = (Button) view.findViewById(R.id.settings_less_forecast);
        forecastEditText = (EditText) view.findViewById(R.id.settings_forecast_edit_text);
        moreForecast = (Button) view.findViewById(R.id.settings_more_forecast);
        celsiusOption = (RadioButton) view.findViewById(R.id.settings_celsius_option);
        fahrenheitOption = (RadioButton) view.findViewById(R.id.settings_fahrenheit_option);

        sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);

        setupSettingsOnClickListeners();

        return view;
    }

    private void setupSettingsOnClickListeners() {
        setCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLocation();
                Toast.makeText(getContext(), R.string.settings_toast_current_location_set,Toast.LENGTH_LONG);
            }
        });

        lessForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentForecastValue = Integer.valueOf(forecastEditText.getText().toString());
                if(currentForecastValue > 1){
                   forecastEditText.setText("" + (currentForecastValue - 1));
                }
            }
        });

        forecastEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!forecastEditText.getText().toString().equals("")) {
                    int currentForecastValue = Integer.valueOf(forecastEditText.getText().toString());
                    if (currentForecastValue < 1) {
                        forecastEditText.setText(R.string.one);
                    } else if (currentForecastValue > 16) {
                        forecastEditText.setText(R.string.sixteen);
                    }
                } else {
                    forecastEditText.setText(R.string.seven);
                }
            }
        });

        moreForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentForecastValue = Integer.valueOf(forecastEditText.getText().toString());
                if(currentForecastValue < 16){
                    forecastEditText.setText("" + (currentForecastValue + 1));
                }
            }
        });

        celsiusOption.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    fahrenheitOption.setChecked(false);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("SettingsTemperatureMetrics", 0);
                    editor.commit();
                }
            }
        });

        fahrenheitOption.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    celsiusOption.setChecked(false);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("SettingsTemperatureMetrics", 1);
                    editor.commit();
                }
            }
        });
    }

    private void getCurrentLocation() {

    }
}
