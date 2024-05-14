package org.simulation;

import org.simulation.entity.*;
import org.simulation.field.Field;
import org.simulation.field.FieldEntityRouter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Action {

    public static void testInitAction(Field field) {
        field.addEntity(new Coordinates(1, 1), new Rabbit());
        field.addEntity(new Coordinates(1, 4), new Grass());
        field.addEntity(new Coordinates(3, 2), new Stone());
        field.addEntity(new Coordinates(2, 3), new Tree());
    }
    public static void initAction(Field field) {
        Random random = new Random();
        int totalCells = field.getX() * field.getY();
        int rabbitCount = totalCells / 10;
        int foxCount = totalCells / 20;
        int grassCount = totalCells / 4;
        int treeAndStoneCount = totalCells / 10;
        for (int i = 0; i < rabbitCount; i++) {
            field.addEntityForRandomCoordinates(random, new Rabbit());
        }
        for (int i = 0; i < foxCount; i++) {
            field.addEntityForRandomCoordinates(random, new Fox());
        }
        for (int i = 0; i < grassCount; i++) {
            field.addEntityForRandomCoordinates(random, new Grass());
        }
        for (int i = 0; i < treeAndStoneCount; i++) {
            if (random.nextBoolean()) {
                field.addEntityForRandomCoordinates(random, new Tree());
            } else {
                field.addEntityForRandomCoordinates(random, new Stone());
            }
        }
    }

    public static void turnAction(Field field) {
        //получаем мапу сущностей, которые могут двигаться
        Map<Coordinates, Creature> entitiesForTurn = field.getEntities().entrySet().stream()
                .filter(entry -> entry.getValue() instanceof Creature)
                .collect(Collectors.toMap(Map.Entry::getKey,  entry -> (Creature) entry.getValue()));
        //перебираем этих существ и к каждому применяем метод move
        for (Map.Entry<Coordinates, Creature> entry : entitiesForTurn.entrySet()) {
            Creature creature = entry.getValue();
            creature.makeMove(field, entry.getKey(), Coordinates.getTargetCoordinates(field, creature));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //изменения производим в переданном в сигнатуру field
    }

}
