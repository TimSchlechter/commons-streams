package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Stream.concat;

/**
 * Base class for all X*Stream classes. Implements the extensions on the Streams API by using the implementations of the
 * standard API provided by the derived classes.
 *
 * @param <T> the type of the stream elements
 * @param <X> the type of of the stream implementing XBaseStream
 */
abstract class XBaseStream<T, X extends XBaseStream<T, X>> {

    /**
     * Determines whether a sequence contains a specified element.
     *
     * @param object the object to test
     * @return whether a sequence contains a specified element.
     */
    public boolean anyMatch(T object) {
        return anyMatch(i -> i.equals(object));
    }

    /**
     * Determines whether a sequence contains any elements.
     *
     * @return whether a sequence contains any elements.
     */
    public boolean any() {
        return first().isPresent();
    }

    /**
     * Produces the set union of two sequences by using the default equality comparer.
     *
     * @param other a stream whose distinct elements form the second set for the union.
     * @return the set union of two sequences by using the default equality comparer.
     */
    public X union(X other) {
        return createInstance(concat(boxed(), other.boxed()).distinct());
    }

    /**
     * Produces the set union of two sequences by using the default equality comparer.
     *
     * @param other a collection whose distinct elements form the second set for the union.
     * @return the set union of two sequences by using the default equality comparer.
     */
    public X union(Collection<T> other) {
        return union(createInstance(other.stream()));
    }

    /**
     * Produces the set intersection of two sequences by using the default equality comparer.
     *
     * @param other a stream whose distinct elements form the second set for the intersection.
     * @return the set intersection of two sequences by using the default equality comparer.
     * @implNote This function lazy evaluates this stream, but materializes {@other}
     */
    public X intersect(X other) {
        List<T> otherMaterialized = other.toList();
        return filter(otherMaterialized::contains).distinct();
    }

    /**
     * Produces the set intersection of two sequences by using the default equality comparer.
     *
     * @param other a collection whose distinct elements form the second set for the intersection.
     * @return the set intersection of two sequences by using the default equality comparer.
     * @implNote This function lazy evaluates this stream, but materializes {@other}
     */
    public X intersect(Collection<T> other) {
        return intersect(createInstance(other.stream()));
    }

    /**
     * Produces the set difference of two sequences by using the default equality comparer.
     *
     * @param other a stream whose distinct elements form the second set for the intersection.
     * @return the set difference of two sequences by using the default equality comparer.
     * @implNote This function lazy evaluates this stream, but materializes {@other}
     */
    public X difference(X other) {
        List<T> otherMaterialized = other.toList();
        return filter(o -> !otherMaterialized.contains(o)).distinct();
    }

    /**
     * Produces the set difference of two sequences by using the default equality comparer.
     *
     * @param other a collection whose distinct elements form the second set for the intersection.
     * @return the set difference of two sequences by using the default equality comparer.
     * @implNote This function lazy evaluates this stream, but materializes {@other}
     */
    public X difference(Collection<T> other) {
        return difference(createInstance(other.stream()));
    }

    /**
     * Returns a stream consisting of the elements of this stream, sorted by comparing the value provided by the
     * given{@keyExtractor}
     *
     * @param keyExtractor the function used to extract the {@link Comparable} sort key
     */
    public <U extends Comparable<? super U>> X sorted(Function<? super T, ? extends U> keyExtractor) {
        return sorted(Comparator.comparing(keyExtractor));
    }

    /**
     * Returns a stream consisting of the elements of this stream without the given {@object}
     *
     * @param object the object to exclude
     */
    public X without(T object) {
        return filter(i -> !i.equals(object));
    }

    /**
     * Accumulates the input elements into a new {@code List}
     *
     * @return the input elements into a new {@code List}
     */
    public List<T> toList() {
        return collect(Collectors.toList());
    }

    /**
     * Accumulates elements into a {@code Map} whose keys are the result of applying the provided {@keyMapper} function
     * to the input elements. The values are the elements.
     *
     * @param keyMapper a mapping function to produce keys
     * @param <K>       the output type of the key mapping function
     * @return the elements into a {@code Map} whose keys are the result of applying the provided {@keyMapper} function
     * to the input elements. The values are the elements
     */
    public <K> Map<K, T> toMap(Function<? super T, ? extends K> keyMapper) {
        return toMap(keyMapper, x -> x);
    }

    /**
     * Accumulates elements into a {@code Map} whose keys and values are the result of applying the provided mapping
     * functions to the input elements.
     *
     * @param <K>         the output type of the key mapping function
     * @param <U>         the output type of the value mapping function
     * @param keyMapper   a mapping function to produce keys
     * @param valueMapper a mapping function to produce values
     * @return the elements into a {@code Map} whose keys and values are the result of applying mapping functions to the
     * input elements
     */
    public <K, U> Map<K, U> toMap(
        Function<? super T, ? extends K> keyMapper,
        Function<? super T, ? extends U> valueMapper) {
        return collect(Collectors.toMap(keyMapper, valueMapper));
    }

    /**
     * Accumulates the input elements into a new {@code Set}
     *
     * @return the input elements into a new {@code Set}
     */
    public Set<T> toSet() {
        return collect(Collectors.toSet());
    }

    protected abstract X createInstance(Stream<T> stream);

    public abstract XStream<T> boxed();

    public abstract X filter(Predicate<? super T> predicate);

    public abstract <R> XStream<R> map(Function<? super T, ? extends R> mapper);

    public abstract XIntStream mapToInt(ToIntFunction<? super T> mapper);

    public abstract XLongStream mapToLong(ToLongFunction<? super T> mapper);

    public abstract XDoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);

    public abstract <R> XStream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

    public abstract XIntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);

    public abstract XLongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);

    public abstract XDoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);

    protected abstract Optional<T> first();

    public abstract X distinct();

    public abstract X sorted();

    public abstract X sorted(Comparator<? super T> comparator);

    public abstract X peek(Consumer<? super T> action);

    public abstract X limit(long maxSize);

    public abstract X skip(long n);

    public abstract void forEach(Consumer<? super T> action);

    public abstract void forEachOrdered(Consumer<? super T> action);

    public abstract <A> A[] toArray(IntFunction<A[]> generator);

    public abstract T reduce(T identity, BinaryOperator<T> accumulator);

    public abstract Optional<T> reduce(BinaryOperator<T> accumulator);

    public abstract <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);

    public abstract <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner);

    public abstract <R, A> R collect(Collector<? super T, A, R> collector);

    public abstract long count();

    public abstract boolean anyMatch(Predicate<? super T> predicate);

    public abstract boolean allMatch(Predicate<? super T> predicate);

    public abstract boolean noneMatch(Predicate<? super T> predicate);

    protected abstract Iterator<T> iterator();

    protected abstract Spliterator<T> spliterator();

    public abstract boolean isParallel();

    public abstract X sequential();

    public abstract X parallel();

    public abstract X unordered();

    public abstract X onClose(Runnable closeHandler);

    public abstract void close();
}
