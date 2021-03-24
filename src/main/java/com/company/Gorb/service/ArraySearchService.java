package com.company.Gorb.service;

import com.company.Gorb.array.IntArray;

public class ArraySearchService {
    int findMinElement(IntArray array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (min > array.get(i)){
                min = array.get(i);
            }
        }
        return min;
    }

    int findMaxElement(IntArray array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (max < array.get(i)){
                max = array.get(i);
            }
        }
        return max;
    }
}
