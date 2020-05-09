package nz.kata04;

import static nz.kata04.WeatherData.newWeatherData;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeatherDataTest {

    @Test
    @DisplayName("Parse weather data line")
    void smallestFromOne() {
        String line = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
        Optional<WeatherData> optional = newWeatherData(line);
        assertThat(optional.isPresent()).isTrue();

        WeatherData data = optional.get();
        assertThat(data.getDay()).isEqualTo(1);
        assertThat(data.getMax()).isEqualTo(88);
        assertThat(data.getMin()).isEqualTo(59);
    }
}
