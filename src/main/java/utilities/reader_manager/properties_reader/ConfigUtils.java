package utilities.reader_manager.properties_reader;

public class ConfigUtils {
    private static final String config_Properties = "/src/main/resources/config.properties";
    private static String requires_BaseURI;
    private static String requires_BasePath;

    private static void setConfigProperties() {
        requires_BaseURI = PropertiesReaderManager.getProperties("requires_BaseURI", config_Properties);
        requires_BasePath = PropertiesReaderManager.getProperties("requires_BasePath", config_Properties);
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