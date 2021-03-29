package edu.gorb.array.creator;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.FileException;
import edu.gorb.array.parser.ArrayParser;
import edu.gorb.array.reader.ArrayReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreator {
    private static final Logger logger = LogManager.getLogger();

    public IntArray createArrayEntity() throws FileException {
        var fileName = "testFile1.txt";
        ArrayReader reader = new ArrayReader();
        ArrayParser parser = new ArrayParser();
        String line = reader.readArrayLine(fileName);
        IntArray array = parser.parseLine(line);
        logger.log(Level.INFO, "Entity created successfully");
        return array;
    }
}
