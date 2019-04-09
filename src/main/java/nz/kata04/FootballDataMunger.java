package nz.kata04;

import static nz.kata04.FootballData.newFootballData;

import java.util.ArrayList;
import java.util.List;

class FootballDataMunger {

    private final List<FootballData> list;

    private FootballDataMunger(List<FootballData> list) {
        this.list = List.copyOf(list);
    }

    static FootballDataMunger newFootballDataMunger(List<String> lines) {
        return new FootballDataMunger(listOfData(lines));
    }

    private static List<FootballData> listOfData(List<String> lines) {
        List<FootballData> data = new ArrayList<>(lines.size());
        for (String line : lines) {
            newFootballData(line).ifPresent(data::add);
        }
        return data;
    }

    String smallestDifference() {
        String name = "";
        int smallest = Integer.MAX_VALUE;
        for (FootballData data : list) {
            int difference = Math.abs(data.getGoalsFor() - data.getGoalsAgainst());
            if (smallest > difference) {
                smallest = difference;
                name = data.getName();
            }
        }
        return name;
    }
}
