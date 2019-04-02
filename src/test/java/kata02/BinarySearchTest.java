package kata02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private BinarySearch search = new BinarySearch();

    @Test
    @DisplayName("Cannot find key in empty set")
    void emptyScenarios() {
        assertThat(search.chop(3, new int[]{})).isEqualTo(-1);
    }

    @Test
    @DisplayName("Single item array")
    void easyScenarios() {
        int[] a = {1};

        assertThat(search.chop(3, a)).isEqualTo(-1);

        assertThat(search.chop(1, a)).isEqualTo(0);
    }

    @Test
    @DisplayName("Tests of 3")
    void smallSets() {
        int[] ints = {1, 3, 5};

        assertThat(search.chop(1, ints)).isEqualTo(0);
        assertThat(search.chop(3, ints)).isEqualTo(1);
        assertThat(search.chop(5, ints)).isEqualTo(2);

        assertThat(search.chop(0, ints)).isEqualTo(-1);
        assertThat(search.chop(2, ints)).isEqualTo(-1);
        assertThat(search.chop(4, ints)).isEqualTo(-1);
        assertThat(search.chop(6, ints)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Tests of 4")
    void mediumSets() {
        int[] ints = {1, 3, 5, 7};

        assertThat(search.chop(7, ints)).isEqualTo(3);

        assertThat(search.chop(8, ints)).isEqualTo(-1);
    }
}
