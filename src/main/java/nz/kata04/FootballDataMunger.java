package nz.kata04;

import static nz.kata04.FootballData.newFootballData;

import java.util.List;
import java.util.Optional;

class FootballDataMunger extends Munger<FootballData> {

    private FootballDataMunger(List<String> lines) {
        super(lines);
    }

    static FootballDataMunger newFootballDataMunger(List<String> lines) {
        return new FootballDataMunger(lines);
    }

    @Override
    Optional<FootballData> newData(String line) {
        return newFootballData(line);
    }
}
