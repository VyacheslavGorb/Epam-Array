package edu.gorb.array.main;

import edu.gorb.array.creator.ArrayCreator;
import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.ArrayException;
import edu.gorb.array.parser.ArrayParser;
import edu.gorb.array.reader.FileReader;
import edu.gorb.array.service.ArraySortService;
import edu.gorb.array.service.impl.ArraySortServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class ArrayMain {
    private static final Logger logger = LogManager.getLogger();
    private static final String RELATIVE_FILE_PATH = "files/array.txt";

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        ArrayParser parser = new ArrayParser();
        ArrayCreator creator = new ArrayCreator();
        ArraySortService sortService = new ArraySortServiceImpl();
        try {
            String absoluteFilePath = convertToAbsolutePath(RELATIVE_FILE_PATH);
            String numberLine = reader.readFile(absoluteFilePath);
            int[] rawArray = parser.parseLine(numberLine);
            IntArray intArray = creator.createArrayEntity(rawArray);
            sortService.quickSort(intArray);
            logger.log(Level.INFO, "Sorted array: {}", intArray);
        } catch (ArrayException e) {
            logger.log(Level.FATAL, e.getMessage());
        }
    }

    private static String convertToAbsolutePath(String relativePath) throws ArrayException {
        if (relativePath == null) {
            logger.log(Level.ERROR, "Relative path is null");
            throw new ArrayException("Relative path is null");
        }
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resourcePath = classLoader.getResource(relativePath);
        if (resourcePath == null) {
            logger.log(Level.ERROR, "File does not exist");
            throw new ArrayException("File does not exist");
        }
        File file = new File(resourcePath.getFile());
        return file.getAbsolutePath();
    }
}
