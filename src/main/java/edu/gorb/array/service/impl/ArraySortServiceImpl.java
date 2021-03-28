package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.service.ArraySortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ArraySortServiceImpl implements ArraySortService {
    private static final Logger logger = LogManager.getLogger();
    private static final String INFO_MESSAGE = "Array was sorted ({})";

    @Override
    public void bubbleSort(IntArray array) {
        int length = array.size();
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (array.get(j) > array.get(j + 1)) {
                    swap(array, j, j + 1);
                }
        logger.log(Level.INFO, INFO_MESSAGE, "Bubble sort");
    }

    @Override
    public void insertionSort(IntArray array) {
        int length = array.size();
        for (int i = 1; i < length; ++i) {
            int temp = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > temp) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }
            array.set(j + 1, temp);
        }
        logger.log(Level.INFO, INFO_MESSAGE, "Insertion sort");
    }

    @Override
    public void quickSort(IntArray array) {
        quickSortService(array, 0, array.size() - 1);
        logger.log(Level.INFO, INFO_MESSAGE, "Quick sort");
    }


    private void quickSortService(IntArray array, int left, int right) {
        if (left < right) {
            int pivot = array.get(right);
            int i = (left - 1);

            for (int j = left; j <= right - 1; j++) {
                if (array.get(j) < pivot) {
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

    private void swap(IntArray array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
