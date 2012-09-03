package net.avh4.rpg.util;

import net.avh4.rpg.primitives.Map;

import java.util.Collection;

public interface MapList {
    Collection<Class<? extends Map>> get();
}
