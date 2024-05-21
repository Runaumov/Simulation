package org.simulation;

import org.simulation.entity.Creature;
import org.simulation.entity.Entity;
import org.simulation.entity.Grass;
import org.simulation.entity.Herbivore;
import org.simulation.field.Field;
import org.simulation.field.FieldConsoleRender;
import org.simulation.field.FieldUtils;

import java.util.Map;

public class Simulation {
    private final Field field;

    private FieldConsoleRender fieldConsoleRender = new FieldConsoleRender();

    public Simulation(Field field) {
        this.field = field;
    }

    public void simulationLoop() {
        Action simulationAction = new Action(field);
        simulationAction.initAction();
        fieldConsoleRender.render(field);

        while (!isSimulationEnd()) {
            simulationAction.turnAction();
            if (!field.hasGrass()) {
                FieldUtils.addGrassForRandomCoordinate(field);
            }
            fieldConsoleRender.render(field);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isSimulationEnd() {
        int herbivoreCounter = 0;
        for(Map.Entry<Coordinates, Entity> entry : field.getEntities().entrySet()) {
            if (entry.getValue() instanceof Herbivore) {
                herbivoreCounter++;
            }
        }
        return herbivoreCounter == 0;
    }

}
