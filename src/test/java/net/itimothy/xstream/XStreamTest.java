package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.xstream.StreamFactory.xstream;
import static org.junit.Assert.*;

public class XStreamTest {
    @Test
    public void contains_itemInStream_shouldReturnTrue() {
        assertTrue(xstream(1, 2, 3).contains(1));
    }

    @Test
    public void contains_itemNotInStream_shouldReturnFalse() {
        assertFalse(xstream(1, 2, 3).contains(4));
    }

    @Test
    public void any_emptyStream_shouldReturnFalse() {
        assertFalse(xstream().any());
    }

    @Test
    public void any_nonEmptyStream_shouldReturnTrue() {
        assertTrue(xstream(1).any());
    }

    @Test
    public void union_streamWithDistinctValues_shouldReturnAllValues() {
        assertEquals(
            asList(1, 2),
            xstream(1).union(xstream(2)).toList()
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertEquals(
            asList(1, 2, 3),
            xstream(1, 2).union(xstream(2, 3)).toList()
        );
    }

    @Test
    public void union_emptyStreams_shouldReturnNoValues() {
        assertEquals(
            asList(),
            xstream().union(xstream()).toList()
        );
    }

    @Test
    public void sortBy() {
        Person anna = new Person("anna", 30);
        Person bob = new Person("bob", 20);
        Person carol = new Person("carol", 10);

        Person[] people = {anna, bob, carol};

        assertEquals(
            asList(anna, bob, carol),
            xstream(people).sorted(p -> p.getName()).toList()
        );

        assertEquals(
            asList(carol, bob, anna),
            xstream(people).sorted(p -> p.getAge()).toList()
        );
    }
}

class Person {
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
