package org.simulation;

import org.simulation.entity.Entity;
import org.simulation.field.Field;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coordinates {
    public final Integer X;
    public final Integer Y;

    public Coordinates(Integer x, Integer y) {
        X = x;
        Y = y;
    }

    public Integer getX() {
        return X;
    }

    public Integer getY() {
        return Y;
    }

    //method for test
    public static Coordinates getTargetCoordinates(Field field, Entity entity) {
        Coordinates targetCoordinates = new Coordinates(field.getEntityCoordinate(entity).getX(), field.getEntityCoordinate(entity).getY() + 1);
        return targetCoordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(X, that.X) && Objects.equals(Y, that.Y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
