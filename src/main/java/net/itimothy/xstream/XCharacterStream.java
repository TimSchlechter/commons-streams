package net.itimothy.xstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class XCharacterStream extends XPrimitiveBaseStream<Character, XCharacterStream> {
    private final XIntStream stream;

    public static XCharacterStream wrap(Stream<Character> stream) {
        return new XCharacterStream(stream);
    }

    public static XCharacterStream wrap(String string) {
        return new XCharacterStream(string);
    }

    private XCharacterStream(String string) {
        this(toIntStream(string));
    }

    private XCharacterStream(Stream<Character> stream) {
        this(stream.mapToInt(c -> c.charValue()));
    }
    
    private XCharacterStream(IntStream stream) {
        this.stream = XIntStream.wrap(stream);
    }
    
    private static IntStream toIntStream(String string) {
        if (string == null || string == "") {
            return Arrays.stream(new int[0]);
        }
        
        char[] chars = string.toCharArray();
        int[] ints = new int[chars.length];

        for (int i=0; i<chars.length; i++) {
            ints[i] = chars[i];
        }

        return Arrays.stream(ints);        
    }
    
    public XCharacterStream union(String other) {
        return union(wrap(other));
    }

    @Override
    protected XCharacterStream createInstance(Stream<Character> stream) {
        return wrap(stream);
    }

    @Override
    public XStream<Character> boxed() {
        return stream.boxed().map(i -> new Character((char)i.intValue()));
    }

    @Override
    public XCharacterStream filter(Predicate<? super Character> predicate) {
        return wrap(boxed().filter(predicate));
    }

    @Override
    public XIntStream mapToInt(ToIntFunction<? super Character> mapper) {
        return XIntStream.wrap(boxed().mapToInt(mapper));
    }

    @Override
    public XCharacterStream distinct() {
        return wrap(boxed().distinct());
    }

    @Override
    public XCharacterStream sorted() {
        return wrap(boxed().sorted());
    }

    @Override
    public XCharacterStream sorted(Comparator<? super Character> comparator) {
        return wrap(boxed().sorted(comparator));
    }

    @Override
    public XCharacterStream peek(Consumer<? super Character> action) {
        return wrap(boxed().peek(action));
    }

    @Override
    public XCharacterStream limit(long maxSize) {
        return wrap(boxed().limit(maxSize));
    }

    @Override
    public XCharacterStream skip(long n) {
        return wrap(boxed().skip(n));
    }

    @Override
    public void forEach(Consumer<? super Character> action) {
        boxed().forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super Character> action) {
        boxed().forEachOrdered(action);
    }

    @Override
    public long count() {
        return stream.count();
    }

    @Override
    protected Iterator<Character> iterator() {
        return boxed().iterator();
    }

    @Override
    protected Spliterator<Character> spliterator() {
        return boxed().spliterator();
    }

    @Override
    public boolean isParallel() {
        return stream.isParallel();
    }

    @Override
    public XCharacterStream sequential() {
        return wrap(boxed().sequential());
    }

    @Override
    public XCharacterStream parallel() {
        return wrap(boxed().parallel());
    }

    @Override
    public XCharacterStream unordered() {
        return wrap(boxed().unordered());
    }

    @Override
    public XCharacterStream onClose(Runnable closeHandler) {
        return wrap(boxed().onClose(closeHandler));
    }

    @Override
    public void close() {
        stream.close();
    }
}
