package edu.gorb.array.enity;

import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntArray {
    private final int[] array;
    private static final ArrayValidator validator = new ArrayValidator();
    private static final String INDEX_ERROR_MESSAGE = "Index is not valid";
    private static final Logger logger = LogManager.getLogger();


    public IntArray(int size) {
        array = new int[size];
    }

    public IntArray(int size, int value) {
        array = new int[size];
        Arrays.fill(array, value);
    }

    public IntArray(int... a) {
        array = a.clone();
    }

    public int get(int index) throws ArrayException {
        if (!validator.isValidArrayIndex(this,index)){
            logger.log(Level.ERROR, INDEX_ERROR_MESSAGE);
            throw new ArrayException(INDEX_ERROR_MESSAGE);
        }
            return array[index];
    }

    public void set(int index, int value) throws ArrayException {
        if (!validator.isValidArrayIndex(this,index)){
            logger.log(Level.ERROR, INDEX_ERROR_MESSAGE);
            throw new ArrayException(INDEX_ERROR_MESSAGE);
        }
        array[index] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray myArray = (IntArray) o;
        return Arrays.equals(array, myArray.array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
