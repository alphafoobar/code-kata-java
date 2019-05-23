package nz.io;

import static java.util.Collections.emptyList;
import static nz.io.DataReader.readData;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataReaderTest {

    @Test
    @DisplayName("Handle unknown file")
    void testEmptyFile() {
        assertThat(readData("unknown")).isEqualTo(emptyList());
    }
}
