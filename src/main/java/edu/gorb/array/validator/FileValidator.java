package edu.gorb.array.validator;

import java.io.File;

public class FileValidator {
    public boolean isValidFile(String filePathString) {
        if (filePathString == null) {
            return false;
        }
        File file = new File(filePathString);
        if (!file.isFile()) {
            return false;
        }
        return file.length() != 0;
    }
}