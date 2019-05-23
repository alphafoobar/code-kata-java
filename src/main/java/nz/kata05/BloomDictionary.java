package nz.kata05;

import static nz.io.DataReader.readData;

import java.util.function.Predicate;

public class BloomDictionary implements Predicate<String> {

    private final boolean[] dictionary = new boolean[552523];

    static BloomDictionary fromDictionaryFile(String filename) {
        BloomDictionary bloomDictionary = new BloomDictionary();
        readData(filename).forEach(bloomDictionary::addWord);
        return bloomDictionary;
    }

    void addWord(String word) {
        dictionary[algoOne(word)] = true;
    }

    private int algoOne(String word) {
        // Surprisingly some hashCodes are negative? Because the absolute of Integer.MIN_VALUE *is* Integer.MIN_VALUE, we have to be cleverer!
        // See http://findbugs.blogspot.com/2006/09/is-mathabs-broken.html
        return (word.hashCode() & Integer.MAX_VALUE) % dictionary.length;
    }

    public boolean test(String word) {
        return dictionary[algoOne(word)];
    }
}
