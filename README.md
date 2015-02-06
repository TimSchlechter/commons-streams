# xstream
A lightweight wrapper around the [Java Streams
API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-
summary.html).

### Features
  - 100% compatible with the Java Streams API
  - Extends streams with common used operations
  - String as streams of characters
 
### Example usages
```java
import static net.itimothy.xstream.StreamUtils.xstream;

Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] men = {bob};
Person[] women = {ann, carol};

List<Person> people = xstream(men).union(women).toList();
// → [bob,ann,carol]

xstream(people).sorted(p -> p.getAge()).toList();
// → [carol,bob,ann]

xstream(people).without(bob).anyMatch(bob);
// → false

xstream(bob.getName()).anyMatch('b');
// → true

xstream(bob.getName()).union(carol.getName()).toList();
// → ['B','o','b',c','a','r','l']

```
Streams created by xstream are 100% compatible with the [Java Streams
API](http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html). It currently extends the API with the following operations.

### Misc operations

##### .any()
```java
xstream(1).any();
// → true

xstream(1).without(1).any()
// → false
```

##### .anyMatch()
```java
Person ann = new Person("Ann", 30);
Person carol = new Person("Carol", 10);
Person[] women = {ann, carol};

xstream(women).anyMatch(ann);
// → true

xstream(women).without(ann).anyMatch(ann)
// → false
```

##### .sorted()
```java
Person ann = new Person("Ann", 30);
Person bob = new Person("Bob", 20);
Person carol = new Person("Carol", 10);

Person[] people = {ann, bob, carol};

xstream(people).sorted(p -> p.getAge())
// → [carol,bob,ann]
```

##### .without()
```java
xstream(1,2).without(2)
// → 1
```

### Set operations

##### .difference()
```java
xstream(1,2).difference(2,3)
// → [1]
```

##### .intersect()
```java
xstream(1,2).intersect(2,3)
// → [2]
```

##### .union()
```java
xstream(1,2).union(2,3)
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
