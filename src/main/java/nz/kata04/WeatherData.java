package nz.kata04;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WeatherData {

    private static final Pattern split = Pattern.compile("\\s+(\\d+)\\s+(\\d+)\\*?\\s+(\\d+)");

    private final int day;
    private final int min;
    private final int max;

    private WeatherData(int day, int min, int max) {
        this.day = day;
        this.min = min;
        this.max = max;
    }

    static Optional<WeatherData> newWeatherData(String line) {
        Matcher matcher = split.matcher(line);
        if (matcher.find()) {
            int day = Integer.parseInt(matcher.group(1));
            int max = Integer.parseInt(matcher.group(2));
            int min = Integer.parseInt(matcher.group(3));
            return Optional.of(new WeatherData(day, min, max));
        }
        return Optional.empty();
    }

    int getDay() {
        return day;
    }

    int getMin() {
        return min;
    }

    int getMax() {
        return max;
    }
}
