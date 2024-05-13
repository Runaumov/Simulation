package org.simulation;

import java.util.Random;

public class Simulation {
    private final Field field;

    private FieldConsoleRender fieldConsoleRender = new FieldConsoleRender();

    public Simulation(Field field) {
        this.field = field;
    }

    public void simulationLoop() {
        Action.initAction(field);
        fieldConsoleRender.render(field);

    }

}
