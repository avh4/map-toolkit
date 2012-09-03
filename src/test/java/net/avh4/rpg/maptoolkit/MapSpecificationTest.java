package net.avh4.rpg.maptoolkit;

import net.avh4.util.Point;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

@SuppressWarnings({"NestedMethodCall", "ChainedMethodCall", "LawOfDemeter"})
public class MapSpecificationTest {

    private MapSpecification subject = new MapSpecification().exitTo("town");
    private final MapSpecification subjectWithTwoExits = new MapSpecification().exitsTo("castle", "morgue");
    @Mock
    private Map mapWithNoExits;
    @Mock
    private Map mapWithTown;
    @Mock
    private Map mapWithCastle;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.stub(mapWithTown.getLocationOfExit("town")).toReturn(new Point(0, 0));
        Mockito.stub(mapWithCastle.getLocationOfExit("castle")).toReturn(new Point(0, 1));
    }

    @Test
    public void testExitTo() {
        assertThat(subject.getRequiredExits(), hasItem("town"));
    }

    @Test
    public void testExitsTo() {
        assertThat(subjectWithTwoExits.getRequiredExits(), hasItems("castle", "morgue"));
    }

    @Test(expected = MapValidationFailed.class)
    public void validateMap_withNoExits_shouldThrow() throws Exception {
        subject.validateMap(mapWithNoExits);
    }

    @Test
    public void validateMap_withAllExits_shouldPass() throws Exception {
        subject.validateMap(mapWithTown);
    }

    @Test(expected = MapValidationFailed.class)
    public void validateMap_withMissingExit_shouldThrow() throws Exception {
        subjectWithTwoExits.validateMap(mapWithCastle);
    }
}
