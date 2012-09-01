package net.avh4.rpg.maptoolkit.data;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

@SuppressWarnings({"ChainedMethodCall", "LawOfDemeter", "NestedMethodCall"})
public class MapDataBaseTest {

    private MapDataBase<String> subject;

    @Before
    public void setUp() throws Exception {
        subject = new MapDataBase<String>("Rainfall", 10, 20) {
            @Override
            public void setData(int x, int y, String value) {
            }

            @Override
            public String getData(int x, int y) {
                return null;
            }
        };
    }

    @Test
    public void shouldHaveAName() throws Exception {
        assertThat(subject.debugGetName()).isEqualTo("Rainfall");
    }

    @Test
    public void shouldHaveWidth() throws Exception {
        assertThat(subject.getWidth()).isEqualTo(10);
    }

    @Test
    public void shouldHaveHeight() throws Exception {
        assertThat(subject.getHeight()).isEqualTo(20);
    }
}
