package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class XIntStream extends XPrimitiveBaseStream<Integer, XIntStream> implements IntStream {
    private final IntStream stream;

    public static XIntStream wrap(IntStream stream) {
        return new XIntStream(stream);
    }

    private XIntStream(IntStream stream) {
        this.stream = stream;
    }

    @Override
    public XIntStream filter(IntPredicate predicate) {
        return wrap(stream.filter(predicate));
    }

    @Override
    public XIntStream map(IntUnaryOperator mapper) {
        return wrap(stream.map(mapper));
    }

    @Override
    public <U> Stream<U> mapToObj(IntFunction<? extends U> mapper) {
        return stream.mapToObj(mapper);
    }

    @Override
    public XLongStream mapToLong(IntToLongFunction mapper) {
        return XLongStream.wrap(stream.mapToLong(mapper));
    }

    @Override
    public XDoubleStream mapToDouble(IntToDoubleFunction mapper) {
        return XDoubleStream.wrap(stream.mapToDouble(mapper));
    }

    @Override
    public XIntStream flatMap(IntFunction<? extends IntStream> mapper) {
        return wrap(stream.flatMap(mapper));
    }

    @Override
    public XIntStream peek(IntConsumer action) {
        return wrap(stream.peek(action));
    }

    @Override
    public void forEach(IntConsumer action) {
        stream.forEach(action);
    }

    @Override
    public void forEachOrdered(IntConsumer action) {
        stream.forEachOrdered(action);
    }

    @Override
    public int[] toArray() {
        return stream.toArray();
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        return stream.reduce(identity, op);
    }

    @Override
    public OptionalInt reduce(IntBinaryOperator op) {
        return stream.reduce(op);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    @Override
    public int sum() {
        return stream.sum();
    }

    @Override
    public OptionalInt min() {
        return stream.min();
    }

    @Override
    public OptionalInt max() {
        return stream.max();
    }

    @Override
    public OptionalDouble average() {
        return stream.average();
    }

    @Override
    public IntSummaryStatistics summaryStatistics() {
        return null;
    }

    @Override
    public boolean anyMatch(IntPredicate predicate) {
        return stream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(IntPredicate predicate) {
        return stream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(IntPredicate predicate) {
        return stream.noneMatch(predicate);
    }

    @Override
    public OptionalInt findFirst() {
        return stream.findFirst();
    }

    @Override
    public Optional<Integer> first() {
        OptionalInt val = findFirst();
        return val.isPresent() ? Optional.ofNullable(val.getAsInt()) : Optional.ofNullable(null);
    }

    @Override
    public OptionalInt findAny() {
        return stream.findAny();
    }

    @Override
    public XLongStream asLongStream() {
        return XLongStream.wrap(stream.asLongStream());
    }

    @Override
    public XDoubleStream asDoubleStream() {
        return XDoubleStream.wrap(stream.asDoubleStream());
    }

    @Override
    public XStream<Integer> boxed() {
        return XStream.wrap(stream.boxed());
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return stream.iterator();
    }

    @Override
    public Spliterator.OfInt spliterator() {
        return stream.spliterator();
    }

    @Override
    protected XIntStream createInstance(Stream<Integer> stream) {
        return wrap(stream.mapToInt(x -> x));
    }

    @Override
    public XIntStream filter(Predicate<? super Integer> predicate) {
        return wrap(stream.filter(t -> predicate.test(t)));
    }


    @Override
    public XIntStream mapToInt(ToIntFunction<? super Integer> mapper) {
        return this;
    }


    @Override
    public XIntStream distinct() {
        return wrap(stream.distinct());
    }

    @Override
    public XIntStream sorted() {
        return wrap(stream.sorted());
    }

    @Override
    public XIntStream sorted(Comparator<? super Integer> comparator) {
        return wrap(boxed().sorted(comparator).mapToInt(x -> x));
    }

    @Override
    public XIntStream peek(Consumer<? super Integer> action) {
        return wrap(boxed().peek(action).mapToInt(x -> x));
    }

    @Override
    public XIntStream limit(long maxSize) {
        return wrap(stream.limit(maxSize));
    }

    @Override
    public XIntStream skip(long n) {
        return wrap(stream.skip(n));
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        boxed().forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super Integer> action) {
        boxed().forEachOrdered(action);
    }


    @Override
    public long count() {
        return stream.count();
    }

    @Override
    public boolean isParallel() {
        return stream.isParallel();
    }

    @Override
    public XIntStream sequential() {
        return wrap(stream.sequential());
    }

    @Override
    public XIntStream parallel() {
        return wrap(stream.parallel());
    }

    @Override
    public XIntStream unordered() {
        return wrap(stream.unordered());
    }

    @Override
    public XIntStream onClose(Runnable closeHandler) {
        return wrap(stream.onClose(closeHandler));
    }

    @Override
    public void close() {
        stream.close();
    }
}