package Utilities;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONReader {

    FileReader reader;
    public JsonObject readJSONFile(String filePath) {
        try {
             reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (JsonObject) JsonParser.parseString(String.valueOf(reader));
    }
}
