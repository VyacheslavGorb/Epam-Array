package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArraySearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySearchServiceImpl implements ArraySearchService {

    private static final Logger logger = LogManager.getLogger();
    private static final String ARRAY_IS_EMPTY_ERROR_MESSAGE = "Array is empty";
    private static final String ARRAY_IS_NULL_ERROR_MESSAGE = "Array argument is null";

    @Override
    public int findMinElement(IntArray array) throws ArrayException {
        if (array == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        if (array.size() == 0) {
            logger.log(Level.ERROR, ARRAY_IS_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_EMPTY_ERROR_MESSAGE);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (min > array.getItem(i)) {
                min = array.getItem(i);
            }
        }
        logger.log(Level.INFO, "Minimal element is {}", min);
        return min;
    }

    @Override
    public int findMaxElement(IntArray array) throws ArrayException {
        if (array == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        if (array.size() == 0) {
            logger.log(Level.ERROR, ARRAY_IS_EMPTY_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_EMPTY_ERROR_MESSAGE);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (max < array.getItem(i)) {
                max = array.getItem(i);
            }
        }
        logger.log(Level.INFO, "Maximal element is {}", max);
        return max;
    }
}
