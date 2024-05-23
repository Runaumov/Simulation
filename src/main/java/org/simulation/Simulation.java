package org.simulation;

import org.simulation.entity.Entity;
import org.simulation.entity.Herbivore;
import org.simulation.field.Field;
import org.simulation.field.FieldConsoleRender;

import java.util.Map;

public class Simulation {
    private final Field field;
    private final FieldConsoleRender fieldConsoleRender;
    private final MessageBox messageBox;

    public Simulation(Field field) {
        this.field = field;
        this.fieldConsoleRender = new FieldConsoleRender();
        this.messageBox = new MessageBox();
    }

    public void simulationLoop() {
        Action simulationAction = new Action(field);
        simulationAction.initAction();
        fieldConsoleRender.render(field);

        while (!isSimulationEnd()) {
            simulationAction.turnAction();
            fieldConsoleRender.render(field);
            messageBox.getMessage();
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
