package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;

public interface ArraySortService {
    void bubbleSort(IntArray array);

    void insertionSort(IntArray array);

    void quickSort(IntArray array);
}
