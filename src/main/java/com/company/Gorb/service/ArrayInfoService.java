package com.company.Gorb.service;

import com.company.Gorb.array.IntArray;

public class ArrayInfoService {
    public int getSum(IntArray array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

    public double getAverage(IntArray array) {
        if (array.size() == 0) {
            return 0;
        }
        int sum = getSum(array);
        return (double) sum / array.size();
    }

    public int getPositiveElementCount(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                count++;
            }
        }
        return count;
    }

    public int getNegativeElementCount(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                count++;
            }
        }
        return count;
    }
}
