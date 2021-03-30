package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.service.ArrayReplaceService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayReplcaeServiceStreamImplTest {
    ArrayReplaceService service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArrayReplaceServiceStreamImpl();
    }

    @Test(dataProvider = "replace_data")
    public void testReplaceOddWithZero(IntArray array, IntArray expectedArray) {
        service.replaceOddWithZero(array);
        assertEquals(array, expectedArray);
    }

    @DataProvider(name = "replace_data")
    public Object[][] createReplaceData() {
        return new Object[][]{
                {new IntArray(4, 2, 3, 4, 5, 6),
                        new IntArray(4, 2, 0, 4, 0, 6)},
                {new IntArray(10, 2, 10, 8, 10, 10, 4, 10),
                        new IntArray(10, 2, 10, 8, 10, 10, 4, 10)},
                {new IntArray(),
                        new IntArray()},
                {new IntArray(1),
                        new IntArray(1)}
        };
    }
}
