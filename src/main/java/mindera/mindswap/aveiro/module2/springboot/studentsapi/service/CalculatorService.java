package mindera.mindswap.aveiro.module2.springboot.studentsapi.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int addTwoNumbers(int num1, int num2){
        // validation of int / overflow...
        return num1+num2;
    }

    public int subtractNumbers(int num1, int num2) {
        return num1-num2;
    }
}
