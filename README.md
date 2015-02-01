# xstream
A lightweight wrapper around the [Java Streams
API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-
summary.html).

### Goals:
  - Make common operations on collections less verbose
  - Strings as streams of characters
  - 100% compatible with the Streams API.

### Example usages
```java
import static net.itimothy.xstream.StreamUtils.xstream;

Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] men = {bob};
Person[] women = {ann, carol};

List<Person> people = xstream(men).union(women).toList();
// → [bob, ann, carol]

xstream(people).sorted(p -> p.getName()).toList();
// → [ann,bob,carol]

xstream(people).without(bob).contains(bob);
// → false

xstream(bob.getName()).contains('b');
// → true

xstream(bob.getName()).union(carol.getName()).toList();
// → ['B','o','b',c','a','r','l']

```
### Operations
Streams created by xstream are 100% compatible with the [Java Streams
API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-
summary.html). It currently extends the API with the following operations.

#### .any()
```java
Person bob = new Person("Bob", 20);
Person[] men = {bob};

xstream(men).any();
// → true

xstream(men).without(bob).any()
// → false
```

#### .contains()
```java
Person ann = new Person("Ann", 30);
Person carol = new Person("Carol", 10);
Person[] women = {ann, carol};

xstream(women).contains(ann);
// → true

xstream(women).without(ann).contains(ann)
// → false
```

#### .union()
```java
Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] men = {bob};
Person[] women = {ann, carol};

List<Person> people = xstream(men).union(women).toList();
// → [bob, ann, carol]
```

#### .without()
```java
Person bob = new Person("Bob", 20);
Person[] men = {bob};

xstream(men).without(bob).any()
// → false
```