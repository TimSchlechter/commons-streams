package net.itimothy.commons.streams;

import org.junit.Test;

import static net.itimothy.commons.streams.StreamUtils.stream;
import static org.junit.Assert.*;

public class XIntStreamTest extends BaseTest {
    @Test
    public void anyMatch_valueInStream_shouldReturnTrue() {
        assertTrue(stream(1, 2, 3).anyMatch(1));
    }

    @Test
    public void anyMatch_valueNotInStream_shouldReturnFalse() {
        assertFalse(stream(1, 2, 3).anyMatch(4));
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
        assertXStream(
            stream(1, 2),
            stream(1).union(stream(2))
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertXStream(
            stream(1, 2, 3),
            stream(1, 2).union(stream(2, 3))
        );
    }

    @Test
    public void intersect_oneValueInBothStreams_shouldReturnOneValue() {
        assertXStream(
            stream(2),
            stream(1, 2).intersect(stream(2, 3))
        );
    }

    @Test
    public void intersect_noSharedValues_shouldReturnEmptyStream() {
        assertXStream(
            stream(),
            stream(1, 2).intersect(stream(3, 4))
        );
    }

    @Test
    public void intersect_sameValue_shouldReturnDistinctValues() {
        assertXStream(
            stream(1),
            stream(1, 1).intersect(stream(1))
        );
    }

    @Test
    public void difference_oneValueInBothStreams_shouldReturnValuesOnlyInFirstStream() {
        assertXStream(
            stream(1),
            stream(1, 2).difference(stream(2, 3))
        );
    }

    @Test
    public void difference_noSharedValues_shouldReturnAllValuesInFirstStream() {
        assertXStream(
            stream(1, 2),
            stream(1, 2).difference(stream(3, 4))
        );
    }

    @Test
    public void difference_sameValue_shouldReturnDistinctValuesOnlyInFirstStream() {
        assertXStream(
            stream(1),
            stream(1, 1, 2).difference(stream(2))
        );
    }

    @Test
    public void without_valueInStream_shouldReturnAllOtherValues() {
        assertXStream(
            stream(1, 2),
            stream(1, 2, 3).without(3)
        );
    }
}
