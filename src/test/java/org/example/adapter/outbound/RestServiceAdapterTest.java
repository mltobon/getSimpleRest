package org.example.adapter.outbound;

import com.google.gson.Gson;
import org.example.adapter.client.ChallengeClientAdapter;
import org.example.domain.UserResponse;
import org.example.domain.vos.Education;
import org.example.domain.vos.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.LoadJson;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class RestServiceAdapterTest {

    @Mock
    private ChallengeClientAdapter client;
    @InjectMocks
    private RestServiceAdapter service;
    private String expected;

    @BeforeEach
    void setUp() {
        UserResponse userExpected= new UserResponse();
        Gson gson = new Gson();
        userExpected.setHobbies(List.of("running","coding"));
        userExpected.setName(new Name("Robert",null,"Smith"));
        userExpected.setAge(25);
        userExpected.setEducation(new Education(null,"Yale"));
        expected = gson.toJson(userExpected);
    }

    @Test
    void getUserCleanInfo() throws IOException {
        UserResponse response = LoadJson.getUser();
        Mockito.when(client.getUserResponseDto()).thenReturn(response);
        String result = service.getUserCleanInfo();
        Assertions.assertEquals(expected, result);
    }
}