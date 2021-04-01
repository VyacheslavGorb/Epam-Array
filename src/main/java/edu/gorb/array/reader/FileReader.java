package edu.gorb.array.reader;

import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    private static final Logger logger = LogManager.getLogger();

    public String readFile(String filePathString) throws ArrayException {
        if (filePathString == null) {
            logger.log(Level.ERROR, "File path is null");
            throw new ArrayException("File path is null");
        }
        File file = new File(filePathString);
        if (!file.isFile()) {
            logger.log(Level.ERROR, "{} is not valid filepath", filePathString);
            throw new ArrayException(filePathString + " is not valid filepath");
        }
        if (file.length() == 0) {
            logger.log(Level.ERROR, "File is empty");
            throw new ArrayException("File is empty");
        }
        Path path = Paths.get(filePathString);
        ArrayValidator validator = new ArrayValidator();
        String correctLine = null;
        try (var fileLines = Files.lines(path)) {
            correctLine = fileLines
                    .filter(validator::isValidLine)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file {}", filePathString);
            throw new ArrayException("Error while reading file " + filePathString);
        }
        if (correctLine == null) {
            logger.log(Level.ERROR, "No correct line was found in file {}", filePathString);
            throw new ArrayException("No correct line was found in file " + filePathString);
        }
        logger.log(Level.INFO, "Correct line was read in file: {}", filePathString);
        return correctLine;
    }
}
