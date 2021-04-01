package edu.gorb.array.reader;

import edu.gorb.array.exception.ArrayException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileReaderTest {
    FileReader reader;

    @BeforeClass
    public void createParser() {
        reader = new FileReader();
    }

    @Test(dataProvider = "files_data")
    public void readArrayLineTest(String fileName, String expectedValue) throws ArrayException {
        String value = reader.readFile(fileName);
        assertEquals(value, expectedValue);
    }

    @Test(dataProvider = "files_data_invalid", expectedExceptions = ArrayException.class)
    public void readArrayLineTestException(String fileName) throws ArrayException {
        reader.readFile(fileName);
    }


    @DataProvider(name = "files_data")
    public Object[][] createFileRecords() {
        generateResourceAbsolutePath("testFile1.txt");
        return new Object[][]{
                {generateResourceAbsolutePath("testFile1.txt"), "1, 43, 432, 42, 12"}
        };
    }

    @DataProvider(name = "files_data_invalid")
    public Object[][] createFileRecordsInvalid() {
        return new Object[][]{
                {"doesntExist.txt"},
                {generateResourceAbsolutePath("testFile2.txt")}
        };
    }

    private String generateResourceAbsolutePath(String filePath) {
        File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
        System.out.println(file.getAbsolutePath());
        return file.getAbsolutePath();
    }
}
