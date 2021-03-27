package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;

public interface ArrayInfoService {
    int calcSum(IntArray array);

    double calcAverage(IntArray array);

    int calcPositiveElementCount(IntArray array);

    int calcNegativeElementCount(IntArray array);
}
