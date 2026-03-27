package ru.kuzmin.spring.METOD_1_XML;

import org.springframework.beans.factory.annotation.Autowired;

public class Suspension {
    @Autowired
    public Hinge hinge;
    @Autowired
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
