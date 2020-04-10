package javaStreamsAndEnums.javastreams.Person;

import javaStreamsAndEnums.javastreams.Enums.Gender;

public class Person {

    private String person;
    private int age;
    private Gender gender;


    public Person(String person, int age, Gender gender) {
        this.person = person;
        this.age = age;
        this.gender = gender;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person='" + person + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
