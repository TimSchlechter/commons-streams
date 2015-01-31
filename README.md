# xstream
Extends the Java 8 Streams API

### Usage
```java
import static net.itimothy.xstream.XStream.stream;

public class SomeClass {
    public void SomeMethod() {
        Person anna = new Person("anna", 30);
        Person bob = new Person("bob", 20);
        Person carol = new Person("carol", 10);

        Person[] people = {anna, bob, carol};
        
        stream(people)
            .sortBy(p -> p.getName())
            .toList();
            
        stream(people).contains(anna);
    }
}
```
### Features

#### .any()
```java
stream(asList(1,2,3))
    .any();
// → true

stream(asList())
    .any()
// → false
```

#### .contains&lt;T&gt;(T item)
```java
stream(asList(1,2,3))
    .contains(1);
// → true

stream(asList(1,2,3))
    .contains(4);
// → false
```

#### .union&lt;T&gt;(Stream&lt;T&gt; other)
```java
stream(asList(1,2))
    .union(stream(asList(2,3))
    .toArray();
// → [1,2,3]
```
