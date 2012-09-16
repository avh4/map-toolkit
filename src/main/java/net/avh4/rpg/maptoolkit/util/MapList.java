package net.avh4.rpg.maptoolkit.util;

import net.avh4.rpg.maptoolkit.Map;

import java.util.Collection;

public interface MapList {
    Collection<Class<? extends Map>> get();
}
