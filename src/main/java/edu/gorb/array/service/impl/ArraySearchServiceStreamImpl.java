package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArraySearchServiceStreamImpl implements ArraySearchService {
    private static final Logger logger = LogManager.getLogger();
    private static final String ARRAY_IS_NULL_ERROR_MESSAGE = "Array argument is null";
    private static final String ARRAY_IS_EMPTY_ERROR_MESSAGE = "Array is empty";

    @Override
    public int findMinElement(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = intArray.get();
        OptionalInt min = Arrays.stream(array)
                .min();
        if (min.isEmpty()) {
            logger.log(Level.ERROR, ARRAY_IS_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_EMPTY_ERROR_MESSAGE);
        }
        logger.log(Level.INFO, "Minimal element is: {}", min.getAsInt());
        return min.getAsInt();
    }

    @Override
    public int findMaxElement(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = intArray.get();
        OptionalInt max = Arrays.stream(array)
                .max();
        if (max.isEmpty()) {
            logger.log(Level.ERROR, ARRAY_IS_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_EMPTY_ERROR_MESSAGE);
        }
        logger.log(Level.INFO, "Maximal element is: {}", max.getAsInt());
        return max.getAsInt();
    }
}
