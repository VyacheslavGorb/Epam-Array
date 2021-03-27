package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;

public class ArrayInfoService {
    public int calcSum(IntArray array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

    public double calcAverage(IntArray array) {
        if (array.size() == 0) {
            return 0;
        }
        int sum = calcSum(array);
        return (double) sum / array.size();
    }

    public int calcPositiveElementCount(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                count++;
            }
        }
        return count;
    }

    public int calcNegativeElementCount(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                count++;
            }
        }
        return count;
    }
}
