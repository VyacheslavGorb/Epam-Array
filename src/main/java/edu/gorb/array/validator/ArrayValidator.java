package edu.gorb.array.validator;

import edu.gorb.array.enity.IntArray;

public class ArrayValidator {
    private static final String REGEXP = "^([-]?([0]|[1-9][0-9]*), )*[-]?([0]|[1-9][0-9]*)$";

    public boolean isValidLine(String line) {
        return line.matches(REGEXP);
    }

    public boolean isValidArrayIndex(IntArray array, int index){
        return (index < array.size() - 1) && (index >= 0);
    }
}
