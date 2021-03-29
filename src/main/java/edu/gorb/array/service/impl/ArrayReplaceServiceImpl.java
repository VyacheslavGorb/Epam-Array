package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayReplaceService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReplaceServiceImpl implements ArrayReplaceService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void replaceOddWithZero(IntArray array) {
        try{
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % 2 != 0) {
                    array.set(i, 0);
                }
            }
        }catch (ArrayException ignored){
        }

        logger.log(Level.INFO, "Replacement is complete");
    }
}
