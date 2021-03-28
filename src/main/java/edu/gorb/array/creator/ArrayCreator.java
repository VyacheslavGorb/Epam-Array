package edu.gorb.array.creator;

import edu.gorb.array.enity.IntArray;
import edu.gorb.array.exception.FileException;
import edu.gorb.array.exception.ValidityException;
import edu.gorb.array.parser.ArrayParser;
import edu.gorb.array.reader.ArrayReader;

public class ArrayCreator {
    public IntArray createArrayEntity(String fileName) throws FileException, ValidityException {
        ArrayReader reader = new ArrayReader();
        ArrayParser parser = new ArrayParser();
        String line = reader.readArrayLine(fileName);
        IntArray array = parser.parseLine(line);
        return array;
    }
}
