package nz.kata04;

import static nz.kata04.WeatherData.newWeatherData;

import java.util.ArrayList;
import java.util.List;

class WeatherDataMunger {

    private final List<WeatherData> list;

    private WeatherDataMunger(List<WeatherData> list) {
        this.list = List.copyOf(list);
    }

    static WeatherDataMunger newWeatherDataMunger(List<String> lines) {
        return new WeatherDataMunger(listOfWeather(lines));
    }

    private static List<WeatherData> listOfWeather(List<String> lines) {
        List<WeatherData> data = new ArrayList<>(lines.size());
        for (String line : lines) {
            newWeatherData(line).ifPresent(data::add);
        }
        return data;
    }

    int smallestSpread() {
        int day = -1;
        int smallest = Integer.MAX_VALUE;
        for (WeatherData data : list) {
            int difference = data.getMax() - data.getMin();
            if (smallest > difference) {
                smallest = difference;
                day = data.getDay();
            }
        }
        return day;
    }
}
