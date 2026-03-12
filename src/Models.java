package ru.kuzmin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Wheel {
    @Override
    public String toString() { return "Wheel"; }
}

@Component
class Starter {
    @Override
    public String toString() { return "Starter"; }
}

@Component
class SparkPlug {
    @Override
    public String toString() { return "SparkPlug"; }
}

@Component
class Accumulator {
    @Override
    public String toString() { return "Accumulator"; }
}

@Component
class Hinge {
    @Override
    public String toString() { return "Hinge"; }
}

@Component
class Differential {
    @Override
    public String toString() { return "Differential"; }
}

@Component
class Engine {
    @Autowired public Starter starter;
    @Autowired public SparkPlug sparkPlug;

    public void setStarter(Starter starter) { this.starter = starter; }
    public void setSparkPlug(SparkPlug sparkPlug) { this.sparkPlug = sparkPlug; }

    @Override
    public String toString() {
        return "Engine [starter=" + starter + ", sparkPlug=" + sparkPlug + "]";
    }
}

@Component
class Suspension {
    @Autowired public Hinge hinge;
    @Autowired public Differential differential;

    public void setHinge(Hinge hinge) { this.hinge = hinge; }
    public void setDifferential(Differential differential) { this.differential = differential; }

    @Override
    public String toString() {
        return "Suspension [hinge=" + hinge + ", differential=" + differential + "]";
    }
}

@Component
class Car {
    @Autowired public Wheel wheel;
    @Autowired public Engine engine;
    @Autowired public Accumulator accumulator;
    @Autowired public Suspension suspension;

    public void setWheel(Wheel wheel) { this.wheel = wheel; }
    public void setEngine(Engine engine) { this.engine = engine; }
    public void setAccumulator(Accumulator accumulator) { this.accumulator = accumulator; }
    public void setSuspension(Suspension suspension) { this.suspension = suspension; }

    @Override
    public String toString() {
        return "Car Status:\n- " + wheel + "\n- " + engine + "\n- " + accumulator + "\n- " + suspension;
    }
}