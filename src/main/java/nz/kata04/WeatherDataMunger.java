package nz.kata04;

import static nz.kata04.WeatherData.newWeatherData;

import java.util.List;
import java.util.Optional;

class WeatherDataMunger extends Munger<WeatherData> {

    private WeatherDataMunger(List<String> list) {
        super(list);
    }

    static WeatherDataMunger newWeatherDataMunger(List<String> lines) {
        return new WeatherDataMunger(lines);
    }

    @Override
    Optional<WeatherData> newData(String line) {
        return newWeatherData(line);
    }
}
