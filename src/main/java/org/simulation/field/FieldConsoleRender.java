package org.simulation.field;

import org.simulation.Coordinates;
import org.simulation.entity.Entity;

public class FieldConsoleRender {
    public void render(Field field) {
        for (int y = field.getY(); y >= 1; y--) {
            String line = "";
            for (int x = 1; x <= field.getX(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (field.isCellEmpty(coordinates)) {
                    line += "\u2002" + "\u2022" + "\u2002";
                } else {
                    line += getEntitySprite(field.getEntity(coordinates));
                }
            }
            System.out.println(line);
        }
        System.out.println("----------");
    }

    private String getEntitySprite(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Rabbit":
                return "\u2004" + "\uD83D\uDC30";
            case "Fox":
                return "\u2004" + "\uD83E\uDD8A";
            case "Grass":
                return "\u2004" + "\uD83C\uDF3F";
            case "Tree":
                return "\u2004" + "\uD83C\uDF32" + "\u2006";
            case "Stone":
                return "\u2004" + "\uD83D\uDDFF" + "\u2005" + "\u200A";
            case "Skull":
                return "\u2004" + "\uD83D\uDC80";
            case "Cow":
                return "\u2004" + "\uD83D\uDC2E";
        }
        return "";
    }

}