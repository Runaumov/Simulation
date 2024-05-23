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
                    line += " " + "\u2022" + " ";
                } else {
                    line += getEntitySprite(field.getEntity(coordinates));
                }
            }
            System.out.println(line);
        }
    }

    public void renderDelimiter(char c, int length) {
        StringBuilder delimiter = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            delimiter.append(c);
        }
        System.out.println(delimiter.toString());
    }

    private String getEntitySprite(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Rabbit":
                return "\uD83D\uDC30" + " ";
            case "Fox":
                return "\uD83E\uDD8A" + " ";
            case "Grass":
                return "\uD83C\uDF3F" + " ";
            case "Tree":
                return "\uD83C\uDF32" + " ";
            case "Stone":
                return "\uD83D\uDDFF" + " ";
            case "Skull":
                return "\uD83D\uDC80" + " ";
            case "Cow":
                return "\uD83D\uDC2E" + " ";
        }
        return "";
    }

}