//Необходимо разработать заглушку, обрабатывающие следующие запросы со стороны псевдо-тестируемой системы.
//
//Взаимодействие с заглушкой осуществляется через топики kafka
//
//топик на получение запросов в заглушку - test-topic
//
// топик на получение ответов в заглушку - test-topic2
//
//Формат отправки сообщений в топики Kafka (как показывал через терминал на лекции)
//
//1. Get /app/v1/getRequest?id={id}&name={name}, где id > 10 и длина name > 5. В случае если какое условие не выполняется вернуть InternalServerError и напечатать причину ошибки
//
//Вернуть тело ответа из текстового файла getAnswer.txt и подставив в него поле name
//
//2.Post /app/v1/postRequest body : {“name”: “{name}”, “surname”: “{surname}”, ”age”:{age}}
//
//где {name}, {surname}, {age} должны быть не пустыми, в противном случае вернуть InternalServerError
//
//Вернуть ответ из приложенного файла – postAnswer.txt, подставив в него данные из тела запроса
//
//В топики ответа должны приходить как успешные ответы, так и ошибки

package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Controllers", "Main", "Kafka"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}