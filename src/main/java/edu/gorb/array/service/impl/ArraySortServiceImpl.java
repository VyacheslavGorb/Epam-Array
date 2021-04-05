package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArraySortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class ArraySortServiceImpl implements ArraySortService {
    private static final Logger logger = LogManager.getLogger();
    private static final String INFO_MESSAGE = "Array was sorted ({})";
    private static final String ARRAY_IS_NULL_ERROR_MESSAGE = "Array argument is null";

    @Override
    public void bubbleSort(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = intArray.get();
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
        intArray.set(array);
        logger.log(Level.INFO, INFO_MESSAGE, "Bubble sort");
    }

    @Override
    public void insertionSort(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = intArray.get();
        for (int i = 1; i < array.length; ++i) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
        intArray.set(array);
        logger.log(Level.INFO, INFO_MESSAGE, "Insertion sort");
    }

    @Override
    public void quickSort(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = intArray.get();
        quickSortService(array, 0, array.length - 1);
        intArray.set(array);
        logger.log(Level.INFO, INFO_MESSAGE, "Quick sort");
    }

    @Override
    public void streamSort(IntArray intArray) throws ArrayException {
        if (intArray == null) {
            logger.log(Level.ERROR, ARRAY_IS_NULL_ERROR_MESSAGE);
            throw new ArrayException(ARRAY_IS_NULL_ERROR_MESSAGE);
        }
        int[] array = intArray.get();
        int[] sortedArray = Arrays.stream(array)
                .sorted()
                .toArray();
        intArray.set(sortedArray);
    }


    private void quickSortService(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[right];
            int i = (left - 1);

            for (int j = left; j <= right - 1; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, right);
            pivot = i + 1;
            quickSortService(array, left, pivot - 1);
            quickSortService(array, pivot + 1, right);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
