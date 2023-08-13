package org.example.domain.vos;

public class Education {
    private String highschool;
    private String college;

    public Education() {
    }

    public Education(String highschool, String college) {
        this.highschool = highschool;
        this.college = college;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

}
