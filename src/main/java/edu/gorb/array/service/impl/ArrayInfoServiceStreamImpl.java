package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayInfoService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayInfoServiceStreamImpl implements ArrayInfoService {

    private static final Logger logger = LogManager.getLogger();
    private static final String ARRAY_IS_EMPTY_ERROR_MESSAGE = "Array is empty";
    private static final String ARRAY_IS_NULL_ERROR_MESSAGE = "Array argument is null";

    @Override
    public int calcSum(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        if (intArray.size() == 0) {
            logger.log(Level.ERROR, ARRAY_IS_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_EMPTY_ERROR_MESSAGE);
        }
        int sum = Arrays.stream(intArray.get()).sum();
        logger.log(Level.INFO, "Sum is {}", sum);
        return sum;
    }

    @Override
    public double calcAverage(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        OptionalDouble average = Arrays.stream(intArray.get())
                .average();
        if (average.isEmpty()) {
            logger.log(Level.ERROR, ARRAY_IS_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_EMPTY_ERROR_MESSAGE);
        }
        logger.log(Level.INFO, "Average is {}", average.getAsDouble());
        return average.getAsDouble();
    }

    @Override
    public int calcPositiveElementCount(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        long count = Arrays.stream(intArray.get())
                .filter(el -> el > 0)
                .count();
        logger.log(Level.INFO, "Positive element count is {}", count);
        return (int) count;
    }

    @Override
    public int calcNegativeElementCount(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        long count = Arrays.stream(intArray.get())
                .filter(el -> el < 0)
                .count();
        logger.log(Level.INFO, "Negative element count is {}", count);
        return (int) count;
    }
}
