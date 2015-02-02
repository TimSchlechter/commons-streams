package net.itimothy.xstream;

import org.junit.Test;

import static net.itimothy.xstream.StreamUtils.xstream;
import static org.junit.Assert.*;

public class XIntStreamTest extends BaseTest {
    @Test
    public void anyMatch_objectInStream_shouldReturnTrue() {
        assertTrue(xstream(1, 2, 3).anyMatch(1));
    }

    @Test
    public void anyMatch_objectNotInStream_shouldReturnFalse() {
        assertFalse(xstream(1, 2, 3).anyMatch(4));
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
        assertXStream(
            xstream(1, 2),
            xstream(1).union(xstream(2))
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertXStream(
            xstream(1, 2, 3),
            xstream(1, 2).union(xstream(2, 3))
        );
    }

    @Test
    public void intersect_oneValueInBothStreams_shouldReturnOneValue() {
        assertXStream(
            xstream(2),
            xstream(1, 2).intersect(xstream(2, 3))
        );
    }

    @Test
    public void intersect_noSharedValues_shouldReturnEmptyStream() {
        assertXStream(
            xstream(),
            xstream(1, 2).intersect(xstream(3, 4))
        );
    }

    @Test
    public void without_objectInStream_shouldReturnAllOtherObjects() {
        assertXStream(
            xstream(1, 2),
            xstream(1, 2, 3).without(3)
        );
    }
}
