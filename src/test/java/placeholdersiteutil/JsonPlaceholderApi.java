package placeholdersiteutil;

import apiframework.api.ApiManager;
import apiframework.config.ConfigManager;
import apiframework.models.ResponseForm;
import com.google.gson.JsonObject;

public class JsonPlaceholderApi {

    private static final String URL = ConfigManager.getUrl();
    private static final String REQUEST_FOR_POSTS = URL + ConfigManager.getSettings().getValue("/urnPosts").toString();
    private static final String REQUEST_FOR_USERS = URL + ConfigManager.getSettings().getValue("/urnUsers").toString();

    public static ResponseForm getPostsResponse() {
        return ApiManager.getResponse(REQUEST_FOR_POSTS);
    }

    public static ResponseForm getUsersResponse() {
        return ApiManager.getResponse(REQUEST_FOR_USERS);
    }

    public static ResponseForm getPostResponse(int number) {
        return ApiManager.getResponse(String.format("%s/%d", REQUEST_FOR_POSTS, number));
    }

    public static ResponseForm getUserResponse(int number) {
        return ApiManager.getResponse(String.format("%s/%d", REQUEST_FOR_USERS, number));
    }

    public static ResponseForm getPostRequestResponse(JsonObject requestParameters) {
        return ApiManager.postResponse(requestParameters, REQUEST_FOR_POSTS);
    }
}
