package net.avh4.util;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void testEquals() {
        final Point a = new Point(5, 7);
        final Point b = new Point(5, 7);

        assertThat(a.equals(b), is(true));
        assertThat(b.equals(a), is(true));
    }

    @Test
    public void testNotEquals() {
        final Point a = new Point(5, 7);
        final Point b = new Point(-5, 20);

        assertThat(a.equals(b), is(false));
        assertThat(b.equals(a), is(false));
    }

    @Test
    public void testNotEqualsWithNull() {
        final Point a = new Point(34, 20);
        final Point b = null;

        assertThat(a.equals(b), is(false));
    }

    @Test
    public void testDistanceTo() {
        final Point a = new Point(10, 10);
        assertThat(a.distanceTo(new Point(11, 10)), is((double) 1));
        assertThat(a.distanceTo(new Point(15, 15)), is(5 * Math.sqrt(2)));
    }

    @Test
    public void testArray() {
        final Point[] points = Point.array(new int[][]{
                {5, 7}, {-5, 20}, {11, 10}, {11, 10}
        });
        assertThat(points[0], is(new Point(5, 7)));
        assertThat(points[1], is(new Point(-5, 20)));
        assertThat(points[2], is(new Point(11, 10)));
        assertThat(points[3], is(new Point(11, 10)));
    }

    @Test
    public void testList() {
        final List<Point> points = Point.list(new int[][]{
                {5, 7}, {-5, 20}, {11, 10}, {11, 10}
        });
        assertThat(points.get(0), is(new Point(5, 7)));
        assertThat(points.get(1), is(new Point(-5, 20)));
        assertThat(points.get(2), is(new Point(11, 10)));
        assertThat(points.get(3), is(new Point(11, 10)));
    }
}
