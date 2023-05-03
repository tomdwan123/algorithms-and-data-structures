package com.phucdevs.interview_1.linkedlist;

public class App {

    public static void main(String[] args) {

        LinkedList<Person> peoples = new LinkedList<>();

        Person p = new Person(23, "Adam");

        peoples.insert(p);
        peoples.insert(new Person(34, "Daniel"));
        peoples.insert(new Person(56, "Michale"));

        peoples.remove(p);
        peoples.traverse();
    }
}
