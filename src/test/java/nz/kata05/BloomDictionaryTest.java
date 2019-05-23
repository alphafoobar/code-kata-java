package nz.kata05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BloomDictionaryTest {

    private BloomDictionary dictionary = BloomDictionary.fromDictionaryFile("/wordlist.txt");

    @Test
    @DisplayName("Add and find a simple word")
    void addOne() {
        BloomDictionary bloomDictionary = new BloomDictionary();
        bloomDictionary.addWord("one");
        assertThat(bloomDictionary.test("one")).isTrue();
    }

    @Test
    @DisplayName("Add and find ALGOL's")
    void addAlgol() {
        BloomDictionary bloomDictionary = new BloomDictionary();
        bloomDictionary.addWord("ALGOL's");
        assertThat(bloomDictionary.test("ALGOL's")).isTrue();
    }

    @Test
    @DisplayName("Add dictionary and find test")
    void testSimpleWord() {
        assertThat(dictionary.test("test")).isTrue();
    }

    @Test
    @DisplayName("A missing word is not found")
    void testMissingWord() {
        assertThat(dictionary.test("F@@@@")).isFalse();
    }

    @Test
    @DisplayName("A tricky word is found")
    void testTrickyWord() {
        assertThat(dictionary.test("beefburger's")).isTrue();
    }
}
