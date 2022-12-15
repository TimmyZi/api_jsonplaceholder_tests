package tests;

import placeholdersiteutil.JsonPlaceholderApi;
import placeholdersiteutil.models.PostModel;
import placeholdersiteutil.testdata.TestDataHolder;
import apiframework.helpers.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import apiframework.helpers.JsonHelper;
import apiframework.helpers.RandomHelper;
import apiframework.models.ResponseForm;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiPlaceholderTest {

    private static final int RANDOM_TITLE_LENGTH = 80;
    private static final int RANDOM_BODY_LENGTH = 120;

    @Test
    public void ApiTest() throws JsonProcessingException {

        //Step 1
        ResponseForm response = JsonPlaceholderApi.getPostsResponse();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code incorrect");
        Assert.assertTrue(JsonHelper.isJsonString(response.getBody()), "Response body is not by JSON");
        Assert.assertTrue(JsonHelper.isJsonArraySortAscending(response.getBodyAsJsonArray(), TestDataHolder.ID), "Response body not sorted in ascending order");

        //Step 2
        response = JsonPlaceholderApi.getPostResponse(TestDataHolder.CORRECT_POST_NUMBER);
        PostModel postInfo = Converter.convertJsonToJava(response.getBody(), PostModel.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code incorrect");
        Assert.assertFalse(postInfo.getTitle().isEmpty(), "Title is empty");
        Assert.assertFalse(postInfo.getBody().isEmpty(), "Body is empty");
        Assert.assertEquals(TestDataHolder.TEST_USER_ID, postInfo.getUserId(), "Invalid userId");
        Assert.assertEquals(TestDataHolder.TEST_ID, postInfo.getId(), "Invalid id");

        //Step 3
        response = JsonPlaceholderApi.getPostResponse(TestDataHolder.INCORRECT_POST_NUMBER);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND, "Status code incorrect");
        Assert.assertTrue(JsonHelper.isJsonObjectEmpty(response.getBodyAsJsonObject()), "Body is not empty");

        //Step 4
        String randomTitle = RandomHelper.getRandomString(RANDOM_TITLE_LENGTH);
        String randomBody = RandomHelper.getRandomString(RANDOM_BODY_LENGTH);
        Integer userId = TestDataHolder.TEST_USER_ID_NUMBER;
        PostModel expectedPost = new PostModel(userId, randomTitle, randomBody);
        response = JsonPlaceholderApi.getPostRequestResponse(JsonHelper.parseToJsonObject(expectedPost));
        PostModel actualPost = Converter.convertJsonToJava(response.body(), PostModel.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Status code incorrect");
        Assert.assertEquals(actualPost.getTitle(), expectedPost.getTitle(), "Request title and response title are not equal");
        Assert.assertEquals(actualPost.getBody(), expectedPost.getBody(), "Request body and response body are not equal");
        Assert.assertEquals(actualPost.getUserId(), expectedPost.getUserId(), "Request userId and response userId are not equal");
        Assert.assertFalse(actualPost.getId().toString().isEmpty(), "Response id is empty");

        //Step 5
        response = JsonPlaceholderApi.getUsersResponse();
        JsonObject userInfo = response.getBodyAsJsonArray().get(TestDataHolder.TEST_USER_INDEX).getAsJsonObject();
        JsonObject expectedUserInfo = JsonHelper.parseToJsonObject(TestDataHolder.TEST_USER.toString());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code incorrect");
        Assert.assertTrue(JsonHelper.isJsonString(response.getBody()), "Response body is not by JSON");
        Assert.assertEquals(userInfo, expectedUserInfo, "User data is not equal");

        //Step 6
        response = JsonPlaceholderApi.getUserResponse(TestDataHolder.USER_NUMBER);
        JsonObject actualUserInfo = response.getBodyAsJsonObject();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code incorrect");
        Assert.assertEquals(actualUserInfo, userInfo, "User data is not equal");
    }
}