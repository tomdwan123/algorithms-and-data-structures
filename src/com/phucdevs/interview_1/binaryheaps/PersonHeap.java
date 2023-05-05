package com.phucdevs.interview_1.binaryheaps;

public class PersonHeap implements Comparable<PersonHeap> {

    private String name;
    private int age;

    public PersonHeap(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "PersonHeap{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(PersonHeap otherPerson) {
        return Integer.compare(age, otherPerson.getAge());
    }
}
