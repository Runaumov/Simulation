package org.simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Action {
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

    /*public static void turnAction(Field field) {
        HashMap<Coordinates, Entity> entitiesForTurn = field.getEntities();
        for (Map.Entry<Coordinates, Entity> entry : entitiesForTurn.entrySet()) {
            Coordinates fromCoordinates = entry.getKey();
            Coordinates toCoordinate = getToCoordinate();
            Entity entity = entry.getValue();

            if (entity instanceof Creature) {
                ((Creature) entity).move(field, toCoordinate);
            }


        }
    }*/

}
