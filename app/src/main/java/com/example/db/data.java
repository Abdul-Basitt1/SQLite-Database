package com.example.db;

public class data {
    private String id;
    private String name;
    private String email;
    private String number;
    private String Degree;
    private String skill;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public data(String id,String name,String email,String number,String deg,String skill){
        this.id=id;
        this.name=name;
        this.email=email;
        this.number=number;
        this.Degree=deg;
        this.skill=skill;
    }
}
