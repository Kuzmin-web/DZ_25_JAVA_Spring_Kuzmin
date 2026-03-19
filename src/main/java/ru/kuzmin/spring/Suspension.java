package ru.kuzmin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Suspension {
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
