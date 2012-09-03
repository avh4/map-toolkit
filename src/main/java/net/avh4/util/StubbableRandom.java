package net.avh4.util;

import java.util.Collection;
import java.util.List;

public class StubbableRandom extends Random {

    private Point stubValue;

    public StubbableRandom(long seed) {
        super(seed);
    }

    public void stub(Point point) {
        stubValue = point;
    }

    private Point nextStub() {
        Point p = stubValue;
        stubValue = null;
        return p;
    }

    @Override
    public Point nextPoint(int maxX, int maxY) {
        Point p = nextStub();
        Point point = super.nextPoint(maxX, maxY);
        if (p != null) return p;
        System.out.println("nextPoint(" + maxX + "," + maxY + "): " + point);
        return point;
    }

    @Override
    public int nextInt(int minInclusive, int maxInclusive) {
        return super.nextInt(minInclusive, maxInclusive);
    }

    @Override
    public <T> T nextChoice(List<T> choices) {
        return super.nextChoice(choices);
    }

    @Override
    public <T> T nextChoice(Collection<T> choices) {
        return super.nextChoice(choices);
    }

    @Override
    public boolean nextBoolean() {
        return super.nextBoolean();
    }

    @Override
    public long nextLong() {
        return super.nextLong();
    }

    @Override
    public int nextInt(int i) {
        return super.nextInt(i);
    }

    @Override
    public double nextDouble() {
        return super.nextDouble();
    }

    @Override
    public float nextFloat() {
        return super.nextFloat();
    }
}
