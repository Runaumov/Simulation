package org.simulation.field;

import org.simulation.Coordinates;
import org.simulation.entity.Entity;
import org.simulation.entity.Grass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {
    private final int width;
    private final int height;
    private final Map<Coordinates, Entity> entities;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Coordinates, Entity> getEntities() {
        return entities;
    }

    public void addEntityForRandomCoordinates (Random random, Entity entity) {
        Coordinates randomCoordinates;
        do {
            randomCoordinates = new Coordinates(random.nextInt(width) + 1, random.nextInt(height) + 1);
        } while (!isCellEmpty(randomCoordinates));
        entities.put(randomCoordinates, entity);
    }

    public boolean hasGrass () {
        return entities.values().stream().anyMatch(entity -> entity instanceof Grass);
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