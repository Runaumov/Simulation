package org.simulation;

public enum Sprite {

    FOX("\uD83E\uDD8A"),
    RABBIT("\uD83D\uDC30"),
    GRASS("\uD83C\uDF3F"),
    STONE("\uD83D\uDDFF"),
    TREE("\uD83C\uDF32");

    private String unicode;

    Sprite(String unicode) {
        this.unicode = unicode;
    }

    @Override
    public String toString() {
        return unicode;
    }

}