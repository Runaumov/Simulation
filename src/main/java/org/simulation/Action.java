package org.simulation;

import org.simulation.entity.*;
import org.simulation.field.Field;
import org.simulation.field.FieldEntityRouter;
import org.simulation.field.FieldUtils;
import java.util.Map;
import java.util.stream.Collectors;

public class Action {
    public void testInitAction(Field field) {
        field.addEntity(new Coordinates(1, 0), new Rabbit());
        field.addEntity(new Coordinates(3, 3), new Grass());
        field.addEntity(new Coordinates(3, 2), new Stone());
        field.addEntity(new Coordinates(2, 3), new Tree());
    }
    public static void initAction(Field field) {
        FieldUtils.addRabbitForRandomCoordinate(field);
        FieldUtils.addFoxForRandomCoordinate(field);
        FieldUtils.addGrassForRandomCoordinate(field);
        FieldUtils.addStoneAndTreeForRandomCoordinate(field);
    }

    public static void turnAction(Field field) {
        FieldEntityRouter router = new FieldEntityRouter(field);
        //получаем мапу сущностей, которые могут двигаться
        Map<Coordinates, Creature> entitiesForTurn = field.getEntities().entrySet().stream()
                .filter(entry -> entry.getValue() instanceof Creature)
                .collect(Collectors.toMap(Map.Entry::getKey,  entry -> (Creature) entry.getValue()));
        //перебираем этих существ и к каждому применяем метод move
        for (Map.Entry<Coordinates, Creature> entry : entitiesForTurn.entrySet()) {
            Creature creature = entry.getValue();
            Coordinates currentCoordinates = entry.getKey();
            Coordinates targetCoordinates = router.getTargetCoordinates(creature, currentCoordinates);
            creature.makeMove(field, currentCoordinates, targetCoordinates);
        }

    }

}
