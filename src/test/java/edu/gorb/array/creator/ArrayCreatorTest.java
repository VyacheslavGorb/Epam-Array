package edu.gorb.array.creator;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.FileException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayCreatorTest {
    ArrayCreator creator;
    String projectFolder;

    @BeforeClass
    public void createParser() {
        creator = new ArrayCreator();
        projectFolder = System.getProperty("user.dir");
    }

    @Test(dataProvider = "files_data")
    public void testCreateArrayEntity(String fileName, IntArray expectedValue) throws FileException {
        var array = creator.createArrayEntity(fileName);
        assertEquals(array, expectedValue);
    }

    @Test(dataProvider = "files_data_invalid", expectedExceptions = FileException.class)
    public void testCreateArrayEntityException(String fileName) throws FileException {
        var array = creator.createArrayEntity(fileName);
    }

    @DataProvider(name = "files_data")
    public Object[][] createFileRecords() {
        return new Object[][]{
                {projectFolder + "./src/test/resources/testFile1.txt", new IntArray(1, 2, 3, 4, 5, 6)},
                {projectFolder + "./src/test/resources/testFile2.txt", new IntArray(43, 2, 6, 3, 2, 5, 6)}
        };
    }

    @DataProvider(name = "files_data_invalid")
    public Object[][] createFileRecordsInvalid() {
        return new Object[][]{
                {projectFolder + "./src/test/resources/testFile3.txt"},
                {projectFolder + "./src/test/resources/testFile4.txt"}
        };
    }
}
