package net.itimothy.xstream;

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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
