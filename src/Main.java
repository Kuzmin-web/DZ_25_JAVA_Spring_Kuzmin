//Необходимо создать объект класса Car, который состоит из следующих частей Wheel, Engine,
// который состоит из starter,  spark plug, Accumulator
//Suspension, который состоит из hinge, differential
//выполнить внедрение зависимостей тремя способами (через xml, xml + java annotation + java code)
//вывести на консоль объект класса Car
//В каждом классе необходимо переопределить метод toString(), для информативности

package ru.kuzmin.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try {
            ApplicationContext xmlCtx = new ClassPathXmlApplicationContext("xml-config.xml");
            System.out.println("MODE 1 (XML):");
            System.out.println(xmlCtx.getBean(Car.class));
        } catch (Exception e) {
            System.out.println("XML Error: " + e.getMessage());
        }

        try {
            ApplicationContext mixedCtx = new ClassPathXmlApplicationContext("mixed-config.xml");
            System.out.println("\nMODE 2 (MIXED):");
            System.out.println(mixedCtx.getBean(Car.class));
        } catch (Exception e) {
            System.out.println("Mixed Error: " + e.getMessage());
        }

        try {
            ApplicationContext javaCtx = new AnnotationConfigApplicationContext(MyConfig.class);
            System.out.println("\nMODE 3 (JAVA):");
            System.out.println(javaCtx.getBean(Car.class));
        } catch (Exception e) {
            System.out.println("Java Error: " + e.getMessage());
        }
    }
}