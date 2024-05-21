package org.simulation;

import org.simulation.field.Field;

import javax.swing.*;
import java.awt.*;


public class SimulationApp extends JFrame {
    private Field field;
    private Simulation simulation;
    private FieldPanel fieldPanel;

    public SimulationApp(Field field) {
        this.field = field;
        this.fieldPanel = new FieldPanel(field);
        this.simulation = new Simulation(field, this::repaintField);

        setTitle("Field Simulation");
        //setSize(fieldPanel.getWidth() + 100, fieldPanel.getHeight() + 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(fieldPanel);
        pack();
        setVisible(true);

        startSimulation();
    }

    private void startSimulation() {
        Thread simulationThread = new Thread(() -> simulation.simulationLoop());
        simulationThread.setDaemon(true);
        simulationThread.start();
    }

    private void repaintField() {
        SwingUtilities.invokeLater(() -> fieldPanel.repaint());
    }

    public static void main(String[] args) {
        Field field = new Field(20, 20);
        new SimulationApp(field);
    }
}