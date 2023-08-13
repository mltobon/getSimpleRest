package org.example.domain;


import org.example.domain.vos.Education;
import org.example.domain.vos.Name;

import java.util.List;


public class UserResponse {
    private Name name;
    private int age;
    private String DOB;
    private List<String> hobbies;
    private Education education;

    public UserResponse() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

}
