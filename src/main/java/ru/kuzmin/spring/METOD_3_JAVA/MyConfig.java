package ru.kuzmin.spring.METOD_3_JAVA;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Wheel wheel() {
        return new Wheel();
    }

    @Bean
    public Accumulator accumulator() {
        return new Accumulator();
    }

    @Bean
    public SparkPlug sparkPlug() {
        return new SparkPlug();
    }

    @Bean
    public Starter starter() {
        return new Starter();
    }

    @Bean
    public Hinge hinge() {
        return new Hinge();
    }

    @Bean
    public Differential differential() {
        return new Differential();
    }

    @Bean
    public Engine engine() {
        Engine engine = new Engine();
        engine.setStarter(starter());
        engine.setSparkPlug(sparkPlug());
        return engine;
    }

    @Bean
    public Suspension suspension() {
        Suspension suspension = new Suspension();
        suspension.setHinge(hinge());
        suspension.setDifferential(differential());
        return suspension;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setWheel(wheel());
        car.setEngine(engine());
        car.setAccumulator(accumulator());
        car.setSuspension(suspension());
        return car;
    }
}