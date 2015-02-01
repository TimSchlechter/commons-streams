package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class XLongStream extends XPrimitiveBaseStream<Long, XLongStream> implements LongStream {
    private final LongStream stream;

    public static XLongStream wrap(LongStream stream) {
        return new XLongStream(stream);
    }

    private XLongStream(LongStream stream) {
        this.stream = stream;
    }

    @Override
    public XLongStream filter(LongPredicate predicate) {
        return wrap(stream.filter(predicate));
    }

    @Override
    public XLongStream map(LongUnaryOperator mapper) {
        return wrap(stream.map(mapper));
    }

    @Override
    public <U> Stream<U> mapToObj(LongFunction<? extends U> mapper) {
        return stream.mapToObj(mapper);
    }

    @Override
    public XDoubleStream mapToDouble(LongToDoubleFunction mapper) {
        return XDoubleStream.wrap(stream.mapToDouble(mapper));
    }

    @Override
    public XLongStream flatMap(LongFunction<? extends LongStream> mapper) {
        return wrap(stream.flatMap(mapper));
    }

    @Override
    public XLongStream peek(LongConsumer action) {
        return wrap(stream.peek(action));
    }

    @Override
    public void forEach(LongConsumer action) {
        stream.forEach(action);
    }

    @Override
    public void forEachOrdered(LongConsumer action) {
        stream.forEachOrdered(action);
    }

    @Override
    public long[] toArray() {
        return stream.toArray();
    }

    @Override
    public long reduce(long identity, LongBinaryOperator op) {
        return stream.reduce(identity, op);
    }

    @Override
    public OptionalLong reduce(LongBinaryOperator op) {
        return stream.reduce(op);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    @Override
    public long sum() {
        return stream.sum();
    }

    @Override
    public OptionalLong min() {
        return stream.min();
    }

    @Override
    public OptionalLong max() {
        return stream.max();
    }

    @Override
    public OptionalDouble average() {
        return stream.average();
    }

    @Override
    public LongSummaryStatistics summaryStatistics() {
        return null;
    }

    @Override
    public boolean anyMatch(LongPredicate predicate) {
        return stream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(LongPredicate predicate) {
        return stream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(LongPredicate predicate) {
        return stream.noneMatch(predicate);
    }

    @Override
    public OptionalLong findFirst() {
        return stream.findFirst();
    }

    @Override
    public OptionalLong findAny() {
        return stream.findAny();
    }

    @Override
    public XDoubleStream asDoubleStream() {
        return XDoubleStream.wrap(stream.asDoubleStream());
    }

    @Override
    public XStream<Long> boxed() {
        return XStream.wrap(stream.boxed());
    }

    @Override
    public PrimitiveIterator.OfLong iterator() {
        return stream.iterator();
    }

    @Override
    public Spliterator.OfLong spliterator() {
        return stream.spliterator();
    }

    @Override
    protected XLongStream createInstance(Stream<Long> stream) {
        return wrap(stream.mapToLong(x -> x));
    }

    @Override
    public XLongStream filter(Predicate<? super Long> predicate) {
        return wrap(stream.filter(t -> predicate.test(t)));
    }

    @Override
    public XIntStream mapToInt(ToIntFunction<? super Long> mapper) {
        return XIntStream.wrap(stream.mapToInt(value -> mapper.applyAsInt(value)));
    }

    @Override
    public XIntStream mapToInt(LongToIntFunction mapper) {
        return XIntStream.wrap(stream.mapToInt(mapper));
    }

    @Override
    public XLongStream distinct() {
        return wrap(stream.distinct());
    }

    @Override
    public XLongStream sorted() {
        return wrap(stream.sorted());
    }

    @Override
    public XLongStream sorted(Comparator<? super Long> comparator) {
        return wrap(boxed().sorted(comparator).mapToLong(x -> x));
    }

    @Override
    public XLongStream peek(Consumer<? super Long> action) {
        return wrap(boxed().peek(action).mapToLong(x -> x));
    }

    @Override
    public XLongStream limit(long maxSize) {
        return wrap(stream.limit(maxSize));
    }

    @Override
    public XLongStream skip(long n) {
        return wrap(stream.skip(n));
    }

    @Override
    public void forEach(Consumer<? super Long> action) {
        boxed().forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super Long> action) {
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
    public XLongStream sequential() {
        return wrap(stream.sequential());
    }

    @Override
    public XLongStream parallel() {
        return wrap(stream.parallel());
    }

    @Override
    public XLongStream unordered() {
        return wrap(stream.unordered());
    }

    @Override
    public XLongStream onClose(Runnable closeHandler) {
        return wrap(stream.onClose(closeHandler));
    }

    @Override
    public void close() {
        stream.close();
    }
}
