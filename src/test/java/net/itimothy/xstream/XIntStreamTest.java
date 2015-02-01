package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.xstream.StreamUtils.xstream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XIntStreamTest {
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
}
