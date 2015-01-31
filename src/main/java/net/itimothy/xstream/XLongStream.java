package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class XLongStream extends XBaseStream<Long, XLongStream> implements LongStream {
    private final LongStream stream;

    public static XLongStream wrap(LongStream stream) {
        return new XLongStream(stream);
    }

    private XLongStream(LongStream stream) {
        this.stream = stream;
    }

    @Override
    public LongStream filter(LongPredicate predicate) {
        return null;
    }

    @Override
    public LongStream map(LongUnaryOperator mapper) {
        return null;
    }

    @Override
    public <U> Stream<U> mapToObj(LongFunction<? extends U> mapper) {
        return null;
    }

    @Override
    public IntStream mapToInt(LongToIntFunction mapper) {
        return null;
    }

    @Override
    public DoubleStream mapToDouble(LongToDoubleFunction mapper) {
        return null;
    }

    @Override
    public LongStream flatMap(LongFunction<? extends LongStream> mapper) {
        return null;
    }

    @Override
    public LongStream peek(LongConsumer action) {
        return null;
    }

    @Override
    public void forEach(LongConsumer action) {

    }

    @Override
    public void forEachOrdered(LongConsumer action) {

    }

    @Override
    public long[] toArray() {
        return new long[0];
    }

    @Override
    public long reduce(long identity, LongBinaryOperator op) {
        return 0;
    }

    @Override
    public OptionalLong reduce(LongBinaryOperator op) {
        return null;
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return null;
    }

    @Override
    public long sum() {
        return 0;
    }

    @Override
    public OptionalLong min() {
        return null;
    }

    @Override
    public OptionalLong max() {
        return null;
    }

    @Override
    public OptionalDouble average() {
        return null;
    }

    @Override
    public LongSummaryStatistics summaryStatistics() {
        return null;
    }

    @Override
    public boolean anyMatch(LongPredicate predicate) {
        return false;
    }

    @Override
    public boolean allMatch(LongPredicate predicate) {
        return false;
    }

    @Override
    public boolean noneMatch(LongPredicate predicate) {
        return false;
    }

    @Override
    public OptionalLong findFirst() {
        return null;
    }

    @Override
    public OptionalLong findAny() {
        return null;
    }

    @Override
    public DoubleStream asDoubleStream() {
        return null;
    }

    @Override
    protected XLongStream createInstance(Stream<Long> stream) {
        return wrap(stream.mapToLong(x -> x));
    }

    @Override
    public XStream<Long> boxed() {
        return null;
    }

    @Override
    public PrimitiveIterator.OfLong iterator() {
        return null;
    }

    @Override
    public Spliterator.OfLong spliterator() {
        return null;
    }

    @Override
    public XLongStream filter(Predicate<? super Long> predicate) {
        return null;
    }

    @Override
    public <R> XStream<R> map(Function<? super Long, ? extends R> mapper) {
        return null;
    }

    @Override
    public XIntStream mapToInt(ToIntFunction<? super Long> mapper) {
        return null;
    }

    @Override
    public XLongStream mapToLong(ToLongFunction<? super Long> mapper) {
        return null;
    }

    @Override
    public XDoubleStream mapToDouble(ToDoubleFunction<? super Long> mapper) {
        return null;
    }

    @Override
    public <R> XStream<R> flatMap(Function<? super Long, ? extends Stream<? extends R>> mapper) {
        return null;
    }

    @Override
    public XIntStream flatMapToInt(Function<? super Long, ? extends IntStream> mapper) {
        return null;
    }

    @Override
    public XLongStream flatMapToLong(Function<? super Long, ? extends LongStream> mapper) {
        return null;
    }

    @Override
    public XDoubleStream flatMapToDouble(Function<? super Long, ? extends DoubleStream> mapper) {
        return null;
    }

    @Override
    public XLongStream distinct() {
        return null;
    }

    @Override
    public XLongStream sorted() {
        return null;
    }

    @Override
    public XLongStream sorted(Comparator<? super Long> comparator) {
        return null;
    }

    @Override
    public XLongStream peek(Consumer<? super Long> action) {
        return null;
    }

    @Override
    public XLongStream limit(long maxSize) {
        return null;
    }

    @Override
    public XLongStream skip(long n) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Long> action) {

    }

    @Override
    public void forEachOrdered(Consumer<? super Long> action) {

    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return null;
    }

    @Override
    public Long reduce(Long identity, BinaryOperator<Long> accumulator) {
        return null;
    }

    @Override
    public Optional<Long> reduce(BinaryOperator<Long> accumulator) {
        return null;
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super Long, U> accumulator, BinaryOperator<U> combiner) {
        return null;
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super Long> accumulator, BiConsumer<R, R> combiner) {
        return null;
    }

    @Override
    public <R, A> R collect(Collector<? super Long, A, R> collector) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean anyMatch(Predicate<? super Long> predicate) {
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super Long> predicate) {
        return false;
    }

    @Override
    public boolean noneMatch(Predicate<? super Long> predicate) {
        return false;
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @Override
    public XLongStream sequential() {
        return null;
    }

    @Override
    public XLongStream parallel() {
        return null;
    }

    @Override
    public XLongStream unordered() {
        return null;
    }

    @Override
    public XLongStream onClose(Runnable closeHandler) {
        return null;
    }

    @Override
    public void close() {

    }
}
