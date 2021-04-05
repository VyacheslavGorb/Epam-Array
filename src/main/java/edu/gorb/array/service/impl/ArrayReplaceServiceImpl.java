package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayReplaceService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReplaceServiceImpl implements ArrayReplaceService {
    private static final Logger logger = LogManager.getLogger();
    private static final String ARRAY_IS_NULL_ERROR_MESSAGE = "Array argument is null";

    @Override
    public void replaceOddWithZero(IntArray array) throws ArrayException {
        if (array == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        try {
            for (int i = 0; i < array.size(); i++) {
                if (array.getItem(i) % 2 != 0) {
                    array.setItem(i, 0);
                }
            }
        } catch (ArrayException ignored) {
            // Index is always valid
        }
        logger.log(Level.INFO, "Replacement complete");
    }
}
