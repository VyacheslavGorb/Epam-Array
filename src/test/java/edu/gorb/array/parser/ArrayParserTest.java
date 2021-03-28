package edu.gorb.array.parser;

import edu.gorb.array.enity.IntArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayParserTest {

    ArrayParser parser;

    @BeforeClass
    public void createParser(){
        parser = new ArrayParser();
    }


    @Test(dataProvider = "array_lines")
    public void testParseLine(String line, IntArray expectedArray) {
        IntArray array = parser.parseLine(line);
        assertEquals(array, expectedArray);
    }

    @DataProvider(name = "array_lines")
    public Object[][] createArrayLines() {
        return new Object[][]{
                {"1, 2, 3, 4, 5, 6, 7", new IntArray(new int[]{1,2,3,4,5,6,7})},
                {"1, 2, 3, 4, 5, 6, 7", new IntArray(new int[]{1,2,3,4,5,6,7})}
        };
    }
}
