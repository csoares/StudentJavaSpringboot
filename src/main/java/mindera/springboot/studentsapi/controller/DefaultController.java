package mindera.springboot.studentsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public int returnAValue() {
        return 1;
    }


    @GetMapping("/exception")
    public void returnAnException() {
        throw new RuntimeException("This is an exception");
    }
}
