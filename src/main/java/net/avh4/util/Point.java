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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
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
        for (int[] coord : coords) {
            ret.add(new Point(coord[0], coord[1]));
        }
        return ret;
    }

    @SuppressWarnings("NestedMethodCall")
    public Point clip(int x1, int y1, int x2, int y2) {
        int x = Math.max(x1, Math.min(x2, this.x));
        int y = Math.max(y1, Math.min(y2, this.y));
        return new Point(x, y);
    }
}
