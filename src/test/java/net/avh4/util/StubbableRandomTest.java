package net.avh4.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

public class StubbableRandomTest {

    private StubbableRandom r;

    @Before
    public void setUp() throws Exception {
        r = new StubbableRandom(1);
    }

    @Test
    public void shouldReturnNextStubbedValue() throws Exception {
        r.stub(new Point(7, 42));
        assertThat(r.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE), is(new Point(7, 42)));
    }

    @Test
    public void shouldConsumeStubbedValues() throws Exception {
        r.stub(new Point(7, 42));
        r.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertThat(r.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE), not(new Point(7, 42)));
    }

    @Test
    public void shouldAdvanceRandomWhenReturningAStubbedValue() throws Exception {
        StubbableRandom refRandom = new StubbableRandom(1);
        Point ref1 = refRandom.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point ref2 = refRandom.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);
        StubbableRandom subject = new StubbableRandom(1);
        subject.stub(new Point(0, 0));
        Point p1 = subject.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point p2 = subject.nextPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);

        assertThat(p2, is(ref2));
    }
}
