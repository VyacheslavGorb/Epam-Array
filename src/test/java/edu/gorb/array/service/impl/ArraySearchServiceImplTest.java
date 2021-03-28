package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArraySearchServiceImplTest {

    ArraySearchServiceImpl service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArraySearchServiceImpl();
    }

    @Test(dataProvider = "max_data")
    public void testFindMax(IntArray array, int expectedValue) throws ArrayException {
        int max = service.findMaxElement(array);
        assertEquals(max, expectedValue);
    }

    @Test(dataProvider = "empty_array", expectedExceptions = ArrayException.class)
    public void testFindMaxException(IntArray array) throws ArrayException {
        service.findMaxElement(array);
    }

    @Test(dataProvider = "min_data")
    public void testFindMin(IntArray array, int expectedValue) throws ArrayException {
        int min = service.findMinElement(array);
        assertEquals(min, expectedValue);
    }

    @Test(dataProvider = "empty_array", expectedExceptions = ArrayException.class)
    public void testFindMinException(IntArray array) throws ArrayException {
        service.findMinElement(array);
    }

    @DataProvider(name = "max_data")
    public Object[][] createMaxData() {
        return new Object[][]{
                {new IntArray(4, 2, 3, 4, 5, 6), 6},
                {new IntArray(10, 10, 10, 10, 10, 10, 10, 10), 10}
        };
    }

    @DataProvider(name = "min_data")
    public Object[][] createMinData() {
        return new Object[][]{
                {new IntArray(4, 2, 3, 4, 5, 6), 2},
                {new IntArray(10, 10, 10, 10, 10, 10, 10, 10), 10}
        };
    }

    @DataProvider(name = "empty_array")
    public Object[][] createEmptyArray(){
        return new Object[][]{
                {new IntArray()}
        };
    }


}
