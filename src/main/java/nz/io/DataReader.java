package nz.io;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DataReader {

    Logger logger = LoggerFactory.getLogger(DataReader.class);

    static List<String> readData(@Nonnull String dataFile) {
        List<String> list = new ArrayList<>();

        int row = 0;
        try (BufferedReader reader = newReader(dataFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (row++ > 2) {
                    list.add(line);
                }
            }
            return list;
        } catch (NullPointerException | IOException exception) {
            logger.warn("Couldn't load data [file=\"{}\"]", dataFile, exception);
        }

        return Collections.emptyList();
    }

    static BufferedReader newReader(@Nonnull String file) {
        return new BufferedReader(new InputStreamReader(DataReader.class.getResourceAsStream(file), UTF_8));
    }
}
