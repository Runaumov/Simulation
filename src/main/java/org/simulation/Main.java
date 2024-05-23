package org.simulation;

import org.simulation.field.Field;

public class Main {

    public static void main( String[] args ) {
        Field field = new Field(10, 10);
        Simulation simulation = new Simulation(field);
        simulation.simulationLoop();
    }
}
    