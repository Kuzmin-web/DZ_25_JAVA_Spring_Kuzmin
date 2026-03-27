package Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/app/v1")
public class MockControllers {

    @GetMapping("/getRequest")
    public ResponseEntity<String> getRequest(@RequestParam int id, @RequestParam String name) {
        try {
            Thread.sleep((id > 10 && id < 50) ? 1000 : 500);

            if (id <= 10) return error("id должен быть > 10");
            if (name.length() <= 5) return error("длина name должна быть > 5");


            String content = Files.readString(Paths.get("src/main/resources/getAnswer.txt"));
            String result = content.replace("{id}", String.valueOf(id))
                    .replace("{name}", name);

            return ResponseEntity.ok(result);
        } catch (Exception e) { return error(e.getMessage()); }
    }

    @PostMapping("/postRequest")
    public ResponseEntity<String> postRequest(@RequestBody Map<String, Object> body) {
        try {
            String n = String.valueOf(body.get("name"));
            String s = String.valueOf(body.get("surname"));
            String a = String.valueOf(body.get("age"));

            if (n.equals("null") || s.equals("null") || a.equals("null")) {
                return error("Поля name, surname и age обязательны");
            }


            String content = Files.readString(Paths.get("src/main/resources/postAnswer.txt"));
            String result = content.replace("{name}", n)
                    .replace("{surname}", s)
                    .replace("{age}", a);

            return ResponseEntity.ok(result);
        } catch (Exception e) { return error(e.getMessage()); }
    }

    private ResponseEntity<String> error(String msg) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + msg);
    }
}