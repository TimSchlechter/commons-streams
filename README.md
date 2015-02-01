# xstream
Lightweight wrapper around the Java 8 Streams API to make code less verbose.
xstream is 100% compatible with the Streams API.

### Usage
```java
import static net.itimothy.xstream.StreamFactory.xstream;

Person anna = new Person("anna", 30);
Person bob = new Person("bob", 20);
Person carol = new Person("carol", 10);

Person[] men = {bob};
Person[] women = {anna, carol};

List<Person> people = xstream(men).union(women).toList();
// → [bob, anna, carol]

xstream(people)
    .sorted(p -> p.getName())
    .toList();
// → [anna,bob,carol]

xstream(people).without(bob).contains(bob);
// → false
```
### Features

#### .any()
```java
Person bob = new Person("bob", 20);
Person[] men = {bob};

xstream(men).any();
// → true

stream(men).without(bob).any()
// → false
```

#### .contains&lt;T&gt;(T item)
```java
Person anna = new Person("anna", 30);
Person carol = new Person("carol", 10);
Person[] women = {anna, carol};

stream(women).contains(anna);
// → true

stream(women).without(anna).contains(anna)
// → false
```

#### .union
```java
union<T>(Stream<T> other)
union<T>(Collection<T> other)
union<T>(T... other)
```

```java
Person anna = new Person("anna", 30);
Person bob = new Person("bob", 20);
Person carol = new Person("carol", 10);

Person[] men = {bob};
Person[] women = {anna, carol};

List<Person> people = xstream(men).union(women).toList();
// → [bob, anna, carol]
```

#### .without()
```java
Person bob = new Person("bob", 20);
Person[] men = {bob};

stream(men).without(bob).any()
// → false
```