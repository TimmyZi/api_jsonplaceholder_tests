package apiframework.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import apiframework.helpers.JsonHelper;

public record ResponseForm(int statusCode, String body) {

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public JsonObject getBodyAsJsonObject() {
        return JsonHelper.parseToJsonObject(body);
    }

    public JsonArray getBodyAsJsonArray() {
        return JsonHelper.parseToJsonArray(body);
    }
}
