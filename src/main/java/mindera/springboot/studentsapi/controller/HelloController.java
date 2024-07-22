package mindera.springboot.studentsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @GetMapping(path = "hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping(path = "hello-list")
    public List<String> helloList() {
        return List.of("hello", "world", "!");
    }
}
