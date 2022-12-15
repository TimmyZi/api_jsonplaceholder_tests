package apiframework.api;

import apiframework.models.ResponseForm;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiManager {

    public static ResponseForm getResponse(String uri) {
        Response response = given().get(uri);
        return new ResponseForm(response.getStatusCode(), response.then().extract().body().asString());
    }

    public static ResponseForm postResponse(JsonObject requestParameters, String uri) {
        Response response = given().header("Content-Type", "application/json").body(requestParameters.toString()).when().post(uri);
        return new ResponseForm(response.getStatusCode(), response.then().extract().body().asString());
    }
}