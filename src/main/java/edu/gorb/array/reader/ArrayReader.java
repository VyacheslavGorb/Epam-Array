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

    private static final String READ_ERROR_MESSAGE = "Error while reading file: ";
    private static final String VALIDATION_ERROR_MESSAGE = "No valid lines in file: ";
    private static final String SUCCESS_READ_MESSAGE = "Correct line was read in file: ";

    public String readArrayLine(String fileName) throws FileException {
        Path path = Paths.get(fileName);
        String validLine = null;
        try (Stream<String> lineStream = Files.lines(path)) {
            validLine = lineStream
                    .filter(validator::isValidLine)
                    .findFirst()
                    .orElse(null);
        } catch (IOException exception) {
            logger.log(Level.ERROR, READ_ERROR_MESSAGE+fileName);
            throw new FileException(READ_ERROR_MESSAGE+fileName);
        }
        if (validLine == null) {
            logger.log(Level.ERROR, VALIDATION_ERROR_MESSAGE+fileName);
            throw new FileException(VALIDATION_ERROR_MESSAGE+fileName);
        }
        logger.log(Level.INFO, SUCCESS_READ_MESSAGE+fileName);
        return validLine;
    }
}
