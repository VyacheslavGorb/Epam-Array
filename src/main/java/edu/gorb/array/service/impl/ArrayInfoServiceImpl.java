package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayInfoService;
import org.apache.logging.log4j.*;

public class ArrayInfoServiceImpl implements ArrayInfoService {

    private static final Logger logger = LogManager.getLogger();
    private static final String ARRAY_EMPTY_ERROR_MESSAGE = "Array is empty";

    @Override
    public int calcSum(IntArray array) throws ArrayException {
        if (array == null) {
            logger.log(Level.ERROR, "Array argument is null");
            throw new ArrayException("Array argument is null");
        }
        if (array.size() == 0) {
            logger.log(Level.ERROR, ARRAY_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_EMPTY_ERROR_MESSAGE);
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.getItem(i);
        }
        logger.log(Level.INFO, "Sum is {}", sum);
        return sum;
    }

    @Override
    public double calcAverage(IntArray array) throws ArrayException {
        if (array == null) {
            logger.log(Level.ERROR, "Array argument is null");
            throw new ArrayException("Array argument is null");
        }
        if (array.size() == 0) {
            logger.log(Level.ERROR, ARRAY_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_EMPTY_ERROR_MESSAGE);
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.getItem(i);
        }
        double average = (double) sum / array.size();
        logger.log(Level.INFO, "Average is {}", average);
        return average;
    }

    @Override
    public int calcPositiveElementCount(IntArray array) throws ArrayException {
        if (array == null) {
            logger.log(Level.ERROR, "Array argument is null");
            throw new ArrayException("Array argument is null");
        }
        int count = 0;
        try {
            for (int i = 0; i < array.size(); i++) {
                if (array.getItem(i) > 0) {
                    count++;
                }
            }
        } catch (ArrayException ignored) {
            // Index is always valid
        }
        logger.log(Level.INFO, "Positive element count is {}", count);
        return count;
    }

    @Override
    public int calcNegativeElementCount(IntArray array) {
        int count = 0;
        try {
            for (int i = 0; i < array.size(); i++) {
                if (array.getItem(i) < 0) {
                    count++;
                }
            }
        } catch (ArrayException ignored) {
            // Index is always valid
        }
        logger.log(Level.INFO, "Negative element count is {}", count);
        return count;
    }
}
