package net.avh4.rpg.maptoolkit;

import com.google.common.collect.ImmutableList;
import net.avh4.framework.uilayer.scene.ClippedElementDelegate;
import net.avh4.math.graph.Graph;
import net.avh4.rpg.maptoolkit.data.ConstMapData;
import net.avh4.util.Point;

public interface Map extends Graph<Point, Direction>, ClippedElementDelegate {

    String getName();

    String getExitAt(Point p);

    String getStairsAt(Point p);

    int getWidth();

    int getHeight();

    boolean isBlockedAt(Point p);

    Point getLocationOfExit(String exit);

    boolean isOffMap(Point p);

    ImmutableList<ConstMapData<?>> debugGetDataLayers();

    void debugToggleDataLayer(ConstMapData<?> layer);
}