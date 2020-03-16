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

    private static String normalize(String s) {
        var newChars = new char[s.length()];
        var chars = s.toLowerCase().toCharArray();
        int i = 0;
        for (char c : chars) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                newChars[i++] = c;
            }
        }
        Arrays.sort(newChars, 0, i);
        return new String(newChars, 0, i);
    }

    private void addWord(String s) {
        String normalized = normalize(s);
        words.computeIfAbsent(normalized, w -> new HashSet<>()).add(s);
    }

    public Set<String> find(String s) {
        return words.get(normalize(s));
    }
}
