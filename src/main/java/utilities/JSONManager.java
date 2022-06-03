package utilities;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONManager {
    private static FileReader reader;
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
        JSONParser parser = new JSONParser();
        object = (JSONObject) parser.parse(reader);
        return object;
    }

    public static Object getJSONData(JSONObject object, String keyPath, Types type) {
        return getObject(keyPath, type, object);
    }

    public static Object getJSONData(String filePath, String keyPath, Types type) throws IOException, ParseException {
        object = readJSONFile(filePath);
        return getObject(keyPath, type, object);
    }

    private static Object getObject(String keyPath, Types type, JSONObject object) {
        Object data;
        switch (type) {
            case STRING -> data = getDataAsString(object, keyPath);
            case MAP -> data = getDataAsMap(object, keyPath);
            case LIST -> data = getDataAsList(object, keyPath);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        if (data != null)
            return data;
        else {
            System.out.println("No data found");
        }
        return null;
    }

    private static String getDataAsString(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        return jsonPath.getJsonObject(keyPath).toString();
    }

    private static Map<?, ?> getDataAsMap(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        return jsonPath.getMap(keyPath);
    }

    private static List<?> getDataAsList(JSONObject object, String keyPath) {
        jsonPath = new JsonPath(String.valueOf(object));
        return jsonPath.getList(keyPath);
    }

    public enum Types {
        STRING, MAP, LIST
    }
}
