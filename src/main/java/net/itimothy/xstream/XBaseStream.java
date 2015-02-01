package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Stream.concat;

abstract class XBaseStream<T extends Object, X extends XBaseStream<T, X>> {

    public boolean contains(T item) {
        return anyMatch(i -> i.equals(item));
    }

    public boolean any() {
        return anyMatch(t -> t == t);
    }

    public X union(X other) {
        return createInstance(concat(boxed(), other.boxed()).distinct());
    }

    public X union(Collection<T> other) {
        return createInstance(concat(boxed(), other.stream()).distinct());
    }

    public X union(T... other) {
        return createInstance(concat(boxed(), Arrays.stream(other)).distinct());
    }

    public <U extends Comparable<? super U>> X sorted(Function<? super T, ? extends U> keyExtractor) {
        return sorted(Comparator.comparing(keyExtractor));
    }
    
    public X without(T item) {
        return filter(i -> !i.equals(item));
    }

    public List<T> toList() {
        return collect(Collectors.toList());
    }

    public <K> Map<K,T> toMap(Function<? super T, ? extends K> keyMapper) {
        return toMap(keyMapper, x -> x);
    }
    
    public <K, U> Map<K,U> toMap(
            Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends U> valueMapper) {
        return collect(Collectors.toMap(keyMapper, valueMapper));
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
