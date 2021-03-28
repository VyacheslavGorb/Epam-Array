package edu.gorb.array.parser;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.FileException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayParserTest {

    ArrayParser parser;

    @BeforeClass
    public void createParser() {
        parser = new ArrayParser();
    }


    @Test(dataProvider = "array_lines")
    public void testParseLine(String line, IntArray expectedArray) throws FileException {
        IntArray array = parser.parseLine(line);
        assertEquals(array, expectedArray);
    }

    @Test(dataProvider = "array_lines_invalid", expectedExceptions = FileException.class)
    public void testParseLineException(String line) throws FileException {
        IntArray array = parser.parseLine(line);
    }

    @DataProvider(name = "array_lines")
    public Object[][] createArrayLines() {
        return new Object[][]{
                {"1, 2, 3, 4, 5, 6, 7", new IntArray(1, 2, 3, 4, 5, 6, 7)},
                {"1, 2, 3, 4, 5, 6, 7", new IntArray(1, 2, 3, 4, 5, 6, 7)},
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
