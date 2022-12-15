package placeholdersiteutil.testdata;

import com.google.gson.JsonObject;
import apiframework.config.ConfigManager;
import apiframework.helpers.JsonHelper;

public class TestDataHolder {
    public static final String ID = "id";
    public static final int CORRECT_POST_NUMBER = Integer.parseInt(ConfigManager.getTestData().getValue("/correctPostNumber").toString());
    public static final int INCORRECT_POST_NUMBER = Integer.parseInt(ConfigManager.getTestData().getValue("/incorrectPostNumber").toString());
    public static final int USER_NUMBER = Integer.parseInt(ConfigManager.getTestData().getValue("/testUserNumber").toString());
    public static final int TEST_USER_ID = Integer.parseInt(ConfigManager.getTestData().getValue("/testUserId").toString());
    public static final int TEST_ID = Integer.parseInt(ConfigManager.getTestData().getValue("/testId").toString());
    public static final int TEST_USER_ID_NUMBER = Integer.parseInt(ConfigManager.getTestData().getValue("/testUserIdNumber").toString());
    public static final int TEST_USER_INDEX = Integer.parseInt(ConfigManager.getTestData().getValue("/testUserIndex").toString());
    public static final JsonObject TEST_USER = JsonHelper.parseToJsonObject(ConfigManager.getTestData().getValue("/testUser").toString());
}
