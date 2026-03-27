package ru.kuzmin.spring.METOD_3_JAVA;

public class Car {
    public Wheel wheel;
    public Engine engine;
    public Accumulator accumulator;
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
        return "Car Status (Java Config):\n- " + wheel + "\n- " + engine + "\n- " + accumulator + "\n- " + suspension;
    }
}