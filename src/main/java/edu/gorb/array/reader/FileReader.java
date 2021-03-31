package edu.gorb.array.reader;

import edu.gorb.array.exception.FileReadException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String filePathString) throws FileReadException {
        File file = new File(filePathString);
        if (!file.isFile()) {
            logger.log(Level.ERROR, "{} is not valid filepath", filePathString);
            throw new FileReadException(filePathString + " is not valid filepath");
        }
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        Path path = Paths.get(filePathString);
        List<String> readLines;
        try (Stream<String> lines = Files.lines(path)) {
            readLines = lines.collect(Collectors.toList());
        } catch (IOException exception) {
            logger.log(Level.ERROR, "Error while reading file: {}", filePathString);
            throw new FileReadException("Error while reading file: " + filePathString);
        }
        logger.log(Level.INFO, "Correct line was read in file: {}", filePathString);
        return readLines;
    }
}
