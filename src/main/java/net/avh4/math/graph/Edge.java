package net.avh4.math.graph;

public class Edge<N, E> {
    public final N start;
    public final E action;
    public final N end;

    public Edge(N start, E action, N end) {
        this.start = start;
        this.action = action;
        this.end = end;
    }
}
