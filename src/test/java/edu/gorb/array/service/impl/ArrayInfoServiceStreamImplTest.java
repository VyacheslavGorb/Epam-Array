package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.service.ArrayInfoService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayInfoServiceStreamImplTest {
    ArrayInfoService service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArrayInfoServiceStreamImpl();
    }

    @Test(dataProvider = "sum_data")
    public void testCalcSum(IntArray array, int expectedValue) throws ArrayException {
        int sum = service.calcSum(array);
        assertEquals(sum, expectedValue);
    }

    @Test(dataProvider = "empty_array", expectedExceptions = ArrayException.class)
    public void testCalcSumException(IntArray array) throws ArrayException {
        service.calcSum(array);
    }

    @Test(dataProvider = "average_data")
    public void testCalcAverage(IntArray array, double expectedValue) throws ArrayException {
        double averageValue = service.calcAverage(array);
        assertEquals(averageValue, expectedValue);
    }

    @Test(dataProvider = "empty_array", expectedExceptions = ArrayException.class)
    public void testCalcAverageException(IntArray array) throws ArrayException {
        service.calcAverage(array);
    }

    @Test(dataProvider = "positive_element_count")
    public void testCalcPositiveElementCount(IntArray array, int expectedValue) {
        int count = service.calcPositiveElementCount(array);
        assertEquals(count, expectedValue);
    }

    @Test(dataProvider = "negative_element_count")
    public void testCalcNegativeElementCount(IntArray array, int expectedValue) {
        int count = service.calcNegativeElementCount(array);
        assertEquals(count, expectedValue);
    }

    @DataProvider(name = "sum_data")
    public Object[][] createSumData() {
        return new Object[][]{
                {new IntArray(1, 2, 3, 4, 5, 6), 21},
                {new IntArray(10, 10, 10, 10, 10, 10, 10, 10), 80}
        };
    }

    @DataProvider(name = "average_data")
    public Object[][] createAverageData() {
        return new Object[][]{
                {new IntArray(4, 2, 3, 4, 5, 6), 4},
                {new IntArray(10, 10, 10, 10, 10, 10, 10, 10), 10}
        };
    }

    @DataProvider(name = "positive_element_count")
    public Object[][] createPositiveElementData() {
        return new Object[][]{
                {new IntArray(1, -2, 3, 4, -5, 6), 4},
                {new IntArray(1, -2, -3, 4, -5, -6), 2},
        };
    }

    @DataProvider(name = "negative_element_count")
    public Object[][] createNegativeElementData() {
        return new Object[][]{
                {new IntArray(1, -2, 3, 4, -5, 6), 2},
                {new IntArray(1, -2, -3, 4, -5, -6), 4},
        };
    }

    @DataProvider(name = "empty_array")
    public Object[][] createEmptyArray() {
        return new Object[][]{
                {new IntArray()}
        };
    }
}
