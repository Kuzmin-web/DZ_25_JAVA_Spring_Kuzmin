package ru.kuzmin.spring.METOD_1_XML;

import org.springframework.beans.factory.annotation.Autowired;

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
