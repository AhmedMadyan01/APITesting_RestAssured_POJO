package Utilities;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JSONManager {

    private static FileReader reader;
    private static final JSONParser parser = new JSONParser();

    private static JsonPath jsonPath;
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

    public static void getJSONData(JSONObject object, String keyPath, ReturnDataTypes type) {

    }

    public static Object getJSONData(String filePath, String keyPath, ReturnDataTypes type) throws IOException, ParseException {
        object = readJSONFile(filePath);
        Object data;
        switch (type) {
            case STRING -> data = getStringFromJSONObject(object, keyPath);
            case HASHMAP -> data = getHashMapFromJSONObject(object, keyPath);
            case LIST -> data = getListFromJSONObject(object, keyPath);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        if (data != null)
            return data;
        else {
            System.out.println("No data found");
        }
        return null;
    }

    private static String getStringFromJSONObject(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        return jsonPath.getJsonObject(keyPath).toString();
    }

    private static List<?> getListFromJSONObject(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        return jsonPath.getList(keyPath);
    }

    private static HashMap<?, ?> getHashMapFromJSONObject(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        return jsonPath.getJsonObject(keyPath);
    }

    public enum ReturnDataTypes {
        STRING, HASHMAP, LIST
    }
}
