package net.itimothy.xstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class XDoubleStream extends XPrimitiveBaseStream<Double, XDoubleStream> implements DoubleStream {
    private final DoubleStream stream;

    public static XDoubleStream wrap(DoubleStream stream) {
        return new XDoubleStream(stream);
    }

    private XDoubleStream(DoubleStream stream) {
        this.stream = stream;
    }

    @Override
    public DoubleStream filter(DoublePredicate predicate) {
        return null;
    }

    @Override
    public DoubleStream map(DoubleUnaryOperator mapper) {
        return null;
    }

    @Override
    public <U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper) {
        return null;
    }

    @Override
    public IntStream mapToInt(DoubleToIntFunction mapper) {
        return null;
    }

    @Override
    public LongStream mapToLong(DoubleToLongFunction mapper) {
        return null;
    }

    @Override
    public DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper) {
        return null;
    }

    @Override
    public DoubleStream peek(DoubleConsumer action) {
        return null;
    }

    @Override
    public void forEach(DoubleConsumer action) {

    }

    @Override
    public void forEachOrdered(DoubleConsumer action) {

    }

    @Override
    public double[] toArray() {
        return new double[0];
    }

    @Override
    public double reduce(double identity, DoubleBinaryOperator op) {
        return 0;
    }

    @Override
    public OptionalDouble reduce(DoubleBinaryOperator op) {
        return null;
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return null;
    }

    @Override
    public double sum() {
        return 0;
    }

    @Override
    public OptionalDouble min() {
        return null;
    }

    @Override
    public OptionalDouble max() {
        return null;
    }

    @Override
    public OptionalDouble average() {
        return null;
    }

    @Override
    public DoubleSummaryStatistics summaryStatistics() {
        return null;
    }

    @Override
    public boolean anyMatch(DoublePredicate predicate) {
        return false;
    }

    @Override
    public boolean allMatch(DoublePredicate predicate) {
        return false;
    }

    @Override
    public boolean noneMatch(DoublePredicate predicate) {
        return false;
    }

    @Override
    public OptionalDouble findFirst() {
        return null;
    }

    @Override
    public OptionalDouble findAny() {
        return null;
    }

    @Override
    protected XDoubleStream unboxed(Stream<Double> stream) {
        return wrap(stream.mapToDouble(x -> x));
    }

    @Override
    public XStream<Double> boxed() {
        return null;
    }

    @Override
    public PrimitiveIterator.OfDouble iterator() {
        return null;
    }

    @Override
    public Spliterator.OfDouble spliterator() {
        return null;
    }

    @Override
    public XDoubleStream filter(Predicate<? super Double> predicate) {
        return null;
    }

    @Override
    public <R> XStream<R> map(Function<? super Double, ? extends R> mapper) {
        return null;
    }

    @Override
    public XIntStream mapToInt(ToIntFunction<? super Double> mapper) {
        return null;
    }

    @Override
    public XLongStream mapToLong(ToLongFunction<? super Double> mapper) {
        return null;
    }

    @Override
    public XDoubleStream mapToDouble(ToDoubleFunction<? super Double> mapper) {
        return null;
    }

    @Override
    public <R> XStream<R> flatMap(Function<? super Double, ? extends Stream<? extends R>> mapper) {
        return null;
    }

    @Override
    public XIntStream flatMapToInt(Function<? super Double, ? extends IntStream> mapper) {
        return null;
    }

    @Override
    public XLongStream flatMapToLong(Function<? super Double, ? extends LongStream> mapper) {
        return null;
    }

    @Override
    public XDoubleStream flatMapToDouble(Function<? super Double, ? extends DoubleStream> mapper) {
        return null;
    }

    @Override
    public XDoubleStream distinct() {
        return null;
    }

    @Override
    public XDoubleStream sorted() {
        return null;
    }

    @Override
    public XDoubleStream sorted(Comparator<? super Double> comparator) {
        return null;
    }

    @Override
    public XDoubleStream peek(Consumer<? super Double> action) {
        return null;
    }

    @Override
    public XDoubleStream limit(long maxSize) {
        return null;
    }

    @Override
    public XDoubleStream skip(long n) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Double> action) {

    }

    @Override
    public void forEachOrdered(Consumer<? super Double> action) {

    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return null;
    }

    @Override
    public Double reduce(Double identity, BinaryOperator<Double> accumulator) {
        return null;
    }

    @Override
    public Optional<Double> reduce(BinaryOperator<Double> accumulator) {
        return null;
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super Double, U> accumulator, BinaryOperator<U> combiner) {
        return null;
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super Double> accumulator, BiConsumer<R, R> combiner) {
        return null;
    }

    @Override
    public <R, A> R collect(Collector<? super Double, A, R> collector) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean anyMatch(Predicate<? super Double> predicate) {
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super Double> predicate) {
        return false;
    }

    @Override
    public boolean noneMatch(Predicate<? super Double> predicate) {
        return false;
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @Override
    public XDoubleStream sequential() {
        return null;
    }

    @Override
    public XDoubleStream parallel() {
        return null;
    }

    @Override
    public XDoubleStream unordered() {
        return null;
    }

    @Override
    public XDoubleStream onClose(Runnable closeHandler) {
        return null;
    }

    @Override
    public void close() {

    }
}
