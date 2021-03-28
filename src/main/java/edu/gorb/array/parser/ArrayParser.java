package edu.gorb.array.parser;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ValidityException;

import java.util.Arrays;

public class ArrayParser {
    public IntArray parseLine(String line) throws ValidityException {
        String[] numbers = line.split(", ");
        int[] array = null;
        try{
            array = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }catch (NumberFormatException e){
            throw new ValidityException(e.getMessage());
        }

        return new IntArray(array);
    }
}
