package nz.kata06;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

class AnagramsTest {

    private Anagrams anagrams = Anagrams.fromFile("/wordlist.txt");

    @Test
    void testWordThatIsnt() {
        Set<String> actual = anagrams.find("test-word-that-isn't-there");
        assertThat(actual).isNull();
    }

    @Test
    void testWord() {
        Set<String> actual = anagrams.find("word");
        assertThat(actual).contains("word");
        assertThat(actual.size()).isEqualTo(3);
    }

    @Test
    void testWordWithManyAnagrams() {
        Set<String> actual = anagrams.find("paste");
        assertThat(actual).contains("paste");
        assertThat(actual.size()).isEqualTo(12);
    }
}
