package net.itimothy.xstream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BaseTest {
    public <T, X extends XBaseStream<T, X>> void assertXStream(XBaseStream<T, X> expected, XBaseStream<T, X> actual) {
        List<T> expectedList = new ArrayList<>(expected.toList());
        List<T> actualList = new ArrayList<>(actual.toList());

        assertEquals(expectedList, actualList);
    }

    public <T, X extends XBaseStream<T, X>> void assertXStream(Collection<T> expected, XBaseStream<T, X> actual) {
        List<T> expectedList = new ArrayList<>(expected);
        List<T> actualList = new ArrayList<>(actual.toList());

        assertEquals(expectedList, actualList);
    }

    public <T, X extends XBaseStream<T, X>> void assertXStream(XBaseStream<T, X> expected, Collection<T> actual) {
        List<T> expectedList = new ArrayList<>(expected.toList());
        List<T> actualList = new ArrayList<>(actual);
        
        assertEquals(expectedList, actualList);
    }
}
