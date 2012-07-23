package net.avh4.rpg.maptoolkit.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import net.avh4.util.Point;

public class UniqueValueMapData<T> extends MapDataBase<T> {
    BiMap<Point, T> values = HashBiMap.create();
    private final int w;
    private final int h;

    public UniqueValueMapData(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public T getData(int x, int y) {
        return getData(new Point(x, y));
    }

    @Override
    public T getData(Point p) {
        return values.get(p);
    }

    @Override
    public void setData(int x, int y, T value) {
        setData(new Point(x, y), value);
    }

    @Override
    public void setData(Point p, T value) {
        values.put(p, value);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

    @SuppressWarnings("ChainedMethodCall")
    public Point find(T value) {
        return values.inverse().get(value);
    }

    @SuppressWarnings("NestedMethodCall")
    public ImmutableSet<T> values() {
        return ImmutableSet.copyOf(values.values());
    }

    public void remove(T value) {
        values.inverse().remove(value);
    }
}
