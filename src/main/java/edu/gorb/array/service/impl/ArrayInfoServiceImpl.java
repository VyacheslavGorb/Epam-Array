package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayInfoService;
import org.apache.logging.log4j.*;

public class ArrayInfoServiceImpl implements ArrayInfoService {

    static Logger logger = LogManager.getLogger();
    private static final String ERROR_MESSAGE = "Array is empty";

    @Override
    public int calcSum(IntArray array) throws ArrayException {
        if (array.size() == 0) {
            logger.log(Level.ERROR, ERROR_MESSAGE);
            throw new ArrayException(ERROR_MESSAGE);
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        logger.log(Level.INFO, "Sum is {}", sum);
        return sum;
    }

    @Override
    public double calcAverage(IntArray array) throws ArrayException {
        if (array.size() == 0) {
            logger.log(Level.ERROR, ERROR_MESSAGE);
            throw new ArrayException(ERROR_MESSAGE);
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        double average = (double) sum / array.size();
        logger.log(Level.INFO, "Average is {}", average);
        return average;
    }

    @Override
    public int calcPositiveElementCount(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                count++;
            }
        }
        logger.log(Level.INFO, "Positive element count is {}", count);
        return count;
    }

    @Override
    public int calcNegativeElementCount(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                count++;
            }
        }
        logger.log(Level.INFO, "Negative element count is {}", count);
        return count;
    }
}
