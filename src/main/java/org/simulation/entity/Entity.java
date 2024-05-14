package org.simulation.entity;

import org.simulation.Coordinates;

import java.util.Objects;

public abstract class Entity {
    public Coordinates coordinates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(coordinates, entity.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
