package net.itimothy.xstream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.xstream.XStream.stream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XStreamTest {
    @Test
    public void contains_itemInStream_shouldReturnTrue() {
        assertTrue(stream(1, 2, 3).contains(1));
    }

    @Test
    public void contains_itemNotInStream_shouldReturnFalse() {
        assertFalse(stream(1, 2, 3).contains(4));
    }

    @Test
    public void any_emptyStream_shouldReturnFalse() {
        assertFalse(stream().any());
    }

    @Test
    public void any_nonEmptyStream_shouldReturnTrue() {
        assertTrue(stream(1).any());
    }

    @Test
    public void union_streamWithDistinctValues_shouldReturnAllValues() {
        assertEquals(
                asList(1,2),
                stream(1).union(stream(2)).toList()
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertEquals(
                asList(1,2,3),
                stream(1,2).union(stream(2,3)).toList()
        );
    }

    @Test
    public void union_emptyStreams_shouldReturnNoValues() {
        assertEquals(
                asList(),
                stream().union(stream()).toList()
        );
    }
}
