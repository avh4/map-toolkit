package net.avh4.util;

import java.util.ArrayList;

/**
 * An immutable Point object
 *
 * @author avh4
 */
public final class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        final Point p = (Point) obj;
        if (p == null) {
            return false;
        }
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        return x ^ y;
    }

    @Override
    public String toString() {
        return "Point {" + x + ", " + y + "}";
    }

    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }

    public boolean equals(int px, int py) {
        return px == x && py == y;
    }

    public double distanceTo(Point p) {
        return Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y));
    }

    public static Point[] array(int[]... coords) {
        final Point[] ret = new Point[coords.length];
        for (int i = 0; i < coords.length; i++) {
            ret[i] = new Point(coords[i][0], coords[i][1]);
        }
        return ret;
    }

    public static ArrayList<Point> list(int[]... coords) {
        final ArrayList<Point> ret = new ArrayList<Point>(coords.length);
        for (int i = 0; i < coords.length; i++) {
            ret.add(new Point(coords[i][0], coords[i][1]));
        }
        return ret;
    }
}
