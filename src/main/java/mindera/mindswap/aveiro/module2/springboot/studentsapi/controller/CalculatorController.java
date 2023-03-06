package mindera.mindswap.aveiro.module2.springboot.studentsapi.controller;

import mindera.mindswap.aveiro.module2.springboot.studentsapi.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/calculator")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @GetMapping(path = "add/{num1}/{num2}")
    public int add(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return calculatorService.addTwoNumbers(num1, num2);
    }
}
