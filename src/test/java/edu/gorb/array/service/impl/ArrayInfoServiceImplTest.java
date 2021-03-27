package edu.gorb.array.service.impl;

import edu.gorb.array.enity.IntArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayInfoServiceImplTest {
    ArrayInfoServiceImpl service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArrayInfoServiceImpl();
    }

    @Test(dataProvider = "sum_data")
    public void calcSum(IntArray array, int expectedValue) {
        int sum = service.calcSum(array);
        assertEquals(sum, expectedValue);
    }

    @Test(dataProvider = "average_data")
    public void calcAverage(IntArray array, double expectedValue) {
        double averageValue = service.calcAverage(array);
        assertEquals(averageValue, expectedValue);
    }

    @Test(dataProvider = "positive_element_count")
    public void calcPositiveElementCount(IntArray array, int expectedValue) {
        int count = service.calcPositiveElementCount(array);
        assertEquals(count, expectedValue);
    }

    @Test(dataProvider = "negative_element_count")
    public void calcNegativeElementCount(IntArray array, int expectedValue) {
        int count = service.calcNegativeElementCount(array);
        assertEquals(count, expectedValue);
    }

    @DataProvider(name = "sum_data")
    public Object[][] createSumData() {
        return new Object[][]{
                {new IntArray(new int[]{1, 2, 3, 4, 5, 6}), 21},
                {new IntArray(new int[]{10, 10, 10, 10, 10, 10, 10, 10}), 80}
        };
    }

    @DataProvider(name = "average_data")
    public Object[][] createAverageData() {
        return new Object[][]{
                {new IntArray(new int[]{4, 2, 3, 4, 5, 6}), 4},
                {new IntArray(new int[]{10, 10, 10, 10, 10, 10, 10, 10}), 10}
        };
    }

    @DataProvider(name = "positive_element_count")
    public Object[][] createPositiveElementData() {
        return new Object[][]{
                {new IntArray(new int[]{1, -2, 3, 4, -5, 6}), 4},
                {new IntArray(new int[]{1, -2, -3, 4, -5, -6}), 2},
        };
    }

    @DataProvider(name = "negative_element_count")
    public Object[][] createNegativeElementData() {
        return new Object[][]{
                {new IntArray(new int[]{1, -2, 3, 4, -5, 6}), 2},
                {new IntArray(new int[]{1, -2, -3, 4, -5, -6}), 4},
        };
    }

}
