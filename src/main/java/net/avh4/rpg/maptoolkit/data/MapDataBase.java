package net.avh4.rpg.maptoolkit.data;

import net.avh4.util.Point;

public abstract class MapDataBase<T> implements MapData<T> {
    protected final int w;
    protected final int h;
    private final String name;

    public MapDataBase(String name, int w, int h) {
        this.name = name;
        this.w = w;
        this.h = h;
    }

    @Override
    public T getData(Point p) {
        return getData(p.x, p.y); // TODO: test this
    }

    @Override
    public T getData(int x, int y, T valueIfNull) {
        // TODO: test this
        T value = getData(x, y);
        if (value == null) return valueIfNull;
        return value;
    }

    @Override
    public void setData(Point p, T value) {
        // TODO: test this
        setData(p.x, p.y, value);
    }

    @Override
    public void setData(Point p, int dx, int dy, T value) {
        // TODO: test this
        setData(p.x + dx, p.y + dy, value);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

    @Override
    public String debugGetName() {
        return name;
    }

    @Override
    public String debugGetText(int x, int y) {
        // TODO: test this
        T data = getData(x, y);
        if (data == null) {
            return "";
        } else if (data instanceof Integer) {
            return data.toString();
        } else if (data instanceof Number) {
            return String.format("%.2f", ((Number) data).doubleValue());
        } else {
            return data.toString();
        }
    }

    @Override
    public double debugGetTint(int x, int y) {
        // TODO: test this
        T data = getData(x, y);
        if (data == null) {
            return 0;
        } else if (data instanceof Integer) {
            return (Integer) data / 100.0;
        } else if (data instanceof Number) {
            return ((Number) data).doubleValue();
        } else {
            return 0.5;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof MapDataBase)) return false;

        MapDataBase that = (MapDataBase) o;

        if (h != that.h) return false;
        if (w != that.w) return false;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (!getData(x, y).equals(that.getData(x, y))) return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = w;
        result = 31 * result + h;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                result = 31 * result + getData(x, y).hashCode();
            }
        }
        return result;
    }
}
