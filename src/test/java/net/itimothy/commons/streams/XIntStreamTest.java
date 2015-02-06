package net.itimothy.commons.streams;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.commons.streams.StreamUtils.stream;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XIntStreamTest extends BaseTest {
    @Test
    public void contains_valueInStream_shouldReturnTrue() {
        assertTrue(stream(1, 2, 3).contains(1));
    }

    @Test
    public void contains_valueNotInStream_shouldReturnFalse() {
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
        assertXStream(
            stream(new int[] {1, 2}),
            stream(new int[] {1}).union(stream(new int[] {2}))
        );
    }

    @Test
    public void union_streamWithSameValues_shouldReturnAllUniqueValues() {
        assertXStream(
            stream(new int[] {1, 2, 3}),
            stream(new int[] {1, 2}).union(stream(new int[] {2, 3}))
        );
    }

    @Test
    public void intersect_oneValueInBothStreams_shouldReturnOneValue() {
        assertXStream(
            stream(new int[]{2}),
            stream(new int[]{1, 2}).intersect(asList(2, 3))
        );
    }

    @Test
    public void intersect_noSharedValues_shouldReturnEmptyStream() {
        assertXStream(
            stream().mapToInt(i -> 0),
            stream(new int[] {1, 2}).intersect(asList(3, 4))
        );
    }

    @Test
    public void intersect_sameValue_shouldReturnDistinctValues() {
        assertXStream(
            stream(new int[] {1}),
            stream(new int[] {1, 1}).intersect(asList(1))
        );
    }

    @Test
    public void difference_oneValueInBothStreams_shouldReturnValuesOnlyInFirstStream() {
        assertXStream(
            stream(new int[] {1}),
            stream(new int[] {1, 2}).difference(asList(2, 3))
        );
    }

    @Test
    public void difference_noSharedValues_shouldReturnAllValuesInFirstStream() {
        assertXStream(
            stream(new int[] {1, 2}),
            stream(new int[] {1, 2}).difference(asList(3, 4))
        );
    }

    @Test
    public void difference_sameValue_shouldReturnDistinctValuesOnlyInFirstStream() {
        assertXStream(
            stream(new int[] {1}),
            stream(new int[] {1, 1, 2}).difference(asList(2))
        );
    }

    @Test
    public void without_valueInStream_shouldReturnAllOtherValues() {
        assertXStream(
            stream(new int[] {1, 2}),
            stream(new int[] {1, 2, 3}).without(3)
        );
    }
}
