package edu.gorb.array.parser;

import edu.gorb.array.enity.IntArray;

import java.util.Arrays;

public class ArrayParser {
    public IntArray parseLine(String line){
        String[] numbers = line.split(", ");
        int[] array = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
        return new IntArray(array);
    }
}
