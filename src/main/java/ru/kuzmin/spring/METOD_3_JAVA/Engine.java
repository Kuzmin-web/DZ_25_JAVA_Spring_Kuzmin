package ru.kuzmin.spring.METOD_3_JAVA;

public class Engine {
    public Starter starter;
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