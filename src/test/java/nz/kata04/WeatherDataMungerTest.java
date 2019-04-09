package nz.kata04;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static nz.kata04.WeatherDataMunger.newWeatherDataMunger;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeatherDataMungerTest {

    @Test
    @DisplayName("Empty set")
    void smallestEmpty() {
        WeatherDataMunger munger = newWeatherDataMunger(emptyList());
        assertThat(munger.smallestDifference()).isEqualTo("");
    }

    @Test
    @DisplayName("One line")
    void smallestFromOne() {
        String line = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
        WeatherDataMunger munger = newWeatherDataMunger(singletonList(line));
        assertThat(munger.smallestDifference()).isEqualTo("1");
    }

    @Test
    @DisplayName("Two lines, second is minimum spread")
    void smallestFromTwo() {
        List<String> lines = Arrays.asList(
            "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5",
            "   2  60    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5"
        );
        WeatherDataMunger munger = newWeatherDataMunger(lines);
        assertThat(munger.smallestDifference()).isEqualTo("2");
    }

    @Test
    @DisplayName("Three lines, second is minimum spread")
    void smallestFromThree() {
        List<String> lines = Arrays.asList(
            "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5",
            "   2  60    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5",
            "   3  61    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5"
        );
        WeatherDataMunger munger = newWeatherDataMunger(lines);
        assertThat(munger.smallestDifference()).isEqualTo("2");
    }

    @Test
    @DisplayName("File read")
    void smallestFromFile() {
        List<String> lines = DataReader.readData("/weather.dat");
        WeatherDataMunger munger = newWeatherDataMunger(lines);
        assertThat(munger.smallestDifference()).isEqualTo("14");
    }
}
