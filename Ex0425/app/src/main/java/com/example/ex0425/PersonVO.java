package com.example.ex0425;

public class PersonVO {

    private String name;
    private int age;
    private boolean gender;

    //firebase database 에서 VO타입으로 읽어올때
    //기본생성자는 반드시! 정의가 되어있어야 읽어올 수 있다!
    public PersonVO() {

    }

    public PersonVO(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
