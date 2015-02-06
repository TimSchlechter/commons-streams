package net.itimothy.commons.streams;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.itimothy.commons.streams.StreamUtils.stream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class XStreamTest extends BaseTest {
    @Test
    public void union_emptyStreams_shouldReturnNoValues() {
        assertEquals(
            asList(),
            stream().union(stream(asList())).toList()
        );
    }

    @Test
    public void sorted_test() {
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

    @Test
    public void without_predicate_shouldReturnAllNonMatchingObjects() {
        assertXStream(
            stream(asList(Person.Ann)),
            stream(asList(Person.Ann, Person.Bob, Person.Carol))
                .without(p -> p.getAge() < 25)
        );
    }

    @Test
      public void findFirst_matchingPredicate_ShouldReturnPresentOptional() {
        assertEquals(
            Person.Bob,
            stream(Person.getAll())
                .findFirst(p -> p.getName() == Person.Bob.getName())
                .get()
        );
    }

    @Test
    public void findFirst_nonMatchingPredicate_ShouldReturnNonPresentOptional() {
        assertFalse(
            stream(Person.getAll())
                .findFirst(p -> p.getName() == "non-matching-name")
                .isPresent()
        );
    }

    @Test
    public void findFirstOrDefault_matchingPredicate_ShouldReturnMatchingObject() {
        assertEquals(
            Person.Bob,
            stream(Person.getAll())
                .findFirstOrDefault(p -> p.getName() == Person.Bob.getName(), Person.Carol)
        );
    }

    @Test
    public void findFirstOrDefault_nonMatchingPredicate_ShouldReturnDefaultValue() {
        assertEquals(
            Person.Carol,
            stream(Person.getAll())
                .findFirstOrDefault(p -> p.getName() == "non-matching-name", Person.Carol)
        );
    }

    @Test
    public void findFirstOrNull_matchingPredicate_ShouldReturnMatchingObject() {
        assertEquals(
            Person.Bob,
            stream(Person.getAll())
                .findFirstOrNull(p -> p.getName() == Person.Bob.getName())
        );
    }

    @Test
    public void findFirstOrNull_nonMatchingPredicate_ShouldReturnNull() {
        assertEquals(
            null,
            stream(Person.getAll())
                .findFirstOrNull(p -> p.getName() == "non-matching-name")
        );
    }

    @Test
    public void flatten_test() {
        assertXStream(
            asList("root", "1", "2", "2.1", "2.2", "2.2.1", "2.3", "2.3.1", "2.3.2"),
            stream(Node.SimpleTree)
                .flatten(n -> stream(n.getChildren()))
                .map(n -> n.getName())
        );
    }
}