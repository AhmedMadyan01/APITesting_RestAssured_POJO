package Utilities;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONManager {

    private static FileReader reader;
    private static JSONParser parser;
    JsonPath jsonPath;
    private static JSONObject object = null;

    public static JSONObject readJSONFile(String filePath) throws IOException, ParseException {
        if (filePath != null)
            try {
                reader = new FileReader(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        else System.out.println("Please send the JSON file path");
        object = (JSONObject) parser.parse(reader);
        return object;
    }

    public static void getJSONData(JSONObject object, String keyPath, Types type) {

    }

    public static void getJSONData(String filePath, String keyPath, Types type) throws IOException, ParseException {
        object = readJSONFile(filePath);

    }

    private String getStringFromJSONObject(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        jsonPath.getJsonObject(keyPath);
        return jsonPath.toString();
    }

    private enum Types {
        STRING, HASHMAP, LIST, LIST_HASHMAP
    }
}
