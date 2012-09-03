package net.avh4.rpg.maptoolkit;

public class MapValidationFailed extends AssertionError {
    public MapValidationFailed() {
        super();
    }

    public MapValidationFailed(String s) {
        super(s);
    }

    public MapValidationFailed(Throwable throwable) {
        super(throwable);
    }
}
