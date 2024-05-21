package org.simulation.entity;

import org.simulation.Coordinates;
import org.simulation.field.Field;
import org.simulation.Move;

public abstract class Creature extends Entity {
    public static final int MAX_HP = 10;
    protected int hp;

    public Creature() {
        this.hp = 10;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void makeMove (Field field, Coordinates startCoordinates, Coordinates targetCoordinates) {
        Entity entity = field.getEntity(startCoordinates);
        if (!startCoordinates.equals(targetCoordinates)){
            field.removeEntity(startCoordinates);
            field.addEntity(targetCoordinates, entity);
        }
    }

}
