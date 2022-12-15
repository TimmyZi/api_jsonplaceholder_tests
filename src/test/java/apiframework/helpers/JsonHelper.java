package apiframework.helpers;

import aquality.selenium.core.logging.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonHelper {

    public static JsonArray parseToJsonArray(String string) {
        return JsonParser.parseString(string).getAsJsonArray();
    }

    public static JsonObject parseToJsonObject(String string) {
        return JsonParser.parseString(string).getAsJsonObject();
    }

    public static JsonObject parseToJsonObject(Object model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(model);
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }

    public static boolean isJsonString(String string) {
        return JsonParser.parseString(string).isJsonObject() || JsonParser.parseString(string).isJsonArray();
    }

    public static boolean isJsonArraySortAscending(JsonArray jsonArray, String key) {
        Logger.getInstance().info("JsonArray Sort check");
        for (int i = 1; i < jsonArray.size(); i++) {
            if (jsonArray.get(i - 1).getAsJsonObject().get(key).getAsInt() > jsonArray.get(i).getAsJsonObject().get(key).getAsInt()) {
                Logger.getInstance().info("JsonArray not sorted in ascending order");
                return false;
            }
        }
        Logger.getInstance().info("JsonArray sorted in ascending order");
        return true;
    }

    public static boolean isJsonObjectEmpty(JsonObject jsonObject) {
        return jsonObject.size() == 0;
    }
}