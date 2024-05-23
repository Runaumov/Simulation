package org.simulation.entity;

import org.simulation.Coordinates;
import org.simulation.field.Field;

public abstract class Creature extends Entity {
    private static final int MAX_HP_DEFAULT = 10;
    protected int hp;

    public Creature() {
        this.hp = MAX_HP_DEFAULT;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp() {
        this.hp = MAX_HP_DEFAULT;
    }

    public void makeMove (Field field, Coordinates startCoordinates, Coordinates targetCoordinates) {
        Entity entity = field.getEntity(startCoordinates);
        if (!startCoordinates.equals(targetCoordinates)){
            field.removeEntity(startCoordinates);
            field.addEntity(targetCoordinates, entity);
        }
    }

}
