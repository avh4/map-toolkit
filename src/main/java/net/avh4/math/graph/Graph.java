package net.avh4.math.graph;

import com.google.common.collect.ImmutableSet;

public interface Graph<N, E> {
    ImmutableSet<Edge<N, E>> getEdges(N p);
}
