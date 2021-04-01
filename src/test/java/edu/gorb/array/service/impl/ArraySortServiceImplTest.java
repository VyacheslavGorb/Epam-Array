package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArraySortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArraySortServiceImplTest {
    ArraySortService service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArraySortServiceImpl();
    }

    @Test(dataProvider = "sort_data")
    public void testBubbleSort(IntArray array, IntArray expectedValue) throws ArrayException {
        service.bubbleSort(array);
        assertEquals(array, expectedValue);
    }

    @Test(dataProvider = "sort_data")
    public void testInsertionSort(IntArray array, IntArray expectedValue) throws ArrayException {
        service.insertionSort(array);
        assertEquals(array, expectedValue);
    }

    @Test(dataProvider = "sort_data")
    public void testQuickSort(IntArray array, IntArray expectedValue) throws ArrayException {
        service.quickSort(array);
        assertEquals(array, expectedValue);
    }

    @DataProvider(name = "sort_data")
    public Object[][] createReplaceData() throws ArrayException {
        return new Object[][]{
                {new IntArray(4, 2, 3, 4, 5, 6),
                        new IntArray(2, 3, 4, 4, 5, 6)},
                {new IntArray(10, 2, 10, 8, 10, 10, 4, 10),
                        new IntArray(2, 4, 8, 10, 10, 10, 10, 10)},
                {new IntArray(),
                        new IntArray()},
                {new IntArray(1),
                        new IntArray(1)}
        };
    }
}
