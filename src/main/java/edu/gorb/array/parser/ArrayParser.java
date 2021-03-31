package edu.gorb.array.parser;

import edu.gorb.array.exception.ArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayParser {
    private static final Logger logger = LogManager.getLogger();

    public int[] parseLine(String line) throws ArrayException {
        String[] numbers = line.split(", ");
        int[] array;
        try {
            array = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new ArrayException(e.getMessage());
        }
        logger.log(Level.INFO, "Array parsed successfully");
        return array;
    }
}
