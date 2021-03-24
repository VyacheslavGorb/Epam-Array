package com.company.Gorb.service;

import com.company.Gorb.array.IntArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayReplaceServiceTest {

    ArrayReplaceService service;

    @BeforeClass
    public void createServiceObject() {
        service = new ArrayReplaceService();
    }

    @Test(dataProvider = "replace_data")
    public void replaceOddWithZero(IntArray array, IntArray expectedArray) {
        service.replaceOddWithZero(array);
        assertEquals(array, expectedArray);
    }

    @DataProvider(name = "replace_data")
    public Object[][] createReplaceData() {
        return new Object[][]{
                {new IntArray(new int[]{4, 2, 3, 4, 5, 6}),
                        new IntArray(new int[]{4, 2, 0, 4, 0, 6})},
                {new IntArray(new int[]{10, 2, 10, 8, 10, 10, 4, 10}),
                        new IntArray(new int[]{10, 2, 10, 8, 10, 10, 4, 10})}
        };
    }
}
