package ru.kuzmin.spring.METOD_3_JAVA;

public class Suspension {
    public Hinge hinge;
    public Differential differential;

    public void setHinge(Hinge hinge) {
        this.hinge = hinge;
    }

    public void setDifferential(Differential differential) {
        this.differential = differential;
    }

    @Override
    public String toString() {
        return "Suspension [hinge=" + hinge + ", differential=" + differential + "]";
    }
}