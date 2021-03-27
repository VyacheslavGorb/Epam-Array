package edu.gorb.array.service;

import edu.gorb.array.enity.IntArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArraySearchServiceTest {

    ArraySearchService service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArraySearchService();
    }

    @Test(dataProvider = "max_data")
    public void findMax(IntArray array, int expectedValue) {
        int max = service.findMaxElement(array);
        assertEquals(max, expectedValue);
    }

    @Test(dataProvider = "min_data")
    public void findMin(IntArray array, int expectedValue) {
        int min = service.findMinElement(array);
        assertEquals(min, expectedValue);
    }

    @DataProvider(name = "max_data")
    public Object[][] createMaxData() {
        return new Object[][]{
                {new IntArray(new int[]{4, 2, 3, 4, 5, 6}), 6},
                {new IntArray(new int[]{10, 10, 10, 10, 10, 10, 10, 10}), 10}
        };
    }

    @DataProvider(name = "min_data")
    public Object[][] createMinData() {
        return new Object[][]{
                {new IntArray(new int[]{4, 2, 3, 4, 5, 6}), 2},
                {new IntArray(new int[]{10, 10, 10, 10, 10, 10, 10, 10}), 10}
        };
    }


}
