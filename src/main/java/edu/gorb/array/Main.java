package edu.gorb.array;

import edu.gorb.array.creator.ArrayCreator;
import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.FileException;
import edu.gorb.array.service.ArraySortService;
import edu.gorb.array.service.impl.ArraySortServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        IntArray array;
        try{
            array = creator.createArrayEntity();
        }catch (FileException e){
            logger.log(Level.ERROR,e.getMessage());
            return;
        }
        logger.log(Level.INFO, "Array created successfully");
        ArraySortService service = new ArraySortServiceImpl();
        service.quickSort(array);
        logger.log(Level.INFO, "Sorted array: {}", array);
    }
}
