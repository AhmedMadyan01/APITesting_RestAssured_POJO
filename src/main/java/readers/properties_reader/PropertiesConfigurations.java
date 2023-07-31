package readers.properties_reader;


import lombok.Getter;

public class PropertiesConfigurations {
    @Getter
    private static String execution_Platform;
    @Getter
    private static String targetRemoteExecution;

    public static void setConfigProperties() {
        setExecution_Platform(PropertiesDataManager.getProperty("executionPlatform", PropertiesDataManager.Capability.EXECUTION));
        setTargetRemoteExecution(PropertiesDataManager.getProperty("targetRemoteExecution", PropertiesDataManager.Capability.EXECUTION));
    }

    public static String getCapability(String capability, String filePath) {
        return PropertiesDataManager.getProperty(capability, filePath);
    }

    public static void setExecution_Platform(String execution_Platform) {
        PropertiesConfigurations.execution_Platform = execution_Platform;
    }

    public static void setTargetRemoteExecution(String targetRemoteExecution) {
        PropertiesConfigurations.targetRemoteExecution = targetRemoteExecution;
    }
}