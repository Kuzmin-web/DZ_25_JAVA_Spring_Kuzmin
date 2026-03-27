//Необходимо создать объект класса Car, который состоит из следующих частей Wheel, Engine,
// который состоит из starter,  spark plug, Accumulator
//Suspension, который состоит из hinge, differential
//выполнить внедрение зависимостей тремя способами (через xml, xml + java annotation + java code)
//вывести на консоль объект класса Car
//В каждом классе необходимо переопределить метод toString(), для информативности

package ru.kuzmin.spring.METOD_2_MIXED;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main_2_MIXED {
    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext mixedCtx =
                    new AnnotationConfigApplicationContext("ru.kuzmin.spring.METOD_2_MIXED");

            System.out.println("MODE 2 (ANNOTATION):");
            System.out.println(mixedCtx.getBean(Car.class));

            mixedCtx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}