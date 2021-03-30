package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArraySearchService;

import java.util.Arrays;

public class ArraySearchServiceStreamImpl implements ArraySearchService {

    @Override
    public int findMinElement(IntArray intArray) throws ArrayException {
        int[] array = intArray.get();
        return Arrays.stream(array)
                .min()
                .orElseThrow(() -> new ArrayException("Array is empty"));
    }

    @Override
    public int findMaxElement(IntArray intArray) throws ArrayException {
        int[] array = intArray.get();
        return Arrays.stream(array)
                .max()
                .orElseThrow(() -> new ArrayException("Array is empty"));
    }
}
