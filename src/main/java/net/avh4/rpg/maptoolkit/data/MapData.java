package net.avh4.rpg.maptoolkit.data;

import net.avh4.util.Point;

public interface MapData<T> {
    T getData(Point p);

    T getData(int x, int y);

    T getData(int x, int y, T valueIfNull);

    void setData(Point p, T value);

    void setData(int x, int y, T value);

    void setData(Point p, int dx, int dy, T value);

    int getWidth();

    int getHeight();
}
