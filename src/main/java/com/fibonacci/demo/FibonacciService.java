package com.fibonacci.demo;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {


    public int fibonacciRecursion(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
    }


}
