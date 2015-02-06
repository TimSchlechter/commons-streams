package net.itimothy.commons.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

public class Node {
    public final static Node SimpleTree =
        new Node("root", asList(
            new Node("1"),
            new Node("2", asList(
                new Node("2.1"),
                new Node("2.2", asList(
                    new Node("2.2.1")
                )),
                new Node("2.3", asList(
                    new Node("2.3.1"),
                    new Node("2.3.2")
                ))
            ))
        ));

    private final String name;
    private final List<Node> children;

    public Node(String name) {
        this(name, null);
    }

    public Node(String name, Collection<Node> children) {
        this.name = name;
        this.children = children == null ? new ArrayList<>() : new ArrayList<>(children);
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }
}
