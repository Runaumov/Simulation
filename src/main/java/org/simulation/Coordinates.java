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

    @Override
    public String toString() {
        return "Coordinates{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
