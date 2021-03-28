package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;

public interface ArrayInfoService {
    int calcSum(IntArray array) throws ArrayException;

    double calcAverage(IntArray array) throws ArrayException;

    int calcPositiveElementCount(IntArray array);

    int calcNegativeElementCount(IntArray array);
}
