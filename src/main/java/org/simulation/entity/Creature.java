package org.simulation.entity;

import org.simulation.Coordinates;
import org.simulation.field.Field;
import org.simulation.Move;

public abstract class Creature extends Entity {

    public void makeMove (Field field, Coordinates startCoordinates, Coordinates targetCoordinates) {
        Entity entity = field.getEntity(startCoordinates);
        if (!startCoordinates.equals(targetCoordinates)){
            field.removeEntity(startCoordinates);
            field.addEntity(targetCoordinates, entity);
        }
    }

}
