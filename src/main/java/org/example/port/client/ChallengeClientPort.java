package org.example.port.client;


import org.example.mapping.UserDto;

import java.io.IOException;

public interface ChallengeClientPort {

    UserDto getUserDto() throws IOException;

}
