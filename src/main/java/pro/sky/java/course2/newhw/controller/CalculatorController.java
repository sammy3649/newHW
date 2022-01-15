package pro.sky.java.course2.newhw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.newhw.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public String outputGreetings() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping( "/plus")
    public String sumNum(@RequestParam int num1, @RequestParam int num2, @RequestParam int num3) {
        int total = calculatorService.sum(num1, num2) + num3;
        return generateMessage(num1, num2, '+', total);
    }

    @GetMapping( "/minus")
    public String subtractionNum(@RequestParam int num1, @RequestParam int num2) {
        int total = calculatorService.subtraction(num1, num2);
        return generateMessage(num1, num2, '-', total);
    }
    @GetMapping( "/multiplication")
    public String multiplicationNu (@RequestParam int num1, @RequestParam int num2) {
        int total = calculatorService.multiplication(num1, num2);
        return generateMessage(num1, num2, '*', total);
    }
    @GetMapping("/divide")
    public String divideNum(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "<h1>Делить на 0 нельзя!</h1>";
        }
        int total = calculatorService.divide(num1, num2);
        return generateMessage(num1, num2, '/', total);
    }
    private String generateMessage(int num1, int num2, char c, int total) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, c, num2, total);
    }
}
