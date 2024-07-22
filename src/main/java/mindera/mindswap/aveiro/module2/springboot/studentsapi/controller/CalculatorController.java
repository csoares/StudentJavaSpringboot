package mindera.mindswap.aveiro.module2.springboot.studentsapi.controller;

import mindera.mindswap.aveiro.module2.springboot.studentsapi.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/calculator")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;


    @GetMapping(path = "add/{num1}/{num2}")
    public int add(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return calculatorService.addTwoNumbers(num1, num2);
    }

    @GetMapping(path ="subtract/{num1}/{num2}")
    public int subtract(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return calculatorService.subtractNumbers(num1,num2);
    }

    @GetMapping(path = "multiply/{num1}/{num2}")
    public int multiply(@PathVariable("num1") int a, @PathVariable("num2") int num2) {
        return calculatorService.multiplyNumbers(a, num2);
    }

}
