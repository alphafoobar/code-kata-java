package nz.kata06;

import static nz.io.DataReader.readData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Anagrams {

    private Map<String, Set<String>> words = new HashMap<>();

    private Anagrams() {
        // Private for secrecy!
    }

    static Anagrams fromFile(String filename) {
        var dictionary = new Anagrams();
        readData(filename).forEach(dictionary::addWord);
        return dictionary;
    }

    private static String normalize(String word) {
        var newChars = new char[word.length()];
        var chars = word.toLowerCase().toCharArray();
        int count = 0;
        for (char c : chars) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                newChars[count++] = c;
            }
        }
        Arrays.sort(newChars, 0, count);
        return new String(newChars, 0, count);
    }

    private void addWord(String word) {
        String normalized = normalize(word);
        words.computeIfAbsent(normalized, w -> new HashSet<>()).add(word);
    }

    public Set<String> find(String word) {
        return words.get(normalize(word));
    }
}
