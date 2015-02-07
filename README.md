# commons-streams
A lightweight wrapper around the [Java Streams API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-
summary.html).

### Features
  - 100% compatible with the Java Streams API
  - Extends streams with common used operations
  - String as streams of characters
 
### Example usages
```java
import static net.itimothy.commons.streams.StreamUtils.*;

Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] men = {bob};
Person[] women = {ann, carol};

List<Person> people = stream(men).union(women).toList();
// → [bob,ann,carol]

stream(people).sorted(p -> p.getAge()).toList();
// → [carol,bob,ann]

stream(people).without(bob).contains(bob);
// → false

stream(bob.getName()).contains('b');
// → true

stream(bob.getName()).union(carol.getName()).toList();
// → ['B','o','b',c','a','r','l']

parallelStream(people)
// → a parallel XStream

unorderedStream(people)
// → an unordered XStream
```

### Operations
Streams created by StreamUtils.stream() are 100% compatible with the [Java Streams
API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html). It currently extends the API with the following operations:

### Misc operations

##### .any()
```java
stream(men).any();
// → true

stream(men).without(bob).any()
// → false
```

##### .contains()
```java
stream(women).contains(ann);
// → true

stream(women).without(ann).contains(ann)
// → false
```

##### .findFirst(Predicate&lt;T&gt;)
```java
stream(people).findFirst(p -> p.getName() == "Bob").get();
// → bob

stream(people).findFirst(p -> p.getName() == "John").isPresent();
// → false
```

##### .flatten()
```java
Node root = new Node("root", asList(
    new Node("1"),
    new Node("2", asList(
        new Node("2.1"),
        new Node("2.2", asList(
            new Node("2.2.1")
        ))
    ))
));

stream(root)
    .flatten(n -> stream(n.getChildren()))
    .map(n -> n.getName())
// → ["1", "2", "2.1", "2.2", "2.2.1"]
```

##### .sorted()
```java
stream(people).sorted(p -> p.getAge())
// → [carol,bob,ann]
```

##### .without()
```java
stream(people).without(bob)
// → [ann, carol]

stream(people).without(p -> p.getAge() < 25)
// → [ann]
```

### Set operations

##### .difference()
```java
stream(ann, bob).difference(asList(bob, carol))
// → [ann]
```

##### .intersect()
```java
stream(ann, bob).intersect(asList(bob, carol))
// → [bob]
```

##### .union()
```java
stream(ann, bob).union(stream(bob, carol))
// → [ann,bob,carol]
```

### Collector operations

##### .toList()
```java
// TODO: add example
```

##### .toMap()
```java
// TODO: add example
```

##### .toSet()
```java
// TODO: add example
```
