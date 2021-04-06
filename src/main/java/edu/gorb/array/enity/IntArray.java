package edu.gorb.array.enity;

import edu.gorb.array.exception.ArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntArray {
    private int[] array;
    private static final Logger logger = LogManager.getLogger();
    private static final String INDEX_ERROR_MESSAGE = "Index is not valid";
    private static final String ARRAY_SIZE_ERROR_MESSAGE = "Array size must be positive";

    public IntArray(int size) throws ArrayException {
        if(size < 0){
            logger.log(Level.ERROR, ARRAY_SIZE_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_SIZE_ERROR_MESSAGE);
        }
        array = new int[size];
    }

    public IntArray(int size, int value) throws ArrayException {
        if(size < 0){
            logger.log(Level.ERROR, ARRAY_SIZE_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_SIZE_ERROR_MESSAGE);
        }
        array = new int[size];
        Arrays.fill(array, value);
    }

    public IntArray(int... a) {
        array = a;
    }

    public int[] get() {
        return array.clone();
    }

    public void set(int[] a) {
        array = a.clone();
    }

    public int getItem(int index) throws ArrayException {
        if (index >= array.length || index < 0) {
            logger.log(Level.ERROR, INDEX_ERROR_MESSAGE);
            throw new ArrayException(INDEX_ERROR_MESSAGE);
        }
        return array[index];
    }

    public void setItem(int index, int value) throws ArrayException {
        if (index >= array.length || index < 0) {
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
