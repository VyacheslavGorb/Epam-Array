package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;

public interface ArraySearchService {
    int findMinElement(IntArray array) throws ArrayException;

    int findMaxElement(IntArray array) throws ArrayException;
}
