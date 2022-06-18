package utilities.reader_manager.properties_reader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderManager {

    private static String readProperties(String key, String filePathContentRoot) {
        Properties properties = new Properties();
        try {
            String projectPath = System.getProperty("user.dir");
            InputStream inputStream = new FileInputStream((projectPath + filePathContentRoot));
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getMessage() + "\n");
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    static String getProperties(String key, String filePathContentRoot) {
        return readProperties(key, filePathContentRoot).trim();
    }
}