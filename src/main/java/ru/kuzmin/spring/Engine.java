package ru.kuzmin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    @Autowired
    public Starter starter;
    @Autowired
    public SparkPlug sparkPlug;

    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    public void setSparkPlug(SparkPlug sparkPlug) {
        this.sparkPlug = sparkPlug;
    }

    @Override
    public String toString() {
        return "Engine [starter=" + starter + ", sparkPlug=" + sparkPlug + "]";
    }
}
