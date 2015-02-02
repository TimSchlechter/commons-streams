package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.xstream.StreamUtils.xstream;
import static org.junit.Assert.*;

public class XCharacterStreamTest extends BaseTest {
    @Test
    public void any_null_shouldReturnFalse() {
        assertFalse(xstream((String)null).any());
    }

    @Test
    public void any_emptyString_shouldReturnFalse() {
        assertFalse(xstream("").any());
    }

    @Test
    public void any_nonEmptyString_shouldReturnTrue() {
        assertTrue(xstream("a").any());
    }

    @Test
    public void anyMatch_containsChar_shouldReturnTrue() {
        assertTrue(xstream("abc").anyMatch('a'));
    }

    @Test
    public void anyMatch_notContainsChar_shouldReturnFalse() {
        assertFalse(xstream("abc").anyMatch('d'));
    }

    @Test
    public void union_bobAndCarol_shouldReturnDistinctChars() {
        assertXStream(
            asList('B', 'o', 'b', 'C', 'a', 'r', 'l'),
            xstream(Person.Bob.getName()).union(Person.Carol.getName())
        );
    }
}
