package org.simulation.field;

import org.simulation.Coordinates;
import org.simulation.entity.Entity;

public class FieldConsoleRender {
    public void render(Field field) {
        for (int y = field.getX(); y >= 1; y--) {
            String line = "";
            for (int x = 1; x < field.getY(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (field.isCellEmpty(coordinates)) {
                    line += " \u2022 ";
                } else {
                    line += getEntitySprite(field.getEntity(coordinates));
                }
            }
            System.out.println(line);
        }
        System.out.println("");
    }

    private String getEntitySprite(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Rabbit":
                return "\u202F" + "\uD83D\uDC30" + "\u202F";
            case "Fox":
                return "\u202F" + "\uD83E\uDD8A" + "\u202F";
            case "Grass" :
                return "\u202F" + "\uD83C\uDF3F" + "\u202F";
            case "Tree" :
                return "\u202F" + "\uD83C\uDF32" + "\u202F";
            case "Stone" :
                return "\u202F" + "\uD83D\uDDFF" + "\u202F";
        }
        return "";
    }
}
