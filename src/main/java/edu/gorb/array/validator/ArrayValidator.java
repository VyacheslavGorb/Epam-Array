package edu.gorb.array.validator;

public class ArrayValidator {
    private static final String REGEXP = "^([-]?([0]|[1-9][0-9]*), )*[-]?([0]|[1-9][0-9]*)$";

    public boolean isValidLine(String line) {
        return line.matches(REGEXP);
    }
}
