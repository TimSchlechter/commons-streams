package net.itimothy.xstream;

import java.util.Optional;
import java.util.function.*;
import java.util.stream.*;

public abstract class XPrimitiveBaseStream<T, X extends XPrimitiveBaseStream<T, X>> extends XBaseStream<T, X> {
    public <R> XStream<R> map(Function<? super T, ? extends R> mapper) {
        return boxed().map(mapper);
    }

    public XLongStream mapToLong(ToLongFunction<? super T> mapper) {
        return boxed().mapToLong(mapper);
    }

    public XDoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return boxed().mapToDouble(mapper);
    }

    public <R> XStream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return boxed().flatMap(mapper);
    }

    public XIntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return boxed().flatMapToInt(mapper);
    }

    public XLongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return boxed().flatMapToLong(mapper);
    }


    public XDoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return boxed().flatMapToDouble(mapper);
    }

    public <A> A[] toArray(IntFunction<A[]> generator) {
        return boxed().toArray(generator);
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return boxed().reduce(identity, accumulator);
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return boxed().reduce(accumulator);
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return boxed().reduce(identity, accumulator, combiner);
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return boxed().collect(supplier, accumulator, combiner);
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return boxed().collect(collector);
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return boxed().anyMatch(predicate);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return boxed().allMatch(predicate);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return boxed().noneMatch(predicate);
    }
}
