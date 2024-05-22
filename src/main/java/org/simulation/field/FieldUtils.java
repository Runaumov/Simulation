package org.simulation.field;

import org.simulation.entity.*;

import java.util.Random;

public class FieldUtils {

    private static final Random random = new Random();

    public static void addRabbitForRandomCoordinate (Field field) {
        int rabbitCount = field.getWidth() * field.getHeight() / 10;
        for (int i = 0; i < rabbitCount; i++) {
            field.addEntityForRandomCoordinates(random, new Rabbit());
        }
    }

    public static void addGrassForRandomCoordinate (Field field) {
        int grassCount = field.getWidth() * field.getHeight() / 4;
        for (int i = 0; i < grassCount; i++) {
            field.addEntityForRandomCoordinates(random, new Grass());
        }
    }

    public static void addFoxForRandomCoordinate (Field field) {
        int foxCount = field.getWidth() * field.getHeight() / 50;
        for (int i = 0; i < foxCount; i++) {
            field.addEntityForRandomCoordinates(random, new Fox());
        }
    }

    public static void addStoneAndTreeForRandomCoordinate (Field field) {
        int treeAndStoneCount = field.getWidth() * field.getHeight() / 10;
        for (int i = 0; i < treeAndStoneCount; i++) {
            if (random.nextBoolean()) {
                field.addEntityForRandomCoordinates(random, new Stone());
            } else {
                field.addEntityForRandomCoordinates(random, new Tree());
            }
        }
    }

    public static void addCowForRandomCoordinate (Field field) {
        int cowCount = field.getWidth() * field.getHeight() / 100;
        for (int i = 0; i < cowCount; i++) {
            field.addEntityForRandomCoordinates(random, new Cow());
        }
    }

}