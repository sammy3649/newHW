package pro.sky.java.course2.newhw.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.newhw.service.CalculatorService;

@Service
public class CalculatorServiceimpl implements CalculatorService {
    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
    @Override
    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }
    @Override
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }
    @Override
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return num1 / num2;
    }


}
