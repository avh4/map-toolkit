package net.avh4.rpg.primitives.tilesets;

import net.avh4.framework.uilayer.scene.GraphicsOperations;

public interface Tileset {
    int TILE_SIZE = 32;

    void drawTile(GraphicsOperations g, String tile);
}