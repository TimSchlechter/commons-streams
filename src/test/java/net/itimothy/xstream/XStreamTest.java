package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.xstream.StreamUtils.xstream;
import static org.junit.Assert.*;

public class XStreamTest {
    @Test
    public void union_emptyStreams_shouldReturnNoValues() {
        assertEquals(
            asList(),
            xstream().union(xstream()).toList()
        );
    }

    @Test
    public void sorted() {
        Person[] people = {Person.Ann, Person.Bob, Person.Carol};

        assertEquals(
            asList(Person.Ann, Person.Bob, Person.Carol),
            xstream(people).sorted(p -> p.getName()).toList()
        );

        assertEquals(
            asList(Person.Carol, Person.Bob, Person.Ann),
            xstream(people).sorted(p -> p.getAge()).toList()
        );
    }
}