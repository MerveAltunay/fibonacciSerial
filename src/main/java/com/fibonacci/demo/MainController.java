package com.fibonacci.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/api")
public class MainController {

    @Autowired
    private FibonacciService fibonacciService;


    @GetMapping("/register")
    public String showForm(Model model){

        Fibonacci fibonacci = new Fibonacci();

        model.addAttribute("fibonacci",fibonacci);

        return "fibonacci_form";
    }

    @GetMapping("/fibonacci")
    public String fibonacci(@ModelAttribute("fibonacci") Fibonacci fibonacci){


        int number = Integer.parseInt(fibonacci.getNumber());

        for(int i=0;i<=number;i++){

            String result = String.valueOf(fibonacciService.fibonacciRecursion(i));
            fibonacci.setResult(result);
        }

        return "fibonacci_success";
    }


}
