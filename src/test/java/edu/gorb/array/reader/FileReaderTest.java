package edu.gorb.array.reader;

import edu.gorb.array.exception.FileReadException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FileReaderTest {
    FileReader reader;

    @BeforeClass
    public void createParser() {
        reader = new FileReader();
    }

    @Test(dataProvider = "files_data")
    public void readArrayLineTest(String fileName, List<String> expectedValue) throws FileReadException {
        List<String> value = reader.readFile(fileName);
        assertEquals(value, expectedValue);
    }

    @Test(dataProvider = "files_data_invalid", expectedExceptions = FileReadException.class)
    public void readArrayLineTestException(String fileName) throws FileReadException {
        reader.readFile(fileName);
    }


    @DataProvider(name = "files_data")
    public Object[][] createFileRecords() {
        generateResourceAbsolutePath("testFile1.txt");
        return new Object[][]{
                {generateResourceAbsolutePath("testFile1.txt"), List.of(
                        "1, 2, 3, 4, 5, 6",
                        "1, 43, 432, 42, 12",
                        "43, 2, 6, 3, 2, 5, 6")},
                {generateResourceAbsolutePath("testFile2.txt"), List.of()}
        };
    }

    @DataProvider(name = "files_data_invalid")
    public Object[][] createFileRecordsInvalid() {
        return new Object[][]{
                {"doesntExist.txt"}
        };
    }

    private String generateResourceAbsolutePath(String filePath) {
        File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
        System.out.println(file.getAbsolutePath());
        return file.getAbsolutePath();
    }
}
