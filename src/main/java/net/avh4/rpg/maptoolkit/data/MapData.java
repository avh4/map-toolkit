package net.avh4.rpg.maptoolkit.data;

import net.avh4.util.Point;

public interface MapData<T> extends ConstMapData<T> {

    void setData(Point p, T value);

    void setData(int x, int y, T value);

    void setData(Point p, int dx, int dy, T value);
}
