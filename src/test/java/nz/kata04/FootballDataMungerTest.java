package nz.kata04;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static nz.kata04.FootballDataMunger.newFootballDataMunger;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FootballDataMungerTest {

    @Test
    @DisplayName("Empty set")
    void smallestEmpty() {
        FootballDataMunger munger = newFootballDataMunger(emptyList());
        assertThat(munger.smallestDifference()).isEqualTo("");
    }

    @Test
    @DisplayName("One line")
    void smallestFromOne() {
        String line = "    9. Tottenham       38    14   8  16    49  -  53    50";
        FootballDataMunger munger = newFootballDataMunger(singletonList(line));
        assertThat(munger.smallestDifference()).isEqualTo("Tottenham");
    }

    @Test
    @DisplayName("Two lines, Liverpool is minimum difference")
    void smallestFromTwo() {
        List<String> lines = Arrays.asList(
            "    1. Arsenal         38    26   9   3    79  -  36    87",
            "    2. Liverpool       38    24   8   6    67  -  30    80"
        );
        FootballDataMunger munger = newFootballDataMunger(lines);
        assertThat(munger.smallestDifference()).isEqualTo("Liverpool");
    }

    @Test
    @DisplayName("Three lines, Ipswich is minimum difference")
    void smallestFromThree() {
        List<String> lines = Arrays.asList(
            "  18. Ipswich         38     9   9  20    41  -  64    36 ",
            "  19. Derby           38     8   6  24    33  -  63    30 ",
            "  20. Leicester       38     5  13  20    30  -  64    28 "
        );
        FootballDataMunger munger = newFootballDataMunger(lines);
        assertThat(munger.smallestDifference()).isEqualTo("Ipswich");
    }

    @Test
    @DisplayName("File read")
    void smallestFromFile() {
        List<String> lines = DataReader.readData("/football.dat");
        FootballDataMunger munger = newFootballDataMunger(lines);
        assertThat(munger.smallestDifference()).isEqualTo("Aston_Villa");
    }
}
