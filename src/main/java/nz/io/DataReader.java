package nz.io;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.flogger.FluentLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

public interface DataReader {

    FluentLogger logger = FluentLogger.forEnclosingClass();

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
        } catch (NullPointerException | IOException cause) {
            logger.atWarning().withCause(cause).log("Couldn't load data [file=\"%s\"]", dataFile);
        }

        return Collections.emptyList();
    }

    static BufferedReader newReader(@Nonnull String file) {
        return new BufferedReader(new InputStreamReader(DataReader.class.getResourceAsStream(file), UTF_8));
    }
}
