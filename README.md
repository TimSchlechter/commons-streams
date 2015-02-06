# net.itimothy.commons.streams
A lightweight wrapper around the [Java Streams API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-
summary.html).

### Features
  - 100% compatible with the Java Streams API
  - Extends streams with common used operations
  - String as streams of characters
 
### Example usages
```java
import static net.itimothy.commons.streams.StreamUtils.stream;

Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] men = {bob};
Person[] women = {ann, carol};

List<Person> people = stream(men).union(women).toList();
// → [bob,ann,carol]

stream(people).sorted(p -> p.getAge()).toList();
// → [carol,bob,ann]

stream(people).without(bob).anyMatch(bob);
// → false

stream(bob.getName()).anyMatch('b');
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
stream(1).any();
// → true

stream(1).without(1).any()
// → false
```

##### .anyMatch()
```java
Person ann = new Person("Ann", 30);
Person carol = new Person("Carol", 10);
Person[] women = {ann, carol};

stream(women).anyMatch(ann);
// → true

stream(women).without(ann).anyMatch(ann)
// → false
```

##### .findFirst(Predicate&lt;T&gt;)
```java
Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] people = {ann, bob, carol};

stream(people).findFirst(p -> p.getName() == "Bob").get();
// → bob

stream(people).findFirst(p -> p.getName() == "John").isPresent();
// → false
```

##### .findFirstOrDefault(Predicate&lt;T&gt;, T defaultValue)
```java
Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] people = {ann, bob, carol};

stream(people).findFirstOrDefault(p -> p.getName() == "Bob", carol);
// → bob

stream(people).findFirstOrDefault(p -> p.getName() == "John", carol);
// → carol
```

##### .findFirstOrNull(Predicate&lt;T&gt;)
```java
Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] people = {ann, bob, carol};

stream(people).findFirstOrNull(p -> p.getName() == "Bob");
// → bob

stream(people).findFirstOrNull(p -> p.getName() == "John");
// → null
```

##### .sorted()
```java
Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] people = {ann, bob, carol};

stream(people).sorted(p -> p.getAge())
// → [carol,bob,ann]
```

##### .without()
```java
stream(1,2).without(2)
// → 1
```

### Set operations

##### .difference()
```java
stream(1,2).difference(asList(2,3))
// → [1]
```

##### .intersect()
```java
stream(1,2).intersect(asList(2,3))
// → [2]
```

##### .union()
```java
stream(1,2).union(stream(2,3))
// → [1,2,3]
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
