package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayReplaceServiceImplTest {

    ArrayReplaceServiceImpl service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArrayReplaceServiceImpl();
    }

    @Test(dataProvider = "replace_data")
    public void testReplaceOddWithZero(IntArray array, IntArray expectedArray) throws ArrayException {
        service.replaceOddWithZero(array);
        assertEquals(array, expectedArray);
    }

    @DataProvider(name = "replace_data")
    public Object[][] createReplaceData() {
        return new Object[][]{
                {new IntArray(4, 2, 3, 4, 5, 6),
                        new IntArray(4, 2, 0, 4, 0, 6)},
                {new IntArray(10, 2, 10, 8, 10, 10, 4, 10),
                        new IntArray(10, 2, 10, 8, 10, 10, 4, 10)}
        };
    }
}
