package org.simulation;

import org.simulation.entity.*;
import org.simulation.field.Field;
import org.simulation.field.FieldEntityRouter;
import org.simulation.field.FieldUtils;
import java.util.*;
import java.util.stream.Collectors;

public class Action {
    private final Field field;
    private final Random random;
    private final MessageBox messageBox;
    private final FieldEntityRouter router;
    private static Queue<Coordinates> entitiesForTurn = new LinkedList<>();

    public Action(Field field) {
        this.field = field;
        this.random = new Random();
        this.messageBox = new MessageBox();
        this.router = new FieldEntityRouter(field);
    }

    public void initAction() {
        FieldUtils.addRabbitForRandomCoordinate(field, random);
        FieldUtils.addFoxForRandomCoordinate(field, random);
        FieldUtils.addGrassForRandomCoordinate(field, random);
        FieldUtils.addStoneAndTreeForRandomCoordinate(field, random);
        FieldUtils.addCowForRandomCoordinate(field, random);
    }

    public void turnAction() {
        if (!field.hasGrass()) {
            FieldUtils.addGrassForRandomCoordinate(field, random);
        }
        // допущение - метод не может вернуть null
        Coordinates currentCoordinates = getCreatureCoordinatesForTurn(field);

        Creature creature = (Creature) field.getEntity(currentCoordinates);
        creature.setHp(creature.getHp() - 1);

        if (creature.getHp() == 0) {
            field.addEntity(currentCoordinates, new Skull());
            messageBox.addMessage("Существо погибло: " + creature.toString());
        } else {
            Coordinates targetCoordinates = router.getTargetCoordinates(creature, currentCoordinates);
            if (!field.isCellEmpty(targetCoordinates)) {
                creature.setMaxHp();
            }
            creature.makeMove(field, currentCoordinates, targetCoordinates);
            messageBox.addMessage("Ходит: " + creature.toString());
        }
    }

    private static Coordinates getCreatureCoordinatesForTurn(Field field) {
        if (entitiesForTurn.isEmpty()) {
            entitiesForTurn = field.getEntities().entrySet().stream()
                    .filter(entry -> entry.getValue() instanceof Creature)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toCollection(LinkedList::new));
        }
        return entitiesForTurn.poll();
    }
}