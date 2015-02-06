package net.itimothy.commons.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Provides utility methods and decorators for {@link Stream} instances.
 */
public class StreamUtils {
    /**
     * Returns a sequential {@link XIntStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XIntStream} for the array
     */
    public static XIntStream stream(int... items) {
        return XIntStream.wrap(Arrays.stream(items));
    }

    /**
     * Returns a sequential {@link XLongStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XLongStream} for the array
     */
    public static XLongStream stream(long... items) {
        return XLongStream.wrap(Arrays.stream(items));
    }

    /**
     * Returns a sequential {@link XDoubleStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XDoubleStream} for the array
     */
    public static XDoubleStream stream(double... items) {
        return XDoubleStream.wrap(Arrays.stream(items));
    }

    /**
     * Returns a sequential {@link XCharacterStream} with the specified string as its source.
     *
     * @param string the string
     * @return an {@code XCharacterStream} for the string
     */
    public static XCharacterStream stream(String string) {
        return XCharacterStream.wrap(string);
    }

    /**
     * Returns a sequential {@link XBaseStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XBaseStream<T, XStream<T>> stream(T[] items) {
        return stream(Arrays.stream(items));
    }

    /**
     * Returns a sequential {@link XStream} with the specified collection as its source.
     *
     * @param collection the collection, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XStream<T> stream(Collection<T> collection) {
        return stream(collection.stream());
    }

    /**
     * Returns a sequential {@link XStream} with the specified {@link Stream} as its source.
     *
     * @param stream the collection, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XStream<T> stream(Stream<T> stream) {
        return XStream.wrap(stream);
    }

    /**
     * Returns a parallel {@link XIntStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XIntStream} for the array
     */
    public static XIntStream parallelStream(int... items) {
        return stream(items).parallel();
    }

    /**
     * Returns a parallel {@link XLongStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XLongStream} for the array
     */
    public static XLongStream parallelStream(long... items) {
        return stream(items).parallel();
    }

    /**
     * Returns a parallel {@link XDoubleStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XDoubleStream} for the array
     */
    public static XDoubleStream parallelStream(double... items) {
        return stream(items).parallel();
    }

    /**
     * Returns a parallel {@link XCharacterStream} with the specified string as its source.
     *
     * @param string the string
     * @return an {@code XCharacterStream} for the string
     */
    public static XCharacterStream parallelStream(String string) {
        return stream(string).parallel();
    }

    /**
     * Returns a parallel {@link XBaseStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XBaseStream<T, XStream<T>> parallelStream(T[] items) {
        return stream(items).parallel();
    }

    /**
     * Returns a parallel {@link XStream} with the specified collection as its source.
     *
     * @param collection the collection, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XStream<T> parallelStream(Collection<T> collection) {
        return stream(collection).parallel();
    }

    /**
     * Returns a parallel {@link XStream} with the specified {@link Stream} as its source.
     *
     * @param stream the collection, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XStream<T> parallelStream(Stream<T> stream) {
        return stream(stream).parallel();
    }

    /**
     * Returns a unordered {@link XIntStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XIntStream} for the array
     */
    public static XIntStream unorderedStream(int... items) {
        return stream(items).unordered();
    }

    /**
     * Returns a unordered {@link XLongStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XLongStream} for the array
     */
    public static XLongStream unorderedStream(long... items) {
        return stream(items).unordered();
    }

    /**
     * Returns a unordered {@link XDoubleStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XDoubleStream} for the array
     */
    public static XDoubleStream unorderedStream(double... items) {
        return stream(items).unordered();
    }

    /**
     * Returns a unordered {@link XCharacterStream} with the specified string as its source.
     *
     * @param string the string
     * @return an {@code XCharacterStream} for the string
     */
    public static XCharacterStream unorderedStream(String string) {
        return stream(string).unordered();
    }

    /**
     * Returns a unordered {@link XBaseStream} with the specified array as its source.
     *
     * @param items the array, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XBaseStream<T, XStream<T>> unorderedStream(T[] items) {
        return stream(items).unordered();
    }

    /**
     * Returns a unordered {@link XStream} with the specified collection as its source.
     *
     * @param collection the collection, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XStream<T> unorderedStream(Collection<T> collection) {
        return stream(collection).unordered();
    }

    /**
     * Returns a unordered {@link XStream} with the specified {@link Stream} as its source.
     *
     * @param stream the collection, assumed to be unmodified during use
     * @return an {@code XBaseStream} for the array
     */
    public static <T> XStream<T> unorderedStream(Stream<T> stream) {
        return stream(stream).unordered();
    }
}
