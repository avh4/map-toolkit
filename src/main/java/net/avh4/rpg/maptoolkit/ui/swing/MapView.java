package net.avh4.rpg.maptoolkit.ui.swing;

import net.avh4.framework.uilayer.scene.ClippedElement;
import net.avh4.framework.uilayer.swing.SwingSceneRenderer;
import net.avh4.rpg.maptoolkit.Map;
import net.avh4.rpg.maptoolkit.Tileset;

import javax.swing.*;

public class MapView extends JPanel {
    public void setMap(Map map) {
        removeAll();
        ClippedElement mapElement = new ClippedElement(map,
                0, 0, map.getWidth() * Tileset.TILE_SIZE, map.getHeight() * Tileset.TILE_SIZE);
        SwingSceneRenderer renderer = new SwingSceneRenderer(mapElement);
        setSize(renderer.getPreferredSize());
        add(renderer);
        repaint();
    }
}
