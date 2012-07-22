package net.avh4.rpg.maptoolkit.data;

import net.avh4.util.Point;

public abstract class MapDataBase<T> implements MapData<T> {
    @Override
    public T getData(Point p) {
        return getData(p.x, p.y);
    }

    @Override
    public T getData(int x, int y, T valueIfNull) {
        T value = getData(x, y);
        if (value == null) return valueIfNull;
        return value;
    }

    @Override
    public void setData(Point p, T value) {
        setData(p.x, p.y, value);
    }

    @Override
    public void setData(Point p, int dx, int dy, T value) {
        setData(p.x + dx, p.y + dy, value);
    }
}
