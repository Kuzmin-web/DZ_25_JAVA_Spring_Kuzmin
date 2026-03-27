//Необходимо создать объект класса Car, который состоит из следующих частей Wheel, Engine,
// который состоит из starter,  spark plug, Accumulator
//Suspension, который состоит из hinge, differential
//выполнить внедрение зависимостей тремя способами (через xml, xml + java annotation + java code)
//вывести на консоль объект класса Car
//В каждом классе необходимо переопределить метод toString(), для информативности

package ru.kuzmin.spring.METOD_3_JAVA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main_3_JAVA {
    public static void main(String[] args) {
        try {
            ApplicationContext javaCtx = new AnnotationConfigApplicationContext(MyConfig.class);
            System.out.println("MODE 3 (JAVA):");
            System.out.println(javaCtx.getBean(Car.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}