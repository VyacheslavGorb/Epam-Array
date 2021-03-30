package edu.gorb.array.creator;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.FileException;
import edu.gorb.array.parser.ArrayParser;
import edu.gorb.array.reader.ArrayReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Objects;

public class ArrayCreator {
    private static final Logger logger = LogManager.getLogger();

    public IntArray createArrayEntity() throws FileException {
        var fileName = "files/array.txt";
        File file;
        try {
            file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getFile());
        } catch (NullPointerException e) {
            logger.log(Level.FATAL, "Resource file not found");
            throw new FileException("Resource file not found");
        }
        var absoluteFilePath = file.getAbsolutePath();
        ArrayReader reader = new ArrayReader();
        ArrayParser parser = new ArrayParser();
        String line = reader.readArrayLine(absoluteFilePath);
        IntArray array = parser.parseLine(line);
        logger.log(Level.INFO, "Entity created successfully");
        return array;
    }
}
