package edu.gorb.array.creator;

import edu.gorb.array.enity.IntArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreator {
    private static final Logger logger = LogManager.getLogger();

    public IntArray createArrayEntity(int... array) {
        IntArray entity = new IntArray(array);
        logger.log(Level.INFO, "Entity created successfully");
        return entity;
    }
}
