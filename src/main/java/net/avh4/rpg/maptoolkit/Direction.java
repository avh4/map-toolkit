package net.avh4.rpg.maptoolkit;

import net.avh4.util.Point;

public enum Direction {
    N, S, E, W;

    public Point apply(Point p) {
        switch (this) {
            case N:
                return p.translate(0, -1);
            case S:
                return p.translate(0, +1);
            case E:
                return p.translate(+1, 0);
            case W:
                return p.translate(-1, 0);
            default:
                return p;
        }
    }
}