package org.example.adapter.outbound;

import com.google.gson.JsonSyntaxException;
import org.example.exceptions.CustomException;
import org.example.mapping.UserDto;
import org.example.port.client.ChallengeClientPort;
import org.example.port.outbound.RestServicePort;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class RestServiceAdapter implements RestServicePort {

    private final ChallengeClientPort client;

    public RestServiceAdapter(ChallengeClientPort client) {
        this.client = client;
    }

    @Override
    public List<String> getHobbiesList() {
        try {
            UserDto userDto = client.getUserDto();
            return userDto.hobbies()
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .toList();

        } catch (IOException | JsonSyntaxException | CustomException e) {
            throw new CustomException(e.getMessage());
        }
    }
}
