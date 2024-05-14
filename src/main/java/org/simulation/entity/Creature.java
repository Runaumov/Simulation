package org.simulation.entity;

import org.simulation.Coordinates;
import org.simulation.field.Field;
import org.simulation.Move;

public abstract class Creature extends Entity {

    public void makeMove (Field field, Coordinates startCoordinates, Coordinates targetCoordinates) {
        field.addEntity(targetCoordinates, this);
        field.removeEntity(startCoordinates);
    }
}
