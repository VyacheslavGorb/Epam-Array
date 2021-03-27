package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;

public class ArrayReplaceService {
    public void replaceOddWithZero(IntArray array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 != 0){
                array.set(i,0);
            }
        }
    }
}
