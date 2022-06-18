package utilities.reader_manager.properties_reader;

public class ConfigUtils {
    private static final String CONFIG_PROPERTIES_FILE_PATH = "/src/main/resources/config.properties";
    private static String requires_BaseURI;
    private static String requires_BasePath;

    private static void setConfigProperties() {
        requires_BaseURI = PropertiesDataManager.getProperty("requires_BaseURI", CONFIG_PROPERTIES_FILE_PATH);
        requires_BasePath = PropertiesDataManager.getProperty("requires_BasePath", CONFIG_PROPERTIES_FILE_PATH);
    }

    public static String getRequires_BaseURI() {
        setConfigProperties();
        return requires_BaseURI;
    }

    public static String getRequires_BasePath() {
        setConfigProperties();
        return requires_BasePath;
    }
}