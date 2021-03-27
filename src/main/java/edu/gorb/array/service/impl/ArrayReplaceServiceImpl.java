package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.service.ArrayReplaceService;

public class ArrayReplaceServiceImpl implements ArrayReplaceService {
    @Override
    public void replaceOddWithZero(IntArray array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 != 0) {
                array.set(i, 0);
            }
        }
    }
}
