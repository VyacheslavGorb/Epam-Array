package edu.gorb.array.reader;

import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.validator.ArrayValidator;
import edu.gorb.array.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArrayFileReader {
    private static final Logger logger = LogManager.getLogger();
    private static final ArrayValidator arrayValidator = new ArrayValidator();
    private static final FileValidator fileValidator = new FileValidator();

    public String readFile(String filePathString) throws ArrayException {
        if (!fileValidator.isValidFile(filePathString)) {
            logger.log(Level.ERROR, "File path represents invalid file");
            throw new ArrayException("File path represents invalid file");
        }
        Path path = Paths.get(filePathString);
        String correctLine = null;
        try (var fileLines = Files.lines(path)) {
            correctLine = fileLines
                    .filter(arrayValidator::isValidLine)
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
