package org.simulation.field;

import org.simulation.Coordinates;
import org.simulation.entity.*;
import java.util.*;

public class FieldEntityRouter {
    private final Field field;

    public FieldEntityRouter(Field field) {
        this.field = field;
    }

    public Coordinates getTargetCoordinates(Creature creature, Coordinates startCoordinates) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> previous = new HashMap<>();

        queue.add(startCoordinates);
        visited.add(startCoordinates);

        while (!queue.isEmpty()){
            Coordinates currentCoordinates = queue.poll();

            if (isTargetCoordinates(creature, currentCoordinates)) {
                return reconstructPath(previous, startCoordinates, currentCoordinates);
            }

            for (Coordinates neighbor : getNeighborCoordinates(currentCoordinates)) {
                if (isCoordinatesValid(neighbor) && !visited.contains(neighbor) &&
                    field.getEntity(neighbor) == null || isTargetCoordinates(creature, neighbor)
                ){
                    queue.add(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, currentCoordinates);
                }
            }
        }
        return startCoordinates;
    }

    private boolean isTargetCoordinates(Creature creature, Coordinates targetCoordinates) {
        Entity entity = field.getEntity(targetCoordinates);
        if (creature instanceof Herbivore && entity instanceof Grass) {
            return true;
        } else if (creature instanceof Predator && entity instanceof Herbivore && entity instanceof iFood) {
            return true;
        }
        return false;
    }

    private List<Coordinates> getNeighborCoordinates(Coordinates coordinates) {
        List<Coordinates> neighborCoordinates = new ArrayList<>();
        neighborCoordinates.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
        neighborCoordinates.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        neighborCoordinates.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        neighborCoordinates.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        return neighborCoordinates;
    }

    private Coordinates reconstructPath(Map<Coordinates, Coordinates> previous, Coordinates startCoordinates, Coordinates targetCoordinates) {
        LinkedList<Coordinates> path = new LinkedList<>();
        Coordinates stepCoordinates = targetCoordinates;
        while (stepCoordinates != null && !stepCoordinates.equals(startCoordinates)) {
            path.addFirst(stepCoordinates);
            stepCoordinates = previous.get(stepCoordinates);
        }
        if (path.isEmpty()) {
            return startCoordinates;
        } else {
            return path.getFirst();
        }
    }

    private boolean isCoordinatesValid(Coordinates coordinates) {
        return coordinates.getX() > 0 && coordinates.getX() <= field.getX() &&
                coordinates.getY() > 0 && coordinates.getY() <= field.getY();
    }

}