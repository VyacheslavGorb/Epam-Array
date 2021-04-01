package edu.gorb.array.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {

    private ArrayValidator validator;

    @BeforeClass
    public void createParser() {
        validator = new ArrayValidator();
    }


    @Test(dataProvider = "array_lines_valid")
    public void testIsValidLine(String line) {
        boolean value = validator.isValidLine(line);
        assertTrue(value);
    }

    @Test(dataProvider = "array_lines_invalid")
    public void testIsNotValidLine(String line) {
        boolean value = validator.isValidLine(line);
        assertFalse(value);
    }


    @DataProvider(name = "array_lines_valid")
    public Object[][] createArrayLines() {
        return new Object[][]{
                {"1, 2, 3, -4,   5, 6, 7"},
                {"1, -2, 3, 4, -5, 6, -7"}
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
