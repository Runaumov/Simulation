package org.simulation;

import org.simulation.field.Field;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        Field field = new Field(4, 4);
        Simulation simulation = new Simulation(field);
        simulation.simulationLoop();
        int a = 1;
    }
}
    