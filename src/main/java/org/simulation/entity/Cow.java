package org.simulation.entity;

public class Cow extends Herbivore {
    private static final int MAX_HP_COW = 20;
    public Cow() {
        super();
        this.hp = MAX_HP_COW;
    }

    @Override
    public String toString() {
        return "Cow (" +
                "hp=" + hp +
                ')';
    }

    @Override
    public void setMaxHp() {
        this.hp = MAX_HP_COW;
    }
}