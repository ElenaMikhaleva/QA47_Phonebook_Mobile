package api_okhttp;

import com.google.gson.Gson;
import dto.User;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import utils.BaseAPI;

public class Login implements BaseAPI {
    public static void main(String[] args) {

    }
    public void login(User user) {
        RequestBody requestBody = RequestBody.create(GSON.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL+LOGIN_URL)
                .post(requestBody)
                .build()
                ;
        Response response;
    }
}
