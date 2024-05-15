package org.simulation;

import org.simulation.entity.Creature;
import org.simulation.entity.Entity;
import org.simulation.entity.Grass;
import org.simulation.field.Field;
import org.simulation.field.FieldConsoleRender;

import java.util.Map;

public class Simulation {
    private final Field field;

    private FieldConsoleRender fieldConsoleRender = new FieldConsoleRender();

    public Simulation(Field field) {
        this.field = field;
    }

    public void simulationLoop() {
        Action.testInitAction(field);
        fieldConsoleRender.render(field);

        for (int i = 0; i < field.getY() + 3; i++) {
            Action.turnAction(field);
            fieldConsoleRender.render(field);
        }

    }


}
