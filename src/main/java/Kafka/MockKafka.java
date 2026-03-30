package Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class MockKafka {

    private final KafkaTemplate<String, String> kafka;
    private final ObjectMapper mapper = new ObjectMapper();

    public MockKafka(KafkaTemplate<String, String> kafka) {
        this.kafka = kafka;
    }

    @KafkaListener(topics = "test-topic", groupId = "group1")
    public void listen(String msg) {
        System.out.println("\n[KAFKA] IN: " + msg);
        String resp;
        try {
            if (msg.contains("getRequest")) {
                String name = msg.split("name=")[1].split("&")[0].split(" ")[0];
                String idStr = msg.split("id=")[1].split("&")[0].split(" ")[0];
                int id = Integer.parseInt(idStr);

                if (id <= 10) {
                    resp = "InternalServerError: id должен быть > 10";
                } else if (name.length() <= 5) {
                    resp = "InternalServerError: длина name должна быть > 5";
                } else {
                    String content = Files.readString(Paths.get("src/main/resources/getAnswer.txt"));
                    resp = content.replace("{name}", name).replace("{id}", idStr);
                }
            } else if (msg.contains("postRequest")) {
                int jsonStart = msg.indexOf("{");
                if (jsonStart == -1) throw new Exception("JSON не найден");

                Map<String, Object> body = mapper.readValue(msg.substring(jsonStart), Map.class);
                String n = String.valueOf(body.get("name"));
                String s = String.valueOf(body.get("surname"));
                Object ageObj = body.get("age");

                if (n.equals("null") || s.equals("null") || ageObj == null) {
                    resp = "InternalServerError: Поля name, surname и age обязательны";
                } else {
                    int age = Integer.parseInt(String.valueOf(ageObj));
                    String content = Files.readString(Paths.get("src/main/resources/postAnswer.txt"));
                    resp = content.replace("{name}", n)
                            .replace("{surname}", s)
                            .replace("{age}*2", String.valueOf(age * 2))
                            .replace("{age}", String.valueOf(age));
                }
            } else {
                resp = "InternalServerError: Неизвестный формат сообщения";
            }
        } catch (Exception e) {
            resp = "InternalServerError: " + e.getMessage();
        }

        System.out.println("[KAFKA] OUT: " + resp);
        kafka.send("test-topic2", resp);
    }
}