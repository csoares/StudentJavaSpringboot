package mindera.mindswap.aveiro.module2.springboot.studentsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public int returnAValue(){
        return 1;
    }
}
