package ru.kuzmin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Car {
    @Autowired
    public Wheel wheel;
    @Autowired
    public Engine engine;
    @Autowired
    public Accumulator accumulator;
    @Autowired
    public Suspension suspension;

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setAccumulator(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        return "Car Status:\n- " + wheel + "\n- " + engine + "\n- " + accumulator + "\n- " + suspension;
    }
}
