package utils;

import com.google.gson.Gson;
import org.example.domain.UserResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadJson {

    private static final String user = "src/test/resources/user.json";

    public static UserResponse getUser() {
        try {
            Gson gson = new Gson();
            return gson.fromJson(Files.newBufferedReader(Paths.get(user)), UserResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
