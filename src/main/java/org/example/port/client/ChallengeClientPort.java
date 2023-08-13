package org.example.port.client;


import org.example.mapping.UserDto;
import org.example.domain.UserResponse;

import java.io.IOException;

public interface ChallengeClientPort {

    UserDto getUserDto() throws IOException;

    UserResponse getUserResponseDto() throws IOException;

}
