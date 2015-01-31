package net.itimothy.xstream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Creates xstream instances
 */
public class StreamFactory {
    public static XIntStream xstream(int... items) {
        return XIntStream.wrap(Arrays.stream(items));
    }

    public static XLongStream xstream(long... items) {
        return XLongStream.wrap(Arrays.stream(items));
    }

    public static XDoubleStream xstream(double... items) {
        return XDoubleStream.wrap(Arrays.stream(items));
    }

    public static <T> XBaseStream<T, XStream<T>> xstream(T[] items) {
        return xstream(Arrays.stream(items));
    }

    public static <T> XStream<T> xstream(Collection<T> collection) {
        return xstream(collection.stream());
    }

    public static <T> XStream<T> xstream(Stream<T> stream) {
        return XStream.wrap(stream);
    }
}
