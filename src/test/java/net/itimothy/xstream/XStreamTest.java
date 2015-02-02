package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.xstream.StreamUtils.xstream;
import static org.junit.Assert.assertEquals;

public class XStreamTest extends BaseTest {
    @Test
    public void union_emptyStreams_shouldReturnNoValues() {
        assertEquals(
            asList(),
            xstream().union(xstream()).toList()
        );
    }

    @Test
    public void sorted() {
        assertXStream(
            Person.getSortedByName(),
            xstream(Person.getAll()).sorted(p -> p.getName())
        );

        assertXStream(
            Person.getSortedByAge(),
            xstream(Person.getAll()).sorted(p -> p.getAge())
        );
    }

    @Test
    public void union_streamWithDistinctValues_shouldReturnAllValues() {
        assertXStream(
            xstream(asList(Person.Ann, Person.Bob)),
            xstream(Person.Ann.asList()).union(xstream(Person.Bob.asList()))
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertXStream(
            xstream(asList(Person.Ann, Person.Bob)),
            xstream(asList(Person.Ann, Person.Bob))
                .union(asList(Person.Bob, Person.Ann))
        );
    }

    @Test
    public void without_objectInStream_shouldReturnAllOtherObjects() {
        assertXStream(
            xstream(asList(Person.Ann)),
            xstream(asList(Person.Ann, Person.Bob)).without(Person.Bob)
        );
    }


}