package net.avh4.rpg.maptoolkit.data;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

@SuppressWarnings({"NestedMethodCall", "ChainedMethodCall"})
public class DenseMapDataTest {

    private DenseMapData<Object> subject;
    private final Object A = "A";

    @Before
    public void setUp() {
        subject = new DenseMapData<Object>("My Data", 100, 200);
    }

    @Test
    public void shouldHaveAName() throws Exception {
        assertThat(subject.debugGetName()).isEqualTo("My Data");
    }

    @Test
    public void shouldStoreValue() {
        subject.setData(0, 0, A);
        assertThat(subject.getData(0, 0)).isSameAs(A);
    }

    @Test
    public void shouldStoreValueAtMaxX() {
        subject.setData(99, 0, A);
        assertThat(subject.getData(99, 0)).isSameAs(A);
    }

    @Test
    public void shouldStoreValueAtMaxY() {
        subject.setData(0, 199, A);
        assertThat(subject.getData(0, 199)).isSameAs(A);
    }

    @Test
    public void shouldHaveWidth() {
        assertThat(subject.getWidth()).isEqualTo(100);
    }

    @Test
    public void shouldHaveHeight() {
        assertThat(subject.getHeight()).isEqualTo(200);
    }

    @Test
    public void shouldReturnValueIfNull() {
        assertThat(subject.getData(0, 0, "B")).isEqualTo("B");
    }
}
