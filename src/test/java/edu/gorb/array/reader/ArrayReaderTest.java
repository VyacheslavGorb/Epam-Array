package edu.gorb.array.reader;

import edu.gorb.array.exception.FileException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayReaderTest {
    ArrayReader reader;

    @BeforeClass
    public void createParser() {
        reader = new ArrayReader();
    }

    @Test(dataProvider = "files_data")
    public void readArrayLineTest(String fileName, String expectedValue) throws FileException {
        String value = reader.readArrayLine(fileName);
        assertEquals(value, expectedValue);
    }

    @Test(dataProvider = "files_data_invalid", expectedExceptions = FileException.class)
    public void readArrayLineTestException(String fileName) throws FileException {
        reader.readArrayLine(fileName);
    }


    @DataProvider(name = "files_data")
    public Object[][] createFileRecords() {
        return new Object[][]{
                {"src/test/resources/array.txt", "1, 2, 3, 4, 5, 6"},
                {"src/test/resources/testFile2.txt", "43, 2, 6, 3, 2, 5, 6"}
        };
    }

    @DataProvider(name = "files_data_invalid")
    public Object[][] createFileRecordsInvalid() {
        return new Object[][]{
                {"src/test/resources/testFile3.txt"},
                {"src/test/resources/testFile4.txt"}
        };
    }
}
