package org.example.adapter.outbound;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.example.domain.vos.Education;
import org.example.domain.vos.Name;
import org.example.exceptions.CustomException;
import org.example.mapping.UserDto;
import org.example.domain.UserResponse;
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

    @Override
    public String getUserCleanInfo() {
        try{
            UserResponse user = client.getUserResponseDto();
            return buildNewObject(user);
        }catch (IOException | JsonSyntaxException | CustomException e) {
            throw new CustomException(e.getMessage());
        }
    }

    private String buildNewObject(UserResponse source){
        Gson gson = new Gson();
        UserResponse newObject = new UserResponse();
        newObject.setAge(source.getAge());
        newObject.setDOB(getValue(source.getDOB()));
        newObject.setName(getNameClean(source.getName()));
        newObject.setEducation(getEducationClean(source.getEducation()));
        newObject.setHobbies(getHobbiesClean(source.getHobbies()));
        return gson.toJson(newObject);
    }

    private List<String> getHobbiesClean(List<String> hobbies){
        return hobbies.stream().filter(e->!isCandidateToClean(e)).toList();
    }
    private Education getEducationClean(Education source){
        Education clean = new Education();
        clean.setCollege(getValue(source.getCollege()));
        clean.setHighschool(getValue(source.getHighschool()));
        return clean;
    }

    private Name getNameClean(Name source){
        Name clean = new Name();
        clean.setFirst(getValue(source.getFirst()));
        clean.setLast(getValue(source.getLast()));
        clean.setMiddle(getValue(source.getMiddle()));
        return clean;
    }

    private String getValue(String value){
        return isCandidateToClean(value) ? null : value;
    }

    private boolean isCandidateToClean(String value){
        return value.equals("N/A") || value.isEmpty() || value.equals("-");
    }

}
