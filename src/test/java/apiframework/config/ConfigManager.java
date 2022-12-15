package apiframework.config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class ConfigManager {

    private static final ISettingsFile SETTINGS = new JsonSettingsFile("settings.json");
    private static final ISettingsFile TEST_DATA = new JsonSettingsFile("testData.json");

    public static String getUrl() {
        return SETTINGS.getValue("/url").toString();
    }

    public static ISettingsFile getSettings() {
        return SETTINGS;
    }

    public static ISettingsFile getTestData() {
        return TEST_DATA;
    }
}