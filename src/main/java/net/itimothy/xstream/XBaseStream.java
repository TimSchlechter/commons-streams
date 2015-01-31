package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Stream.concat;

public abstract class XBaseStream<T, X extends XBaseStream<T, X>> {

    /**
     * Checks if the given item is in stream
     *
     * @param item the item to test
     * @return true if item is in stream, else false
     */
    public boolean contains(T item) {
        return anyMatch(i -> i.equals(item));
    }

    public boolean any() {
        return anyMatch(t -> t == t);
    }

    public X union(X other) {
        return unboxed(concat(boxed(), other.boxed()).distinct());
    }

    public List<T> toList() {
        return collect(Collectors.toList());
    }

    protected abstract X unboxed(Stream<T> stream);

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
