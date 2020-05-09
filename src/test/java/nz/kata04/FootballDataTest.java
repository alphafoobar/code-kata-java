package nz.kata04;

import static nz.kata04.FootballData.newFootballData;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FootballDataTest {

    @Test
    @DisplayName("Parse football data line")
    void smallestFromOne() {
        String line = "    1. Arsenal         38    26   9   3    79  -  36    87";
        Optional<FootballData> optional = newFootballData(line);
        assertThat(optional.isPresent()).isTrue();

        FootballData data = optional.get();
        assertThat(data.getName()).isEqualTo("Arsenal");
        assertThat(data.getGoalsFor()).isEqualTo(79);
        assertThat(data.getGoalsAgainst()).isEqualTo(36);
    }
}
