package edu.gorb.array.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayValidatorTest {

    private ArrayValidator validator;

    @BeforeClass
    public void createParser() {
        validator = new ArrayValidator();
    }


    @Test(dataProvider = "array_lines")
    public void testIsValidLine(String line, boolean expectedValue) {
        boolean value = validator.isValidLine(line);
        assertEquals(value, expectedValue);
    }

    @DataProvider(name = "array_lines")
    public Object[][] createArrayLines() {
        return new Object[][]{
                {"1, 2, 3, -4, 5, 6, 7", true},
                {"1, -2, 3, 4, -5, 6, -7", true},
                {"1, 2, 3, 4, 5, 6, 7sdffsdxv", false},
                {"1, -02, 3, 4, 5, 6, 7", false},
                {"--1, 2, 3, 4, 5, 6, 7", false}
        };
    }

    @DataProvider(name = "array_lines_invalid")
    public Object[][] createInvalidArrayLines() {
        return new Object[][]{
                {"1, 2, 3, 4, 5, 6, 7sdffsdxv"},
                {"1, 2 3, 4, 5, 6, 7"},
        };
    }
}
