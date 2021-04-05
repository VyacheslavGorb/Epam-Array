package edu.gorb.array.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class FileValidatorTest {

    FileValidator validator;

    @BeforeClass
    public void createValidator() {
        validator = new FileValidator();
    }

    @Test(dataProvider = "files_data")
    public void readArrayLineTest(String fileName) {
        assertTrue(validator.isValidFile(fileName));
    }

    @Test(dataProvider = "files_data_invalid")
    public void readArrayLineTestException(String fileName) {
        assertFalse(validator.isValidFile(fileName));
    }

    @DataProvider(name = "files_data")
    public Object[][] createFileRecords() {
        generateResourceAbsolutePath("testFile1.txt");
        return new Object[][]{
                {generateResourceAbsolutePath("testFile1.txt")}
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
        return file.getAbsolutePath();
    }
}
