package apiframework.helpers;

import com.google.gson.Gson;

public class Converter {

    public static <T> T convertJsonToJava(String jsonType, Class<T> clazz ) {
        return (T) new Gson().fromJson(jsonType, clazz);
    }
}
