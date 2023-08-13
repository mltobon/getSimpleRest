package org.example.mapping;

import java.util.List;

public record UserDto(String name, int age, List<String> hobbies) {
}
