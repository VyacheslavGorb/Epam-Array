package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.service.ArraySearchService;

public class ArraySearchServiceImpl implements ArraySearchService {
    @Override
    public int findMinElement(IntArray array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (min > array.get(i)) {
                min = array.get(i);
            }
        }
        return min;
    }

    @Override
    public int findMaxElement(IntArray array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (max < array.get(i)) {
                max = array.get(i);
            }
        }
        return max;
    }
}
