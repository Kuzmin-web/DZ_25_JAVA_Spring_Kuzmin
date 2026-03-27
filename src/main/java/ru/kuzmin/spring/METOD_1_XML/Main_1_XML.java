//Необходимо создать объект класса Car, который состоит из следующих частей Wheel, Engine,
// который состоит из starter,  spark plug, Accumulator
//Suspension, который состоит из hinge, differential
//выполнить внедрение зависимостей тремя способами (через xml, xml + java annotation + java code)
//вывести на консоль объект класса Car
//В каждом классе необходимо переопределить метод toString(), для информативности

package ru.kuzmin.spring.METOD_1_XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// ВОТ ЭТОТ ИМПОРТ ОБЯЗАТЕЛЕН:
import ru.kuzmin.spring.METOD_1_XML.Car;

public class Main_1_XML {
    public static void main(String[] args) {
        try {
            ApplicationContext xmlCtx = new ClassPathXmlApplicationContext("xml-config.xml");
            System.out.println("MODE 1 (XML):");
            System.out.println(xmlCtx.getBean(Car.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}