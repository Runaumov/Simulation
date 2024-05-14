package org.simulation.field;

import org.simulation.Coordinates;
import org.simulation.entity.*;
import java.util.*;

public class FieldEntityRouter {
    private final Field field;
    private final Coordinates startCoordinates;
    private final Map<Coordinates, Coordinates> pathMap;


    public FieldEntityRouter(Field field, Coordinates startCoordinates) {
        this.field = field;
        this.startCoordinates = startCoordinates;
        this.pathMap = new HashMap<>();
        Map<Coordinates, Entity> entities = field.getEntities();
    }


    public void createPathMap() {
        Queue<Coordinates> cellsToCheck = new LinkedList<>(); //очередь координат для проверки
        //Map<Coordinates, Coordinates> pathMap = new HashMap<>(); //путь к еде
        Set<Coordinates> checkedCells = new HashSet<>(); //проверенные ячейки
        //Set<Coordinates> foundFoodCells = new HashSet<>(); //координаты, где еда найдена

        cellsToCheck.offer(startCoordinates);
        checkedCells.add(startCoordinates);

        while (!cellsToCheck.isEmpty()) {
            Coordinates currentCell = cellsToCheck.poll();
            /*if (entities.containsKey(currentCell) && entities.get(currentCell) instanceof iFood) {
                foundFoodCells.add(currentCell);
            }*/

            int[][] nearCells = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
            for (int[] cell : nearCells) {
                int newX = currentCell.getX() + cell[0];
                int newY = currentCell.getY() + cell[1];
                Coordinates directionCell = new Coordinates(newX, newY);

                if (isValidCoordinate(field, newX, newY) && !pathMap.containsKey(directionCell)) {
                    cellsToCheck.offer(directionCell);
                    pathMap.put(currentCell, directionCell);
                }
            }
        }
    }

    public Coordinates getCoordinateForTurn() {
        return pathMap.get(startCoordinates);
    }

    private static boolean isValidCoordinate(Field field, int newX, int newY) {
        return newX >= 0 && newX <= field.getX() && newY >= 0 && newY <= field.getY();
    }

    public static void main(String[] args) {
        Field field = new Field(3, 3);
        Coordinates startRabbitCoordinates = new Coordinates(1, 1);
        Coordinates startGrassCoordinates = new Coordinates(3, 3);
        Coordinates startGrassCoordinates2 = new Coordinates(1, 3);
        field.addEntity(startRabbitCoordinates, new Rabbit());
        field.addEntity(startGrassCoordinates, new Grass());
        field.addEntity(startGrassCoordinates2, new Grass());
        FieldEntityRouter fieldEntityRouterForRabbit = new FieldEntityRouter(field, startRabbitCoordinates);
        fieldEntityRouterForRabbit.createPathMap();
        Coordinates coordinateForTurn = fieldEntityRouterForRabbit.getCoordinateForTurn();
        int a = 1;
    }

}
