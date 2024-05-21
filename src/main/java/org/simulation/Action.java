package org.simulation;

import org.simulation.entity.*;
import org.simulation.field.Field;
import org.simulation.field.FieldEntityRouter;
import org.simulation.field.FieldUtils;
import java.util.*;
import java.util.stream.Collectors;

public class Action {
    private final Field field;
    private static Queue<Coordinates> entitiesForTurn = new LinkedList<>();

    public Action(Field field) {
        this.field = field;
    }

    public void initAction() {
        FieldUtils.addRabbitForRandomCoordinate(field);
        FieldUtils.addFoxForRandomCoordinate(field);
        FieldUtils.addGrassForRandomCoordinate(field);
        FieldUtils.addStoneAndTreeForRandomCoordinate(field);
    }

    public void turnAction() {
        Coordinates currentCoordinates = getCreatureCoordinatesForTurn(field);
        Creature creature = (Creature) field.getEntity(currentCoordinates);
        creature.setHp(creature.getHp() - 1);
        if (creature.getHp() == 0) {
            field.addEntity(currentCoordinates, new Scull());
        } else {
            FieldEntityRouter router = new FieldEntityRouter(field);
            Coordinates targetCoordinates = router.getTargetCoordinates(creature, currentCoordinates);
            if (!field.isCellEmpty(targetCoordinates)) {
                creature.setHp(Creature.MAX_HP);
            }
            creature.makeMove(field, currentCoordinates, targetCoordinates);
            System.out.println("Ходит " + creature.toString());
        }

    }

    public static Coordinates getCreatureCoordinatesForTurn(Field field) {
        if (entitiesForTurn.isEmpty()) {
            entitiesForTurn = field.getEntities().entrySet().stream()
                    .filter(entry -> entry.getValue() instanceof Creature)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toCollection(LinkedList::new));
        }
        return entitiesForTurn.poll();
    }

}