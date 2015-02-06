package net.itimothy.commons.streams;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.commons.streams.StreamUtils.stream;
import static org.junit.Assert.assertEquals;

public class XStreamTest extends BaseTest {
    @Test
    public void union_emptyStreams_shouldReturnNoValues() {
        assertEquals(
            asList(),
            stream().union(stream()).toList()
        );
    }

    @Test
    public void sorted() {
        assertXStream(
            Person.getSortedByName(),
            stream(Person.getAll()).sorted(p -> p.getName())
        );

        assertXStream(
            Person.getSortedByAge(),
            stream(Person.getAll()).sorted(p -> p.getAge())
        );
    }

    @Test
    public void union_streamWithDistinctValues_shouldReturnAllValues() {
        assertXStream(
            stream(asList(Person.Ann, Person.Bob)),
            stream(Person.Ann.asList()).union(stream(Person.Bob.asList()))
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertXStream(
            stream(asList(Person.Ann, Person.Bob)),
            stream(asList(Person.Ann, Person.Bob))
                .union(asList(Person.Bob, Person.Ann))
        );
    }

    @Test
    public void without_objectInStream_shouldReturnAllOtherObjects() {
        assertXStream(
            stream(asList(Person.Ann)),
            stream(asList(Person.Ann, Person.Bob)).without(Person.Bob)
        );
    }


}