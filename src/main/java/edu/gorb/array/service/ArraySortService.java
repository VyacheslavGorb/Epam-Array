package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;

public interface ArraySortService {
    void bubbleSort(IntArray array) throws ArrayException;

    void insertionSort(IntArray array) throws ArrayException;

    void quickSort(IntArray array) throws ArrayException;

    void streamSort(IntArray array) throws ArrayException;
}
