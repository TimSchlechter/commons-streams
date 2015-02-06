package net.itimothy.commons.streams;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.commons.streams.StreamUtils.stream;
import static org.junit.Assert.*;

public class XCharacterStreamTest extends BaseTest {
    @Test
    public void any_null_shouldReturnFalse() {
        assertFalse(stream((String) null).any());
    }

    @Test
    public void any_emptyString_shouldReturnFalse() {
        assertFalse(stream("").any());
    }

    @Test
    public void any_nonEmptyString_shouldReturnTrue() {
        assertTrue(stream("a").any());
    }

    @Test
    public void anyMatch_containsChar_shouldReturnTrue() {
        assertTrue(stream("abc").anyMatch('a'));
    }

    @Test
    public void anyMatch_notContainsChar_shouldReturnFalse() {
        assertFalse(stream("abc").anyMatch('d'));
    }

    @Test
    public void union_bobAndCarol_shouldReturnDistinctChars() {
        assertXStream(
            asList('B', 'o', 'b', 'C', 'a', 'r', 'l'),
            stream(Person.Bob.getName()).union(Person.Carol.getName())
        );
    }
}
