package net.itimothy.commons.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Creates xstream instances
 */
public class StreamUtils {
    public static XIntStream stream(int... items) {
        return XIntStream.wrap(Arrays.stream(items));
    }

    public static XLongStream stream(long... items) {
        return XLongStream.wrap(Arrays.stream(items));
    }

    public static XDoubleStream stream(double... items) {
        return XDoubleStream.wrap(Arrays.stream(items));
    }

    public static XCharacterStream stream(String string) {
        return XCharacterStream.wrap(string);
    }
    
    public static <T> XBaseStream<T, XStream<T>> stream(T[] items) {
        return stream(Arrays.stream(items));
    }

    public static <T> XStream<T> stream(Collection<T> collection) {
        return stream(collection.stream());
    }

    public static <T> XStream<T> stream(Stream<T> stream) {
        return XStream.wrap(stream);
    }
}
