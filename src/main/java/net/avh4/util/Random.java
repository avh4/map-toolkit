package net.avh4.util;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.List;

public class Random {

    private final java.util.Random r;

    public Random() {
        r = new java.util.Random();
    }

    public Random(long seed) {
        r = new java.util.Random(seed);
    }

    public Point nextPoint(int maxX, int maxY) {
        final int x = r.nextInt(maxX);
        final int y = r.nextInt(maxY);
        return new Point(x, y);
    }

    public int nextInt(int minInclusive, int maxInclusive) {
        return minInclusive + r.nextInt(maxInclusive + 1 - minInclusive);
    }

    public <T> T nextChoice(List<T> choices) {
        final int numberOfChoices = choices.size();
        final int i = r.nextInt(numberOfChoices);
        return choices.get(i);
    }

    public <T> T nextChoice(Collection<T> choices) {
        final ImmutableList<T> choicesList = ImmutableList.copyOf(choices);
        return nextChoice(choicesList);
    }

    public boolean nextBoolean() {
        return r.nextBoolean();
    }

    public long nextLong() {
        return r.nextLong();
    }

    public int nextInt(int i) {
        return r.nextInt(i);
    }

    public double nextDouble() {
        return r.nextDouble();
    }

    public float nextFloat() {
        return r.nextFloat();
    }
}
