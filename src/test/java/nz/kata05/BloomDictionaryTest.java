package nz.kata05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BloomDictionaryTest {

    private BloomDictionary dictionary = BloomDictionary.fromDictionaryFile("/wordlist.txt");

    @Test
    void testSimpleWord() {
        assertThat(dictionary.test("test")).isTrue();
    }

    @Test
    void testMissingWord() {
        assertThat(dictionary.test("F@@@@")).isFalse();
    }

    @Test
    void testTrickyWord() {
        assertThat(dictionary.test("test")).isTrue();
    }
}
