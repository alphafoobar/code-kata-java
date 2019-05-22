package nz.kata05;

import java.util.function.Predicate;

public class BloomDictionary implements Predicate<String> {

    private final boolean[] dictionary = new boolean[552523];

    static BloomDictionary fromDictionaryFile(String filename) {
        return new BloomDictionary();
    }

    int addWord(String word) {
        return 0;
    }

    public boolean test(String word) {
        return false;
    }
}
