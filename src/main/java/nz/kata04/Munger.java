package nz.kata04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class Munger<T extends Data> {

    private final List<T> list;

    Munger(List<String> list) {
        this.list = listOfData(list);
    }

    private List<T> listOfData(List<String> lines) {
        List<T> data = new ArrayList<>(lines.size());
        for (String line : lines) {
            newData(line).ifPresent(data::add);
        }
        return data;
    }

    abstract Optional<T> newData(String line);

    String smallestDifference() {
        String label = "";
        int smallest = Integer.MAX_VALUE;
        for (T data : list) {
            int difference = data.difference();
            if (smallest > difference) {
                smallest = difference;
                label = data.label();
            }
        }
        return label;
    }
}
