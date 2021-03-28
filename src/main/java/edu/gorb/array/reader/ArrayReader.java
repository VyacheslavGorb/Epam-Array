package edu.gorb.array.reader;

import edu.gorb.array.exception.FileException;
import edu.gorb.array.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ArrayReader {
    private static final ArrayValidator validator = new ArrayValidator();
    private static final Logger logger = LogManager.getLogger();

    private static final String ERROR_READ_MESSAGE = "Error while reading file";
    private static final String ERROR_VALIDATION_MESSAGE = "No valid lines in file";
    private static final String SUCCESS_READ = "Correct line was read";

    public String readArrayLine(String fileName) throws FileException {
        Path path = Paths.get(fileName);
        String validLine = null;
        try (Stream<String> lineStream = Files.lines(path)) {
            validLine = lineStream
                    .filter(validator::isValidLine)
                    .findFirst()
                    .orElse(null);
        } catch (IOException exception) {
            logger.log(Level.ERROR, ERROR_READ_MESSAGE);
            throw new FileException(ERROR_READ_MESSAGE);
        }
        if (validLine == null) {
            logger.log(Level.ERROR, ERROR_VALIDATION_MESSAGE);
            throw new FileException(ERROR_VALIDATION_MESSAGE);
        }
        logger.log(Level.INFO, SUCCESS_READ);
        return validLine;
    }
}
