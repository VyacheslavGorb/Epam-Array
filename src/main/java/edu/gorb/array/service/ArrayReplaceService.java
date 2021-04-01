package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;

public interface ArrayReplaceService {
    void replaceOddWithZero(IntArray array) throws ArrayException;
}
