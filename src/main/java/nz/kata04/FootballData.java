package nz.kata04;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FootballData {

    private static final Pattern split
        = Pattern.compile("\\s+\\d{1,2}\\.\\s+(\\w+)\\s+\\d{1,2}\\s+\\d{1,2}\\s+\\d{1,2}\\s+\\d{1,2}\\s+(\\d{1,2})\\s+-\\s+(\\d{1,2})\\s+\\d+");

    private final String name;
    private final int goalsFor;
    private final int goalsAgainst;

    private FootballData(String name, int goalsFor, int goalsAgainst) {
        this.name = name;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    static Optional<FootballData> newFootballData(String line) {
        Matcher matcher = split.matcher(line);
        if (matcher.find()) {
            String name = matcher.group(1);
            int goalsFor = Integer.parseInt(matcher.group(2));
            int goalsAgainst = Integer.parseInt(matcher.group(3));
            return Optional.of(new FootballData(name, goalsFor, goalsAgainst));
        }
        return Optional.empty();
    }

    String getName() {
        return name;
    }

    int getGoalsFor() {
        return goalsFor;
    }

    int getGoalsAgainst() {
        return goalsAgainst;
    }
}
