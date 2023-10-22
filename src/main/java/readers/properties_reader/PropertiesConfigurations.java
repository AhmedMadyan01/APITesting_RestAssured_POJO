package readers.properties_reader;

public class PropertiesConfigurations {
    private static String executionAddress;
    private static String executionAddressConfig;
    private static String platformName;



    public static void setConfigProperties() {
        setExecutionAddress(PropertiesDataManager.getProperty("executionAddress", PropertiesDataManager.Capability.EXECUTION));
        setExecutionAddressConfig(PropertiesDataManager.getProperty("executionAddressConfig", PropertiesDataManager.Capability.EXECUTION));
        setPlatformName(PropertiesDataManager.getProperty("platformName", PropertiesDataManager.Capability.EXECUTION));
    }

    public static String getCapability(String capability, String filePath) {
        return PropertiesDataManager.getProperty(capability, filePath);
    }

    public static String getExecutionAddress() {
        return executionAddress;
    }

    public static void setExecutionAddress(String executionAddress) {
        PropertiesConfigurations.executionAddress = executionAddress;
    }

    public static String getExecutionAddressConfig() {
        return executionAddressConfig;
    }

    public static void setExecutionAddressConfig(String executionAddressConfig) {
        PropertiesConfigurations.executionAddressConfig = executionAddressConfig;
    }

    public static String getPlatformName() {
        return platformName;
    }

    public static void setPlatformName(String platformName) {
        PropertiesConfigurations.platformName = platformName;
    }
}