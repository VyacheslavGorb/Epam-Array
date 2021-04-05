package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayReplaceService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayReplaceServiceStreamImpl implements ArrayReplaceService {
    private static final Logger logger = LogManager.getLogger();
    private static final String ARRAY_IS_NULL_ERROR_MESSAGE = "Array argument is null";

    @Override
    public void replaceOddWithZero(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = Arrays.stream(intArray.get())
                .map((int el) -> (el % 2 == 0) ? el : 0)
                .toArray();
        intArray.set(array);
        logger.log(Level.INFO, "Replacement complete");
    }
}
