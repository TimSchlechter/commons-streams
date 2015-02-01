package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static net.itimothy.xstream.StreamUtils.xstream;

public class XCharacterStreamTest {
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
    public void contains_containsChar_shouldReturnTrue() {
        assertTrue(xstream("abc").contains('a'));
    }

    @Test
    public void contains_notContainsChar_shouldReturnFalse() {
        assertFalse(xstream("abc").contains('d'));
    }

    @Test
    public void union_bobAndCarol_shouldReturnDistinctChars() {
        assertEquals(
            asList('B','o','b','C','a','r','l'),
            xstream(Person.Bob.getName()).union(Person.Carol.getName()).toList()
        );
    }
}
