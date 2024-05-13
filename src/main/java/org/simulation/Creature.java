package org.simulation;

public abstract class Creature extends Entity {

    public void move (Field field, Move move) {
        Creature creature = (Creature) field.getEntity(move.from);
        field.removeEntity(move.from);
        field.addEntity(move.from, creature);
    }
}
