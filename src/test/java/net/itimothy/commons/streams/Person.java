package net.itimothy.commons.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Person {
    public final static Person Ann = new Person("Ann", 30);
    public final static Person Bob = new Person("Bob", 20);
    public final static Person Carol = new Person("Carol", 10);

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> getAll() {
        return Arrays.asList(Ann, Bob, Carol);
    }

    public static List<Person> getAllMen() {
        return Arrays.asList(Bob);
    }

    public static List<Person> getAllWomen() {
        return Arrays.asList(Ann, Carol);
    }

    public static List<Person> getSortedByAge() {
        return getAll().stream()
            .sorted(Comparator.comparing(p -> p.getAge()))
            .collect(toList());
    }

    public static List<Person> getSortedByName() {
        return getAll().stream()
            .sorted(Comparator.comparing(p -> p.getName()))
            .collect(toList());
    }

    public List<Person> asList() {
        return Arrays.asList(this);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
