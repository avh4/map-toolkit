package net.avh4.rpg.maptoolkit.data;

import net.avh4.util.Point;

public interface ConstMapData<T> {
    T getData(Point p);

    T getData(int x, int y);

    T getData(int x, int y, T valueIfNull);

    int getWidth();

    int getHeight();

    String debugGetName();

    String debugGetText(int x, int y);

    double debugGetTint(int x, int y);
}
