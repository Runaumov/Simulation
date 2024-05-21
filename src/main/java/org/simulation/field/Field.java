package org.simulation.field;

import org.simulation.Coordinates;
import org.simulation.entity.Entity;
import org.simulation.entity.Grass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {
    private final int x;
    private final int y;
    private HashMap<Coordinates, Entity> entities;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.entities = new HashMap<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public HashMap<Coordinates, Entity> getEntities() {
        return entities;
    }

    public void addEntityForRandomCoordinates (Random random, Entity entity) {
        Coordinates coordinates;
        do {
            coordinates = new Coordinates(random.nextInt(x) + 1, random.nextInt(y) + 1);
        } while (!isCellEmpty(coordinates));
        entities.put(coordinates, entity);
    }

    public boolean hasGrass () {
        for (Map.Entry<Coordinates, Entity> entry : entities.entrySet()) {
            if (entry.getValue() instanceof Grass) {
                return true;
            }
        }
        return false;
    }

    public void addEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeEntity (Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

}
