package org.example.adapter.client;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.exceptions.CustomException;
import org.example.mapping.UserDto;
import org.example.domain.UserResponse;
import org.example.port.client.ChallengeClientPort;

import java.io.IOException;

public class ChallengeClientAdapter implements ChallengeClientPort {
    public final static String route = "https://coderbyte.com/api/challenges/json/rest-get-simple";
    public final static String ROUTE_CLEAN = "https://coderbyte.com/api/challenges/json/json-cleaning";

    @Override
    public UserDto getUserDto() throws IOException, JsonSyntaxException, CustomException {

        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        Request request = new Request.Builder()
                .url(route)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        validateError(response.code());
        return gson.fromJson(response.body().string(), UserDto.class);
    }

    @Override
    public UserResponse getUserResponseDto() throws JsonSyntaxException, CustomException, IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        Request request = new Request.Builder()
                .url(ROUTE_CLEAN)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        validateError(response.code());
        return gson.fromJson(response.body().string(), UserResponse.class);
    }

    private void validateError(int code) {
        if (code != 200) {
            throw new CustomException("Can not get user information");
        }
    }

}
