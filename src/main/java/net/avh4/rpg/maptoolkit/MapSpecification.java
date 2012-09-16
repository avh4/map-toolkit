package net.avh4.rpg.maptoolkit;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;

public class MapSpecification {

    private final HashSet<String> exits = new HashSet<String>();

    public MapSpecification exitTo(String exit) {
        exits.add(exit);
        return this;
    }

    public ImmutableSet<String> getRequiredExits() {
        return ImmutableSet.copyOf(exits);
    }

    public MapSpecification exitsTo(String... exits) {
        for (final String exit : exits) {
            exitTo(exit);
        }
        return this;
    }

    public void validateMap(Map map) {
        for (String exit : exits) {
            if (map.getLocationOfExit(exit) == null) {
                throw new MapValidationFailed("Map " + map + "is missing exits: " + exit);
            }
        }
    }
}
