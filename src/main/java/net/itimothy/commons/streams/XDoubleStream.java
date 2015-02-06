package net.itimothy.commons.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class XDoubleStream extends XPrimitiveBaseStream<Double, XDoubleStream> implements DoubleStream {
    private final DoubleStream stream;

    private XDoubleStream(DoubleStream stream) {
        this.stream = stream;
    }

    public static XDoubleStream wrap(DoubleStream stream) {
        return new XDoubleStream(stream);
    }

    @Override
    public XStream<Double> boxed() {
        return XStream.wrap(stream.boxed());
    }

    @Override
    public void close() {
        stream.close();
    }

    @Override
    public long count() {
        return stream.count();
    }

    @Override
    protected XDoubleStream createInstance(Stream<Double> stream) {
        return wrap(stream.mapToDouble(x -> x));
    }

    @Override
    public XDoubleStream distinct() {
        return wrap(stream.distinct());
    }

    @Override
    public XDoubleStream filter(Predicate<? super Double> predicate) {
        return wrap(stream.filter(t -> predicate.test(t)));
    }

    @Override
    public Optional<Double> first() {
        OptionalDouble val = findFirst();
        return val.isPresent() ? Optional.ofNullable(val.getAsDouble()) : Optional.ofNullable(null);
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        boxed().forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super Double> action) {
        boxed().forEachOrdered(action);
    }

    @Override
    public boolean isParallel() {
        return stream.isParallel();
    }

    @Override
    public PrimitiveIterator.OfDouble iterator() {
        return stream.iterator();
    }

    @Override
    public XDoubleStream limit(long maxSize) {
        return wrap(stream.limit(maxSize));
    }

    @Override
    public XIntStream mapToInt(ToIntFunction<? super Double> mapper) {
        return XIntStream.wrap(stream.mapToInt(value -> mapper.applyAsInt(value)));
    }

    @Override
    public XDoubleStream onClose(Runnable closeHandler) {
        return wrap(stream.onClose(closeHandler));
    }

    @Override
    public XDoubleStream parallel() {
        return wrap(stream.parallel());
    }

    @Override
    public XDoubleStream peek(Consumer<? super Double> action) {
        return wrap(boxed().peek(action).mapToDouble(x -> x));
    }

    @Override
    public XDoubleStream sequential() {
        return wrap(stream.sequential());
    }

    @Override
    public XDoubleStream skip(long n) {
        return wrap(stream.skip(n));
    }

    @Override
    public XDoubleStream sorted() {
        return wrap(stream.sorted());
    }

    @Override
    public XDoubleStream sorted(Comparator<? super Double> comparator) {
        return wrap(boxed().sorted(comparator).mapToDouble(x -> x));
    }

    @Override
    public Spliterator.OfDouble spliterator() {
        return stream.spliterator();
    }

    @Override
    public XDoubleStream unordered() {
        return wrap(stream.unordered());
    }

    @Override
    public XDoubleStream filter(DoublePredicate predicate) {
        return wrap(stream.filter(predicate));
    }

    @Override
    public XDoubleStream map(DoubleUnaryOperator mapper) {
        return wrap(stream.map(mapper));
    }

    @Override
    public <U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper) {
        return stream.mapToObj(mapper);
    }

    @Override
    public XIntStream mapToInt(DoubleToIntFunction mapper) {
        return XIntStream.wrap(stream.mapToInt(mapper));
    }

    @Override
    public LongStream mapToLong(DoubleToLongFunction mapper) {
        return stream.mapToLong(mapper);
    }

    @Override
    public XDoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper) {
        return wrap(stream.flatMap(mapper));
    }

    @Override
    public XDoubleStream peek(DoubleConsumer action) {
        return wrap(stream.peek(action));
    }

    @Override
    public void forEach(DoubleConsumer action) {
        stream.forEach(action);
    }

    @Override
    public void forEachOrdered(DoubleConsumer action) {
        stream.forEachOrdered(action);
    }

    @Override
    public double[] toArray() {
        return stream.toArray();
    }

    @Override
    public double reduce(double identity, DoubleBinaryOperator op) {
        return stream.reduce(identity, op);
    }

    @Override
    public OptionalDouble reduce(DoubleBinaryOperator op) {
        return stream.reduce(op);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    @Override
    public double sum() {
        return stream.sum();
    }

    @Override
    public OptionalDouble min() {
        return stream.min();
    }

    @Override
    public OptionalDouble max() {
        return stream.max();
    }

    @Override
    public OptionalDouble average() {
        return stream.average();
    }

    @Override
    public DoubleSummaryStatistics summaryStatistics() {
        return null;
    }

    @Override
    public boolean anyMatch(DoublePredicate predicate) {
        return stream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(DoublePredicate predicate) {
        return stream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(DoublePredicate predicate) {
        return stream.noneMatch(predicate);
    }

    @Override
    public OptionalDouble findFirst() {
        return stream.findFirst();
    }

    @Override
    public OptionalDouble findAny() {
        return stream.findAny();
    }
}
